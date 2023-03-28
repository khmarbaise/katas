package com.soebes;

import org.junit.jupiter.api.Test;

class LambdaTest {

  @FunctionalInterface
  public interface XZ {
    int apply() throws IllegalAccessError;
  }
  @Test
  void name() {
    var ints = new int[0];
    System.out.println(ints[0]);
  }
}
