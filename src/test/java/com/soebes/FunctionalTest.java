package com.soebes;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;
import java.util.stream.Stream;

class FunctionalTest {

  Predicate<String> isHello = s -> s.equals("Hello");
  Predicate<String> containsNoExclamationMark = s -> !s.contains("!");

  @Test
  void name() {
    Stream.of("Hello", "World!", "Code!", "LEARN!", "hub")
        .filter(isHello.or(containsNoExclamationMark).negate())
        .forEach(System.out::println);
  }

}
