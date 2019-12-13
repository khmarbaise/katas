package com.soebes.puzzles;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class FirstTest {

  @Test
  void name() {
    BigDecimal value = BigDecimal.valueOf(1000.111);

    var result = value.scale() == 0
      ? value.longValue()
      : value.doubleValue();

    System.out.println("result = " + result);
    System.out.println("value.scale() = " + value.scale());
  }
}
