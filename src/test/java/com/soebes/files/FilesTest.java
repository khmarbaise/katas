package com.soebes.files;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

class FilesTest {

//  @Test
//  void name() throws URISyntaxException, IOException {
//    final URL resource = this
//      .getClass()
//      .getResource("/test.txt");
//    final Stream<String> lines = Files.readString(Path.of(resource.toURI())).skip(1).filter(not(EndOfFile));
//
//    lines.forEach(s -> System.out.println("s = " + s));
//
//  }

  private Predicate<String> EndOfFile = s -> s.startsWith("eof");


  @Test
  void first() {
  }
}
