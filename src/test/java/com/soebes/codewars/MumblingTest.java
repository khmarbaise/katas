package com.soebes.codewars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class MumblingTest {

//    accum("abcd") -> "A-Bb-Ccc-Dddd"
//    accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
//    accum("cwAt") -> "C-Ww-Aaa-Tttt"

    private String accum(String input) {
        int overAllLength = input.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < overAllLength; i++) {
            for (int innerLop = 0; innerLop <= i; innerLop++) {
                char c = input.charAt(i);
                if (innerLop == 0) {
                    sb.append(String.valueOf(c).toUpperCase());
                } else {
                    sb.append(c);
                }
            }

            if (i < overAllLength - 1) {
                sb.append('-');
            }
        }

        return sb.toString();
    }

    @Test
    void firstTest() {
        String input = "a";
        String result = accum(input);
        assertThat(result).isEqualTo("A");
    }

    @Test
    void secondTest() {
        String input = "ab";
        String result = accum(input);
        assertThat(result).isEqualTo("A-Bb");
    }

    @Test
    void thirdTest() {
        String input = "abc";
        String result = accum(input);
        assertThat(result).isEqualTo("A-Bb-Ccc");
    }

    @Test
    void forthTest() {
        String input = "abcd";
        String result = accum(input);
        assertThat(result).isEqualTo("A-Bb-Ccc-Dddd");
    }

    @Test
    void fifthTest() {
        String input = "abcde";
        String result = accum(input);
        assertThat(result).isEqualTo("A-Bb-Ccc-Dddd-Eeeee");
    }
}
