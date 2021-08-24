package com.soebes.limits;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Testing based on article:
 * https://habr.com/ru/post/574082/
 */
class PlusNullMinusNullTest {

  public static double abs(double value) {
    if (value < 0) {
      return -value;
    }
    return value;
  }

  public static double absViaBits(double value) {
    return Double.longBitsToDouble(
        Double.doubleToRawLongBits(value) & 0x7fffffffffffffffL);
  }

  @Test
  void name() {
    double x = -0.0;
    if (1 / abs(x) < 0) {
      System.out.println("oops");
    }
  }

  boolean check(double x) {
    return 1 / abs(x) < 0;
  }

  @Test
  void check_for_values() {
    boolean check = check(-0.0);
    assertThat(check).isTrue();
  }

  @Test
  void check_for_values_bits() {
    double v = absViaBits(-0.0);
    assertThat(v).isZero();
  }
}
