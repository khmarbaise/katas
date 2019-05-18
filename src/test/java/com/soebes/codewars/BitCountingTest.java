package com.soebes.codewars;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BitCountingTest {

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

        Long.signum(x);

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

        long a1 =  0x1;
        long a2 =  0x80000000L;
        System.out.println("a1: " + Long.toBinaryString(a1));
        System.out.println("a2: " + Long.toBinaryString(a2));


        long shifted_1 = a1 >> 1;
        System.out.println("       a1: " + Long.toBinaryString(a1));
        System.out.println("shifted_1:" + shifted_1 + " x:" + Long.toBinaryString(shifted_1));
        long shifted_2 = a2 >> 1;

        System.out.println("       a2: " + Long.toBinaryString(a2));
        System.out.println("shifted_2: " + Long.toBinaryString(shifted_2));

        long unsigned_shift = 0x2;
        long shifted_unsigned_shift = unsigned_shift >>> 1;
        long shifted_signed_shift = unsigned_shift >> 1;
        System.out.println("Unsigned shift: " + Long.toBinaryString(unsigned_shift));
        System.out.println("Unsigned shift: " + Long.toBinaryString(shifted_unsigned_shift));
        System.out.println("Unsigned shift: " + Long.toBinaryString(shifted_signed_shift));

    }

    String binaryString(final long value) {
        char[] characters = new char[64];
        long temp = value;
        for(int i=0; i<64; i++) {
            long digit = temp & 0x1;
            characters[63-i] = Character.valueOf((char) (48+digit));
            temp = temp / 2;
        }
        return new String(characters);
    }

    @Test
    void binaryStringTest() {
        long value = 0b1011;
        String result = binaryString(value);

        assertThat(result).isEqualTo("0000000000000000000000000000000000000000000000000000000000001011");
    }

    @Test
    void signTest() {
        long a1 = 0x8888000000000000L;

        long t1 = a1 >> 63;
        long t2 = -a1 >>> 63;

        long exp = t1 | t2;

        long x1 = a1 >> 20;
        long x2 = a1 >>> 20;
        System.out.println("a1:" + Long.toBinaryString(a1) + " a1:" + a1);
        System.out.println("t1:" + Long.toBinaryString(t1) + " t1:" + t1);
        System.out.println("t2:" + Long.toBinaryString(t2) + " t2:" + t2);
        System.out.println("exp:" + Long.toBinaryString(exp) + " exp:" + ((int)exp));
        System.out.println("x1:" + Long.toBinaryString(x1) + " x1:" + x1);
        System.out.println("x2:" + Long.toBinaryString(x2) + " x2:" + x2);

        System.out.println("a1:" + binaryString(a1));
        System.out.println("x2:" + binaryString(x2));
        //((i >> 63) | (-i >>> 63));

    }
}
