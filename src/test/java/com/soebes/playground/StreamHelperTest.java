package com.soebes.playground;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class StreamHelperTest {

  private final List<String> FIRST_LIST_OF_STRING = List.of("A", "B", "C", "D", "E", "F");
  private final List<String> SECOND_LIST_OF_STRING = List.of("A", "B", "B", "C", "D", "E", "F");

  // VARIANT 1
  public static <T> Collector<T, ?, Optional<T>> zeroOrOne() {
    return Collectors.reducing((a, b) -> {
      throw new IllegalStateException("More than one value was returned.");
    });
  }

  public static <T> Collector<T, ?, T> onlyOne() {
    return Collectors.collectingAndThen(zeroOrOne(), Optional::get);
  }

  // VARIANT 2:
  public static <T> BinaryOperator<T> singleElement() {
    return singleElementThrowing(IllegalArgumentException::new);
  }

  public static <T, E extends RuntimeException> BinaryOperator<T> singleElementThrowing(Supplier<E> exception) {
    return (element, otherElement) -> {
      throw exception.get();
    };
  }

  @Nested
  class VariantOne {
    @Test
    void first_test() {
      assertThatCode(() ->
          FIRST_LIST_OF_STRING.stream().filter(s -> s.equals("B")).collect(onlyOne())).doesNotThrowAnyException();
    }

    @Test
    void second_test() {
      assertThatIllegalStateException().isThrownBy(() -> SECOND_LIST_OF_STRING.stream().filter(s -> s.equals("B")).collect(onlyOne()))
          .withMessage("More than one value was returned.");
    }
  }

  @Nested
  class VariantTwo {

    @Test
    void first_test() {
      assertThatCode(() -> FIRST_LIST_OF_STRING.stream()
          .filter(s -> s.equals("B"))
          .reduce(singleElement()))
          .doesNotThrowAnyException();
    }

    @Test
    void second_test() {
      assertThatExceptionOfType(DuplicateElementException.class)
          .isThrownBy(() -> SECOND_LIST_OF_STRING.stream()
              .filter(s -> s.equals("B"))
              .reduce(singleElementThrowing(DuplicateElementException::new)));
    }

    @Test
    void name() {
      String b = FIRST_LIST_OF_STRING.stream()
          .filter(s -> s.equals("B"))
          .reduce(singleElementThrowing(DuplicateElementException::new))
          .orElseThrow(() -> new IllegalStateException("Does not exist"));
    }
  }

}
