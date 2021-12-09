package com.soebes.popcount;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record XTest() {

  record A(String id, String team, String nickname) {
  }

  @Test
  void name() {
    List<A> list = Arrays.asList(
        new A("01", "White", "Fox"),
        new A("01", "White", "Mouse"),
        new A("01", "White", "Rabbit"),
        new A("02", "Blue", "Mouse"),
        new A("03", "Yellow", "Shark"),
        new A("03", "Yellow", "Shark")
    );

    Map<String, List<A>> collect = list.stream().collect(Collectors.groupingBy(k -> k.id()));
    collect.entrySet().stream().forEachOrdered(s -> {
      System.out.println(" key = " + s.getKey());
      s.getValue().stream().forEachOrdered(v -> System.out.println("Item: " + v));
    });
  }
}
