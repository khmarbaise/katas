package com.soebes.tricks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.pow;

class DataTypesTest {

  @Test
  void name() {
    double v = 0x0.DP+0;
    System.out.println("v = " + v);
    List<? extends Number> numbers = Arrays.asList(-0, +0, -0L, +0L, -0F, 0F, -0D, 0D, 0xF, 0xD, 0x0.DP+0);

    numbers.stream().forEach(number -> System.out.println("number = " + number));
    Set<Number> set = new HashSet<>(numbers);
    System.out.println(set.size());

    set.stream().forEach(o -> System.out.println("o = " + o));
  }

  @Test
  void testing_floating_via_hex_literals() {
    var v = 0x32.1P2f;
    var result = ((3.0*16.0+2.0) + 1.0/16.0) * pow(2.0, 2.0);
    System.out.println("v = " + v);
    System.out.println("result = " + result);
  }

  @Test
  void floating_xx() {
    var v = 0x0.2P+0d;

    System.out.println("v = " + v);
    var v1 = 2/16.0;
    System.out.println("v1 = " + v1);
  }
}
