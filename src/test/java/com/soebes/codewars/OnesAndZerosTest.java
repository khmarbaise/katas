package com.soebes.codewars;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OnesAndZerosTest {

    static int[] ONE = {0, 0, 0, 1};
    static int[] TWO = {0, 0, 1, 0};
    static int[] THREE = {0, 0, 1, 1};
    static int[] FOUR = {0, 1, 0, 0};
    static int[] EIGHT = {1, 0, 0, 0};
    static int[] NINE = {1, 0, 0, 1};
    static int[] TEN = {1, 0, 1, 0};

    int convertArrayToInteger(int[] binaryArray) {
        int result = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            result = result * 2 + binaryArray[i];
        }
        return result;
    }

    int convert(List<Integer> binaryArray) {
        return binaryArray.stream()
                .reduce(0, (acc, y) -> acc * 2 + y);
    }

    @Test
    void shouldResultIn10() {
        int i = convertArrayToInteger(TEN);
        assertThat(i).isEqualTo(10);
    }

    @Test
    void shouldResultInOne() {
        int i = convertArrayToInteger(ONE);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void shouldResultInTwo() {
        int i = convertArrayToInteger(TWO);
        assertThat(i).isEqualTo(2);
    }

    @Test
    void shouldResultInThree() {
        int i = convertArrayToInteger(THREE);
        assertThat(i).isEqualTo(3);
    }

    @Test
    void shouldResultInFour() {
        int i = convertArrayToInteger(FOUR);
        assertThat(i).isEqualTo(4);
    }

    @Test
    void shouldResultInEight() {
        int i = convertArrayToInteger(EIGHT);
        assertThat(i).isEqualTo(8);
    }

    @Test
    void shouldResultInNine() {
        int i = convertArrayToInteger(NINE);
        assertThat(i).isEqualTo(9);
    }

    @Test
    void convertShouldResultInNine() {
        List<Integer> binaryArray = List.of(1, 0, 0, 1);
        int i = convert(binaryArray);
        assertThat(i).isEqualTo(9);
    }

    @Test
    void convertShouldResultInTen() {
        int i = convert(List.of(1, 0, 1, 0));
        assertThat(i).isEqualTo(10);
    }

    @Test
    void name() {
        int[] x = new int[7];
    }
}
