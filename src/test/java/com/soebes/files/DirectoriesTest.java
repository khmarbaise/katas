package com.soebes.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class DirectoriesTest {

  @Test
  void first() {
    File d = new File(".");
    File[] files = d.listFiles();
    Arrays.stream(files)
        .filter(File::isDirectory)
        .sorted(Comparator.comparing(File::lastModified).reversed())
        .limit(12)
        .map(File::getName)
        .map(s -> s.substring(0, s.lastIndexOf('-') - 5))
        .forEach(System.out::println);
  }

  @Test
  void second() throws IOException {
    Path p = Path.of(".");
    Stream<Path> list = Files.list(p);
  }
}
