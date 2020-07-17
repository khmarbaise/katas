package com.soebes.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class UniqueElementsTest {

  private static final List<String> Elements = List.of("Java", "Kotlin", "Scala", "Groovy", "Ceylon", "Java", "JRuby");

  @Test
  void name() {
    // Short Circuit evaluation based on addiere behaviour.
    boolean b = Elements.stream().allMatch(ConcurrentHashMap.newKeySet()::add);
    System.out.println("b = " + b);
  }
}
