package com.soebes.consumer;

import org.junit.jupiter.api.Test;

import java.util.List;

class PartitioningTest {

  private static final List<String> ITEMS = List.of("A", "B", "#", "C", "#");

  @Test
  void first_test() {
    List<List<String>> collect = ITEMS.stream().collect(new PartitioningCollector<>());
    collect.forEach(strings -> {
          System.out.println("-----");
          strings.forEach(s -> System.out.println("s = " + s));
        }
    );
  }
}
