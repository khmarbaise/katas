package com.soebes.katas;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

class MapSortedValues {

  @Test
  void name() {
    Map<String, Integer> maps = new HashMap<>();

        maps.put("A", 100);
        maps.put("B", 2);
        maps.put("C", 7);
        maps.put("D", 10);
        maps.put("CD", 50);
        maps.put("X", 70);
        maps.put("AA", 500);
        maps.put("ZA", 676);
        maps.put("U", 2350);
        maps.put("I", 1);
        maps.put("ZZZZ", 0);

    printMap(maps);
    System.out.println("----------------------------------------------");
    maps.entrySet()
        .stream()
        .sorted(comparingByValue()).forEach(s -> System.out.println("key:" + s.getKey() + " v:" + s.getValue()));
    System.out.println("----------------------------------------------");

    List<Map.Entry<String, Integer>> collect = maps.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
    System.out.println("----------------------------------------------");

    collect.get(2).setValue(22222);
    printMap(maps);
  }

  private void printMap(Map<String, Integer> maps) {
    maps.entrySet().forEach(s -> System.out.println("k: " + s.getKey() + " v:" + s.getValue()));
  }
}
