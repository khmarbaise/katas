package com.soebes.java;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

public class JavaKeepInsertionOrderTest {

  @Test
  void no_order() {
    Map<String, Integer> collect = IntStream.range(0, 10).collect(HashMap::new,
      // m.size() = 0, 1, 2, 3, 4...
      (m, v) -> m.put(UUID.randomUUID().toString(), m.size()), (m, m2) -> {
      });

    collect.forEach((k, v) -> System.out.println(k + ":" + v));
  }

  @Test
  void keep_the_order() {

    Map<String, Integer> collect = IntStream.range(0, 10)
      .collect(LinkedHashMap::new, (m, v) -> m.put(UUID.randomUUID().toString(), m.size()), (m, m2) -> {
      });

    collect.forEach((k, v) -> System.out.println(k + ":" + v));
  }

  //  @Test
  //  void an_other_option() {
  //    IntStream.range(0, 10).collect(collectingAndThen(Collectors.toList(), LinkedHashMap::new));
  //  }

//  @Test
//  void an_other_option() {
//    IntStream.range(0, 10).collect(LinkedHashMap::new, (linkedHashMap, value) -> linkedHashMap.put(UUID.randomUUID().toString(), linkedHashMap.size()), BiConsumer::accept);
//  }
}
