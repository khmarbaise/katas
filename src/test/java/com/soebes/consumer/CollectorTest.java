package com.soebes.consumer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class CollectorTest {

  class XT {
    private String value;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      XT xt = (XT) o;
      return Objects.equals(value, xt.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value);
    }

    public XT() {
      this.value = "";
    }
    public void add(Integer codePoint) {
      this.value += Character.toString(codePoint);
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", XT.class.getSimpleName() + "[", "]")
          .add("value='" + value + "'")
          .toString();
    }
  }
  @Test
  void collector_test() {
    Collector<Integer, XT, List<XT>> supplier = Collector.of(
        () -> {
          System.out.println("Supplier Called");
          return new XT();
        },
        (input, output) -> {
          System.out.println("Accumulator called input:'" + Integer.toHexString(Objects.hashCode(input)) + "' output:" + output);
          if (output == '{') {
            return;
          }
          if (output == '}') {
            return;
          }
          input.add(output);
        },
        (result1, result2) -> {
          System.out.println("combiner called: " + result1 + " result2:" + result2);
          return new XT();
        },
        (finisher) -> {
          System.out.println("finisher called. finisher:" + finisher);
          return List.of(finisher);
        }
    );
    String input = "{2/4}+{5/6}";
    List<XT> collect = input.codePoints().boxed().collect(supplier);
    System.out.println("collect = " + collect);

  }

  @Test
  void map_to_map_test() {
    List<String> a = List.of("A", "B", "C");
    Map<String, String> collect1 = a.stream().collect(Collectors.toMap(k -> k, v -> v));
    System.out.println("collect1 = " + collect1);

  }
}
