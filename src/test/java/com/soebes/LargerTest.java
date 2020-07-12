package com.soebes;

import org.junit.jupiter.api.Test;

class LargerTest {

  @Test
  void name() {
    float f = Float.MAX_VALUE;
    Long l = Long.valueOf(Long.MAX_VALUE);


    Float aFloat = Float.valueOf(l);
    System.out.println("aFloat = " + aFloat);
    System.out.println("f = " + f);
    System.out.println("l = " + l);
    float floatFromLong = Long.valueOf(Long.MAX_VALUE).floatValue();
    float floatMax = Float.MAX_VALUE;
    System.out.println("floatFromLong = " + floatFromLong);
    System.out.println("floatMax = " + floatMax);
  }
}
