package com.soebes.katas.bytes;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

class ByteTest {

  @Test
  void byteBufferTEst() {
    int anInt = ByteBuffer.wrap(new byte[]{0, 1, 0, 0}).getInt();
    System.out.println("anInt:" + anInt);

  }

  @Test
  void byteBufferWrap_number_one() {
    int anInt = ByteBuffer.wrap(new byte[]{1, 0, 0, 0}).getInt();
    System.out.println("anInt:" + anInt);

  }

  @Test
  void byteBufferWrap_number_two() {
    int anInt = ByteBuffer.wrap(new byte[]{0, 0, 1, 0}).getInt();
    System.out.println("anInt:" + anInt);

  }

  @Test
  void byteBufferWrap_number_larger() {
    int anInt = ByteBuffer.wrap(new byte[]{0, 0, (byte) 0xC0, 0}).getInt();
    System.out.println("anInt:" + anInt);

  }
}
