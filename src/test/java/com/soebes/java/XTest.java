package com.soebes.java;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

class XTest {

  Function<String, Character> lastLetter = s -> {
    if (s.isEmpty()) {
      throw new IllegalArgumentException("String must not be emppty.");
    }
    return s.charAt(s.length() - 1);
  };

  @Test
  void name() {
    String s = "abc";

    System.out.println("i = " + lastLetter.apply(s));
  }
}
