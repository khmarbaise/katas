package com.soebes.compare;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComplexTest {

  private static final Offset<Double> EPSILON = Offset.offset(1E-10);

  @Test
  void name() {
    Complex complex = new Complex(0.0d, 1.0d);
    assertThat(complex.getIm()).isEqualTo(1.0d, EPSILON);
    assertThat(complex.getRe()).isEqualTo(0.0d, EPSILON);
  }

}
