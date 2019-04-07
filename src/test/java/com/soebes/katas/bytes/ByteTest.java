package com.soebes.katas.bytes;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

public class ByteTest {

    @Test
    void byteBufferTEst() {
        int anInt = ByteBuffer.wrap(new byte[]{0, 1, 0, 0}).getInt();
        System.out.println("anInt:" + anInt);

    }
}
