package com.soebes.katas;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ReadAndWriteFile {

  public static void main(String[] args) {
    try {
      var tempFile = Files.createTempFile("testFile", ".txt");

      Files.writeString(tempFile, "This is my first tmp file", Charset.defaultCharset(), StandardOpenOption.WRITE);

      var fileContent = Files.readString(tempFile);

      System.out.println("fileContent = " + fileContent);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
