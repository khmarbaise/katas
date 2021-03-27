package com.soebes.limits;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class ConversionTest {

  @Test
  void name() {
    double d1 = 11.7;
    float f1 = (float) d1;
    double d2 = f1;
    System.out.println("d1 = " + d1);
    System.out.println("f1 = " + f1);
    System.out.println("d2 = " + d2);

    double d3 = BigDecimal.valueOf(d2).setScale(1, RoundingMode.DOWN).doubleValue();
    System.out.println("d3 = " + d3);

    BigDecimal bd = BigDecimal.valueOf(d2);

    System.out.println("bd = " + bd);
    System.out.println("bd = " + bd.toEngineeringString() + " " + bd.toPlainString());

    double dalpha = 11.7;

    System.out.println("dalpha = " + dalpha);

  }
}
