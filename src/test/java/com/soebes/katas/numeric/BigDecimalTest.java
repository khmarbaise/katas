package com.soebes.katas.numeric;

import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class BigDecimalTest {

    @Test
    void firstTest() {
        BigDecimal val = BigDecimal.valueOf(100L);
        long l = val.longValue();
        assertThat(l).isEqualTo(100L);
    }
    @Test
    void nullTest() {
        BigDecimal val = null;
        long l = val.longValue();
        assertThat(l).isEqualTo(100L);
    }

    @Test
    void compare_with_is_close_to() {
        BigDecimal first = new BigDecimal("12345.56");
        BigDecimal second = new BigDecimal("12345.56001000001");

        assertThat(first).isCloseTo(second, Percentage.withPercentage(0.01));
        assertThat(first).isCloseTo(second, within(new BigDecimal("0.0001")));
    }

    @Test
    void compare_with_is_equal_to() {
        BigDecimal first = new BigDecimal("12345.56");
        BigDecimal second = new BigDecimal("12345.560");

        assertThat(first).isEqualTo(second);
    }

    @Test
    void compare_double_with() {
        double first = 2.3456;
        double second = 2.3456001001;

        assertThat(first).isEqualTo(second, Offset.offset(1E-6));
    }

    @Test
    void name() {
        BigDecimal first = new BigDecimal("1.23456");
        BigDecimal second = new BigDecimal("1.234560");
        assertThat(first).isEqualTo(second);
    }
    @Test
    void second_test_with_compare_to() {
        BigDecimal first = new BigDecimal("1.23456");
        BigDecimal second = new BigDecimal("1.234560");
        assertThat(first).isEqualByComparingTo(second);
    }
}
