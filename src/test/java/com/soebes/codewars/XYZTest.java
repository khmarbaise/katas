package com.soebes.codewars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class XYZTest {
    @Test
    void first() {
        boolean xx = Boolean.getBoolean("XX");
        assertThat(xx).isTrue();
    }
}
