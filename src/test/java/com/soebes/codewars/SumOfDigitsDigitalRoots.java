package com.soebes.codewars;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfDigitsDigitalRoots {
    /*
    digital_root(16)
=> 1 + 6
=> 7

digital_root(942)
=> 9 + 4 + 2
=> 15 ...
=> 1 + 5
=> 6

digital_root(132189)
=> 1 + 3 + 2 + 1 + 8 + 9
=> 24 ...
=> 2 + 4
=> 6

digital_root(493193)
=> 4 + 9 + 3 + 1 + 9 + 3
=> 29 ...
=> 2 + 9
=> 11 ...
=> 1 + 1
=> 2
     */

    int dr (int value) {
        System.out.println("dr:" + value);
        int result = digital_root(value);
        while (result > 10) {
            result = digital_root(result);
            System.out.println(" -> result:" + result);
        }
        return result;
    }

    int digital_root(int value) {
        int result = 0;

        int currentValue = value;
        while (currentValue > 0) {
            int digit = currentValue % 10;

            System.out.println("Digit:" + digit);
            currentValue = currentValue / 10;

            result += digit;
        }

        return result;
    }

    @Test
    void firstTest() {
        int result = digital_root(16);
        assertThat(result).isEqualTo(7);
    }


    @Test
    void secondTest() {
        int result = dr(942);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void thirdTest() {
        int result = dr(132189);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void forthTest() {
        int result = dr(493193);
        assertThat(result).isEqualTo(2);
    }

}
