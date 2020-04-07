package com.soebes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class LineProcessingTest {


  @Test
  void first() {
    var lines = List.of("---", "tag: [1]", "description: test", "---", "Line 1 " +
      "Content", "Line 2 Content");

    System.out.println(lines.stream().collect(joining(System.lineSeparator())));

    System.out.println("---------------------------------------------------");
    List<String> stringStream = lines.stream()
      .dropWhile(line -> !line.startsWith("---"))
      .skip(1)
      .takeWhile(line -> !line.startsWith("---"))
      .collect(toList());


    System.out.println(stringStream.stream().collect(joining(System.lineSeparator())));

  }
}
