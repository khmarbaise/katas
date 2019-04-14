package com.soebes.limits;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LimitsTest {

    boolean calculateFirst(int k) {
        return (1 * k) > 0;
    }

    boolean calculateSecond(int k) {
        return (-1 * k) > 0;
    }

    @Nested
    public class CalculateSecondTest {
        @Test
        void testNr1() {
            assertThat(calculateSecond(5)).isFalse();
        }

        @Test
        void testNr2() {
            assertThat(calculateSecond(Integer.MAX_VALUE)).isFalse();
        }

        @Test
        void testNr3() {
            assertThat(calculateSecond(Integer.MIN_VALUE)).isTrue();
        }
    }

    @Nested
    public class CalculateFirstTest {
        @Test
        void testNr1() {
            assertThat(calculateFirst(5)).isTrue();
        }

        @Test
        void testNr2() {
            assertThat(calculateFirst(Integer.MAX_VALUE)).isTrue();
        }

        @Test
        void testNr3() {
            assertThat(calculateFirst(Integer.MIN_VALUE)).isFalse();
        }

        @Test
        void testNr4() {
            assertThat(calculateFirst(-5)).isFalse();
        }

    }

    @Nested
    public class LimitationsTest {
        @Test
        void testNr1Multiply() {
            int a = 5 * Integer.MAX_VALUE;
            System.out.println("result a=" + a);
        }
    }
}
