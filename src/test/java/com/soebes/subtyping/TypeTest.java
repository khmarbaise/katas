package com.soebes.subtyping;

import org.junit.jupiter.api.Test;

class TypeTest {

  @Test
  void covariance() {

    Number[] numbers = new Number[3];
    numbers[0] = Integer.valueOf(10);
    numbers[1] = Double.valueOf(3.14);
    numbers[2] = Byte.valueOf((byte) 0);
  }

  @Test
  void subtypingRule() {
    Number[] integers = new Integer[5];

    integers[3] = 5.14;
  }
}
