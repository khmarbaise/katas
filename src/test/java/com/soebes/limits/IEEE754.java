package com.soebes.limits;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IEEE754 {
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
        void byteMaxValue() {
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
    void multiply() {
        Integer nI = -8;
        System.out.println("       Integer:" + toBinGrouped(nI) + " R:" + nI);
        Integer nD = nI >> 3;
        System.out.println("Result Integer:" + toBinGrouped(nD) + " R:" + nD);
        Integer nM = nI << 2;
        System.out.println("Result Integer:" + toBinGrouped(nM) + " R:" + nM);

    }

    @Test
    void writeIntegerAsBinary() {
        System.out.println();
        Integer positiveInteger = 16;
        Integer negativeInteger = -16;
        System.out.println("Integer   16:" + toBinGrouped(positiveInteger));
        System.out.println("Integer  -16:" + toBinGrouped(negativeInteger));
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














    @Test
    void compareFloatExpected() {
        float a = 1.1f + 2.2f;
        float b = 3.3f;
        assertThat(a).isEqualTo(b);
    }























    @Test
    void compareFloatExpectedWithoutAssertJ() {
        float a = 1.1f + 2.2f;
        float b = 3.3f;
        if (a == b) {
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT EQUAL");
        }
    }































    @Test
    void theResultShouldBeOne() {
        float f = 0.1f;

        float total = 0;

        for (int i = 0; i < 10; ++i) {
            total += f;
        }

        assertThat(total).isEqualTo(1.0f);
    }

























    @Test
    void theResultShouldAlsoBeOne() {
        float f = 0.1f;
        float sum = 0;

        for (int i = 0; i < 10; ++i) {
            sum += f;
        }

        if (sum == 1.0f) {
            System.out.println("GLEICH.");
        }
        else {
            System.out.println("***ungleich***");
        }
    }




























    @Test
    void selfCompare() {
        float a = 18.4f;
        float b = 18.4f;
        assertThat(a).isEqualTo(b);
    }




























    @Test
    void selfCompareResult() {
        float a = 18.4f;
        float b = 18.2f + 0.2f;
        assertThat(a).isEqualTo(b);
    }



























    @Test
    void summarizingFloats() {

        float[] elements = {
                0.23f,
                1_000_000f,
        };

        float result = 0.0f;
        for (float item : elements) {
            result += item;
        }
        System.out.println(" Result: " + result);
    }


    @Test
    void summarizingDouble() {
        double[] elements = {
                0.23,
                1_000_000_000_000_000d,
        };

        double result = 0.0f;
        for (double item : elements) {
            result += item;
        }
        System.out.println("Result: " + result);
    }














    @Test
    void name() {
        var a = 32769;
        var b = 32766;

        var result = a + b;

        System.out.println("result: '" + result + "'");
    }

    @Test
    void overflowTest() {
        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;

        int result = i1 + i2;
        System.out.println("    i1:" + i1 );
        System.out.println("    i2:" + i2 );
        System.out.println("result:" + result);
    }
}
