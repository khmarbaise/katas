package com.soebes.katas.numeric;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

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
}
