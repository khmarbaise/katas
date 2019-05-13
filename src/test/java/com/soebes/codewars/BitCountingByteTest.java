package com.soebes.codewars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class BitCountingByteTest {
    public static final byte MASK = -0b1000_0000;

    @Test
    void firstTest() {
        BigInteger bi = BigInteger.ONE;
        bi.bitCount();
        byte mask = -0b1000_0000;
        byte value = (byte) 0b1010_1010;

        System.out.println("1) Value:" + Integer.toBinaryString(Byte.toUnsignedInt(value)));
        System.out.println("1) Maks:" + Integer.toBinaryString(Byte.toUnsignedInt(mask)));

        byte result = (byte) (value >>> 1);
        System.out.println("2) Value:" + Integer.toBinaryString(Byte.toUnsignedInt(result)));

        System.out.println("value:" + Integer.toHexString(Byte.toUnsignedInt(value)) + " " + Integer.toBinaryString(Byte.toUnsignedInt(value)) + " Byte:" + Byte.toUnsignedInt(value));
        assertThat(countBitsInByte(value)).isEqualTo(2);
    }

    @Test
    void unsignedChar() {
        char c = 0x8000;
        System.out.println("C:" + Integer.valueOf(c));

        int i = Byte.toUnsignedInt((byte) -0b1000_0000);

    }

    @Nested
    @DisplayName("Kernigham Algorithm Tests")
    class KernighamTest {
        @Test
        void firstTest() {
            byte value = 0b0111_0000;
            assertThat(kernighham(value)).isEqualTo(3);
            Long.bitCount(10);
        }

    }

    @Nested
    @DisplayName("Test with mask like Integer.countBit() does.")
    class BitMaskTest {

        @Test
        void firstTest() {
            byte value = 0b0110110;
            assertThat(countBitsInByteWithX(value)).isEqualTo(4);
        }
        @Test
        void secondTest() {
            byte value = 0b1110110;
            assertThat(countBitsInByteWithX(value)).isEqualTo(5);
        }
    }
    private int kernighham(final byte value) {
        byte test = value;

        byte count = 0;

        while (test != 0) {
            test &= (test -1);
            count ++;
        }
        return count;
    }

    private int countBitsInByteWithX(final byte value) {
        final byte MASK1 = 0b01010101; // 0x55
        final byte MASK2 = 0b00110011; // 0x33
        final byte MASK3 = 0b00001111; // 0x0f

        byte temp = value;

        temp = (byte) ((temp & MASK1) + ((temp >>> 1) & MASK1));
        temp = (byte) ((temp & MASK2) + ((temp >>> 2) & MASK2));
        temp = (byte) ((temp & MASK3) + ((temp >>> 4) & MASK3));

        return temp;
    }

    private int countBitsInByte(final byte value) {
        int result = 0;
        byte temp = value;
        for (int i=0; i<8; i++) {
            int digit = temp & 0x1;
            result += digit;
            temp = ((byte) (temp / 2));
        }
        return result;
    }
}
