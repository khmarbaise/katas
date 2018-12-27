package com.soebes.katas.quiz.biginteger;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class BigIntegerTest {

    @Test
    void firstTest() {
        BigInteger big = BigInteger.TWO.pow(82_589_933).subtract(BigInteger.ONE);

//        BigInteger bigInteger = big.nextProbablePrime();

        System.out.println("Next Prime: " + big);

    }
}
