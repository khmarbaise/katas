package com.soebes.formatting;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class FormattingTest {


  private static final List<String> STRING_LIST = List.of("a", "b", "c");

  @Test
  void using_formatted_as_usual() {
    var formatted = "(%d, %d)".formatted(5, 7);
    System.out.println("formatted = " + formatted);
  }

  @Test
  void using_formatted_in_stream() {
    var collect = STRING_LIST.stream().map("(%s)"::formatted).collect(Collectors.joining(","));
    System.out.println("collect = " + collect);
  }
}
