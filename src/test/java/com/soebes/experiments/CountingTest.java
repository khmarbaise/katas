package com.soebes.experiments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CountingTest {

    int counting(int max) {
        int total = 0;
        for (int i = 0; i < max; i++) {
            total += i * 10;
        }
        return total;
    }

    int counting2(int max) {
        return IntStream.range(0, max).reduce(0, (acc, y) -> acc + y * 10);
    }

    @Test
    @DisplayName("Das ist ein Test")
    void firstTest() {
        int counting = counting(10);
        assertThat(counting).isEqualTo(450);
    }

    @Test
    void secondTest() {
        int counting = counting2(10);
        assertThat(counting).isEqualTo(450);
    }
}
