package com.soebes.codewars;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BitCountingTest {

    public int countBits(final int value) {
        int result = 0;

        int currentValue = value;
        while (currentValue > 0) {
            result += currentValue % 2;
            currentValue = currentValue >> 1;
        }

        return result;
    }

    @Test
    void firstTest() {
        int result = countBits(3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void secondTest() {
        int result = countBits(4);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void givenTest() {
        int result = countBits(1234);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void modOperation1() {
        int a = 5;
        int result = a % 2;

        Integer integer = Integer.valueOf(1234);

        int numberOfOneBits = integer.bitCount(1234);

        int x = 1 >>> 1;
        System.out.println("numberOfOneBits:" + numberOfOneBits);
        System.out.println("x:" + x);

        int z = 15 ^ 15;

        System.out.println("z:" + z);
    }

    @Test
    void anOtherTest() {
        long x = Long.MAX_VALUE / 2 + 1;
        long y = Long.MAX_VALUE / 2;

        long r = x + y;

        System.out.println("x:" + x + " binary:" + Long.toBinaryString(x));
        System.out.println("y:" + x + " binary:" + Long.toBinaryString(y));
        System.out.println("r:" + r + " binary:" + Long.toBinaryString(r));
        long singX = x ^ r;
        long singY = y ^ r;
        System.out.println("singX:" + singX + " singY:" + singY);
        long result = (x ^ r) & (y ^ r);
        System.out.println("result:" + result);
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("long overflow");
        }
    }
}
