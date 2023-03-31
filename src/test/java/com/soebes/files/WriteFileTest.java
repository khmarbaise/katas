package com.soebes.files;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

class WriteFileTest {

  @Test
  void name() throws IOException {

    var file = Files.createFile(Path.of("test.txt"));
    Files.write(file, List.of("Hello"));
    Files.writeString(file, "1. Zeile");
    Files.writeString(file, "2. Zeile", StandardOpenOption.APPEND);
  }

  @Test
  void another_way_to_write_to_a_file_list() throws IOException {
    var path = Paths.get("hello.txt");
    Files.write(path, List.of("Line1"));
  }

  @Test
  void with_getbytes() throws IOException {
    var path = Paths.get("hello.txt");
    Files.write(path, "Hello".getBytes());
  }

  @Test
  void another_way_to_write_to_a_file() throws IOException {
    var path = Paths.get("hello.txt");
    Files.writeString(path, "Hello");
  }

  @Test
  void j7_style() throws IOException {
    var path = Paths.get("hello.txt");
    try (var bw = Files.newBufferedWriter(path)) {
      bw.append("Hello");
    }
  }
}
