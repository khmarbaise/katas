package com.soebes.limits;

import jdk.internal.math.FloatConsts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class IEEE754 {

    String toBinGrouped(long l) {
        byte[] result = new byte[64];
        for (int i = 0; i < 64; i++) {
            long digit = l % 2;
            result[63 - i] = (byte) (digit == 0 ? 0x30 : 0x31);
            l = l >>> 1;
        }
        return new String(result, StandardCharsets.UTF_8);
    }

    @DisplayName("Tests for toBinGrouped")
    @Nested
    class binGroupTest {

        @Test
        void baseTest() {
            long bin = 0b1100_0110_1001_0011;
            assertThat(toBinGrouped(bin)).isEqualTo("0000000000000000000000000000000000000000000000001100011010010011");
        }

        @Test
        void longMaxValue() {
            long bin = Long.MAX_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("0111111111111111111111111111111111111111111111111111111111111111");
        }
        @Test
        void longMinValue() {
            long bin = Long.MIN_VALUE;
            assertThat(toBinGrouped(bin)).isEqualTo("1000000000000000000000000000000000000000000000000000000000000000");
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
//        int exponent = (rawBits & FloatConsts.EXP_BIT_MASK) >>
//            (FloatConsts.SIGNIFICAND_WIDTH - 1) - FloatConsts.EXP_BIAS;
        int exponent = (rawBits & FloatConsts.EXP_BIT_MASK) >>
                (FloatConsts.SIGNIFICAND_WIDTH - 1);


        System.out.println("Sign:" + signOfFloat);
        System.out.println("significant Bits: " + Long.toBinaryString(significantBits) + " hex:" + Long.toHexString(significantBits));
        System.out.println("Raw: '" + Long.toBinaryString(rawBits));
        System.out.println("Exponent:" + Long.toBinaryString(exponent));
    }
}
