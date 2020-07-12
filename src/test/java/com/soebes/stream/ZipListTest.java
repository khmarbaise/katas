package com.soebes.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ZipListTest {


  private static final List<String> FIRST = List.of("JDK 1.0", "J2SE 1.2", "J2SE 5.0", "Java SE 8", "Java SE 11", "Java SE 14");
  private static final List<Integer> SECOND = List.of(1996, 1998, 2004, 2014, 2018, 2020);

  // PE CS
  // Producer Extends
  // Consumer Super
  public static <T1, T2, R> Stream<R> zip(List<T1> list1, List<T2> list2, BiFunction<? super T1, ? super T2, ? extends R> mapper) {
    int size = list1.size();
    if (size != list2.size()) {
      throw new IllegalArgumentException("The size of the list differs");
    }
    return IntStream.range(0, size).mapToObj(idx -> mapper.apply(list1.get(idx), list2.get(idx)));
  }

  @Test
  void name() {
    zip(FIRST, SECOND, (jdk, year) -> jdk + " was released in " + year).forEach(s -> System.out.println("s = " + s));
  }
}
