package com.soebes.bigdecimals;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class BigDecimalTest {

  @Test
  void compare_two_bigdecimals() {
    BigDecimal bd1 = new BigDecimal("1.0");
    BigDecimal bd2 = new BigDecimal("1.00");

    assertThat(bd1.equals(bd2)).isTrue();
  }

}
