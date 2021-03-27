package com.soebes.arrays;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class ArrayTest {

  @Test
  void name() {
    String[] names = {"John", "Luke", "Matthew", "Mark"};

    var newNames = Stream.of(names)
        .filter(n -> n.contains("e"))
        .map(String::toUpperCase)
        .toArray(String[]::new);

    Stream.of(newNames).forEach(System.out::println);
  }
}
