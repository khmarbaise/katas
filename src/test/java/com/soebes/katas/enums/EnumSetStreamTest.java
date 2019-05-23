package com.soebes.katas.enums;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Collections.synchronizedSet;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

public class EnumSetStreamTest {

    public enum BitValues {
        Bit_0(0x01),
        Bit_1(0x02),
        Bit_2(0x04),
        Bit_3(0x08),
        Bit_4(0x10),
        Bit_5(0x20),
        Bit_6(0x40),
        Bit_7(0x80);

        private final int bitMask;

        private BitValues(int bitMask) {
            this.bitMask = bitMask;
        }

        public int getBitMask() {
            return bitMask;
        }
    }

    @Test
    void firstTest() {
        int bitValue = 0x02 | 0x04 | 0x10;
        var result = Stream.of(BitValues.values())
                           .filter(item -> (item.getBitMask() & bitValue) != 0)
                           .collect(toCollection(() -> EnumSet.noneOf(BitValues.class)));

        result.forEach(item -> System.out.println("Item: " + item));
    }

    @Test
    void firstWithSynchronizedTest() {
        int bitValue = 0x02 | 0x04 | 0x10;
        var result = Stream.of(BitValues.values())
                           .filter(item -> (item.getBitMask() & bitValue) != 0)
                           .collect(toCollection(() -> synchronizedSet(EnumSet.noneOf(BitValues.class))));

        result.forEach(item -> System.out.println("Item: " + item));
    }

    @Test
    void secondTest() {
        int bitValue = 0x02 | 0x04 | 0x10;
        Set<BitValues> result = Stream
                .of(BitValues.values())
                .filter(item -> (item.getBitMask() & bitValue) != 0)
                .collect(toSet());

        result.forEach(item -> System.out.println("Item: " + item));

        System.out.println(result.getClass().getCanonicalName());
    }

    @Test
    void thirdTest() {
        int bitValue = 0x02 | 0x04 | 0x10;
        var result = Stream.of(BitValues.values())
                           .filter(item -> (item.getBitMask() & bitValue) != 0)
                           .collect(toCollection(() -> new ArrayList<>()));

        result.forEach(item -> System.out.println("Item: " + item));
        System.out.println(result.getClass().getCanonicalName());
    }


}
