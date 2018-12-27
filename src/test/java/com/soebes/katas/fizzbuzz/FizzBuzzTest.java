package com.soebes.katas.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    /*
     * "Write a program that prints the numbers from 1 to 100. But for multiples of
     * three print “Fizz” instead of the number and for the multiples of five print
     * “Buzz”. For numbers which are multiples of both three and five print
     * “FizzBuzz”."
     */
    @Test
    void first() {
        assertThat(fizzBuzz(1)).isEqualTo("1");
    }

    @Test
    void second() {
        assertThat(fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void third() {
        assertThat(fizzBuzz(4)).isEqualTo("4");
    }

    @Test
    void forth() {
        assertThat(fizzBuzz(6)).isEqualTo("Fizz");
    }

    @Test
    void fifth() {
        assertThat(fizzBuzz(10)).isEqualTo("Buzz");
    }

    @Test
    void sixth() {
        assertThat(fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void seven() {
        assertThat(fizzBuzz(28)).isEqualTo("28");
    }

    @Test
    void eight() {
        assertThat(fizzBuzz(27)).isEqualTo("Fizz");
    }

    public String fizzBuzz(int i) {
        StringBuilder sb = new StringBuilder();

        if (i % 3 == 0) {
            sb.append("Fizz");
        }

        if (i % 5 == 0) {
            sb.append("Buzz");
        }

        if (sb.length() == 0) {
            sb.append(Integer.toString(i));
        }

        return sb.toString();
    }
}
