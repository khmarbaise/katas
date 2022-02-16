package com.soebes.limits;

import org.junit.jupiter.api.Test;

class XTest {

  @Test
  void name() {
    int i = Integer.MIN_VALUE;
    int result = -i;

    System.out.println("result = " + result);
  }
}
