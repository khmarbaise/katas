package com.soebes.katas.quiz.biginteger;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class BigIntegerTest {

    @Test
    void firstTest() {
        BigInteger big = BigInteger.ONE.shiftLeft(82_589_933).subtract(BigInteger.ONE);

        // 2^4
        // 1 << 4 => 00001, 00010, 00100, 01000
//        BigInteger big = BigInteger.TWO.pow(82_589_933).subtract(BigInteger.ONE);

//        BigInteger bigInteger = big.nextProbablePrime();

        System.out.println("Next Prime: " + big);

    }
}
