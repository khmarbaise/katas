package com.soebes.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

class FilesTest {

  @Test
  void name() throws URISyntaxException, IOException {
    final URL resource = this
      .getClass()
      .getResource("/test.txt");
    final Stream<String> lines = Files.lines(Path.of(resource.toURI())).skip(1).filter(not(EndOfFile));

    lines.forEach(s -> System.out.println("s = " + s));

  }

  private Predicate<String> EndOfFile = s -> s.startsWith("eof");


  @Test
  void first() {
  }
}
