package com.soebes.formatting;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.Map.entry;

class FormattingTest {


  private static final List<String> STRING_LIST = List.of("a", "b", "c");

  @Test
  void using_formatted_as_usual() {
    var formatted = "(%d, %d)".formatted(5, 7);
    out.println("formatted = " + formatted);
  }

  @Test
  void using_formatted_in_stream() {
    var collect = STRING_LIST.stream().map("(%s)"::formatted).collect(Collectors.joining(","));
    out.println("collect = " + collect);
  }

  @Test
  void using_formatted_in_stream_with_map() {
    var maps = Map.ofEntries(entry("k1", "v1"), entry("k2", "v2"));
    var collect = maps.entrySet().stream()
        .map(es -> "(k:%s, v:%s)".formatted(es.getKey(), es.getValue()))
        .collect(Collectors.joining(","));
    out.println("collect = " + collect);
  }

  @Test
  void name() {
    IntStream.range(0, 10).forEach(i -> out.println("*".repeat(i)));
  }
}
