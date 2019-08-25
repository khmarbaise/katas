package com.soebes.playground;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class StreamExercisesTest implements AutoCloseable{

  static boolean isPrime(Integer item) {
    return true;
  }

  @Test
  void firstTest() {
    Stream.iterate(1, item -> item + 1)
          .filter(StreamExercisesTest::isPrime)
          .map(Math::sqrt)
          .limit(100)
          .collect(toList());
  }

  @Override
  public void close() throws Exception {
    System.out.println("close() has been called.");
  }
}
