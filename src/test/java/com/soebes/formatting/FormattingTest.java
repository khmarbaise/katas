package com.soebes.formatting;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

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
  void name() {
    IntStream.range(0, 10).forEach(i -> out.println("*".repeat(i)));
  }
}
