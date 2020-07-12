package com.soebes.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

class ListToMapTest {

  // Transform List<Map<K,V>> into Map<K, List<V>>

  static final List<Map<String, Long>> ENTRIES = List.of(
      ofEntries(entry("First", 2L), entry("Third", 7L)),
      ofEntries(entry("Second", 3L))
  );


  @Test
  void name() {
    Map<String, List<Long>> collect = ENTRIES.stream()
        .flatMap(map -> map.entrySet().stream())
        .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
    System.out.println("collect = " + collect);

  }
}

