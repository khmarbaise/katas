package com.soebes.codewars;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class XYZTest {

    private static final double EPSILON = 1E-6;
    @Test
    void first() {
        Double d = 1.345d;
        assertThat(d).isEqualTo(1.345, Offset.offset(1E-6));
        assertThat(d).isCloseTo(1.345, within(EPSILON));
        boolean xx = Boolean.getBoolean("XX");
        assertThat(xx).isTrue();
    }
}
