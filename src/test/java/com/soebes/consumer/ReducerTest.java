package com.soebes.consumer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class ReducerTest {
  @Test
  void reduce_test_first() {
    int reduce = IntStream
        .range(0, 20)
        .peek(s -> System.out.println("s = " + s))
        .reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);
    System.out.println("reduce = " + reduce);
  }
}
