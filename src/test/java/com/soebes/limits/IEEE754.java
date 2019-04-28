package com.soebes.limits;

import jdk.internal.math.FloatConsts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class IEEE754 {
    String toBinGrouped(byte l) {
        byte[] result = new byte[8 + 1];

        int position = 7 + 1;
        for (int i = 0; i < 8; i++) {
            byte digit = (byte) (l % 2);
            int location = i / 4;
            if (i % 4 == 0 && i > 0) {
                result[position - i - location + 1] = 0x20;
            }
            result[position - i - location] = (byte) (digit == 0 ? 0x30 : 0x31);
            l = (byte) (l >>> 1);
        }
        return new String(result, StandardCharsets.UTF_8);
    }

    String toBinGrouped(int l) {
        byte[] result = new byte[32 + 7];

        for (int i = 0; i < 32; i++) {
            long digit = l % 2;
            int location = i / 4;
            if (i % 4 == 0 && i > 0) {
                result[31 + 7 - i - location + 1] = 0x20;
            }
            result[31 + 7 - i - location] = (byte) (digit == 0 ? 0x30 : 0x31);
            l = l >>> 1;
        }
        return new String(result, StandardCharsets.UTF_8);
    }

    String toBinGrouped(long l) {
        byte[] result = new byte[64 + 15];

        for (int i = 0; i < 64; i++) {
            long digit = l % 2;
            int location = i / 4;
            if (i % 4 == 0 && i > 0) {
                result[63 + 15 - i - location + 1] = 0x20;
            }
            result[63 + 15 - i - location] = (byte) (digit == 0 ? 0x30 : 0x31);
            l = l >>> 1;
        }
        return new String(result, StandardCharsets.UTF_8);
    }

    @DisplayName("Tests for toBinGrouped(long)")
    @Nested
    class binGroupTest {

        @Test
        void baseTest() {
            long bin = 0b1100_0110_1001_0011;
            assertThat(toBinGrouped(bin)).isEqualTo("0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1100 0110 1001 0011");
        }

        @Test
        void longMaxValue() {
            long bin = Long.MAX_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("0111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111");
        }

        @Test
        void longMinValue() {
            long bin = Long.MIN_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000");
        }
    }

    @DisplayName("Tests for toBinGrouped(int)")
    @Nested
    class binGroupIntTest {

        @Test
        void baseTest() {
            int bin = 0b1100_0110_1001_0011;
            assertThat(toBinGrouped(bin)).isEqualTo("0000 0000 0000 0000 1100 0110 1001 0011");
        }

        @Test
        void longMaxValue() {
            int bin = Integer.MAX_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("0111 1111 1111 1111 1111 1111 1111 1111");
        }

        @Test
        void intMinValue() {
            int bin = Integer.MIN_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("1000 0000 0000 0000 0000 0000 0000 0000");
        }
    }

    @DisplayName("Tests for toBinGrouped(byte)")
    @Nested
    class binGroupByteTest {

        @Test
        void baseTest() {
            byte bin = (byte) 0b1001_0011;
            assertThat(toBinGrouped(bin)).isEqualTo("1001 0011");
        }

        @Test
        void longMaxValue() {
            byte bin = Byte.MAX_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("0111 1111");
        }

        @Test
        void byteMinValue() {
            byte bin = Byte.MIN_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("1000 0000");
        }
    }


    @Test
    void firstTest() {
//        float c = 18.4f;
//        float c = 1.875f;
        float c = 18.4f;

//        int exponent = Math.getExponent( c );

        int rawBits = Float.floatToRawIntBits(c);

        int signOfFloat = (int) (FloatConsts.SIGN_BIT_MASK & rawBits);
        int significantBits = (int) (FloatConsts.SIGNIF_BIT_MASK & rawBits);

        int exponent = (rawBits & FloatConsts.EXP_BIT_MASK) >>
                (FloatConsts.SIGNIFICAND_WIDTH - 1);


        System.out.println("Sign:" + signOfFloat);
        System.out.println("significant Bits: " + toBinGrouped(significantBits));
        System.out.println("             Raw: " + toBinGrouped(rawBits));
        System.out.println("        Exponent: " + toBinGrouped((byte) exponent));
    }
}
