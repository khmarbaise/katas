package com.soebes.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

class WriteFileTest {

  @Test
  void name() throws IOException {

    var file = Files.createFile(Path.of("test.txt"));
    Files.writeString(file, "1. Zeile", StandardOpenOption.APPEND);
    Files.writeString(file, "2. Zeile", StandardOpenOption.APPEND);
  }
}
