package com.soebes.popcount;

import org.junit.jupiter.api.Test;

import java.util.HexFormat;

import static org.assertj.core.api.Assertions.assertThat;

record SystemInfoServiceTest() {

  private static final String BIT_4 = "0000";

  String toBinary(long r) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < Long.SIZE; i++) {
      //long p = r & 0xffffffff;
      long p = r & 0x8000000000000000L;
      stringBuilder.append(p == 0 ? '0' : '1');
      r = r << 1;
      if (i < Long.SIZE - 1 && (i + 1) % 4 == 0) {
        stringBuilder.append(' ');
      }
    }
    return stringBuilder.toString();
  }

  @Test
  void first() {
    long r = 0x8000000000000000L;
    assertThat(toBinary(r)).isEqualTo("1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000");
  }

  @Test
  void second() {
    long r = 0x8000000000000001L;
    assertThat(toBinary(r)).isEqualTo("1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001");
  }

  @Test
  void third() {
    long r = 0x8000800000000001L;
    assertThat(toBinary(r)).isEqualTo("1000 0000 0000 0000 1000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001");
  }

  @Test
  void forth() {
    long r = 0x80008000000ff001L;
    assertThat(toBinary(r)).isEqualTo("1000 0000 0000 0000 1000 0000 0000 0000 0000 0000 0000 1111 1111 0000 0000 0001");
  }

  long popcount(long value) {
    long M5 = -1L >>> 32;
    long M4 = M5 ^ M5 << 16;
    long M3 = M4 ^ M4 << 8;
    long M2 = M3 ^ M3 << 4;
    long M1 = M2 ^ M2 << 2;
    long M0 = M1 ^ M1 << 1;

    System.out.println(" M5 = " + toBinary(M5) + " " + HexFormat.of().toHexDigits(M5));
    System.out.println(" M4 = " + toBinary(M4) + " " + HexFormat.of().toHexDigits(M4));
    System.out.println(" M3 = " + toBinary(M3) + " " + HexFormat.of().toHexDigits(M3));
    System.out.println(" M2 = " + toBinary(M2) + " " + HexFormat.of().toHexDigits(M2));
    System.out.println(" M1 = " + toBinary(M1) + " " + HexFormat.of().toHexDigits(M1));
    System.out.println(" M0 = " + toBinary(M0) + " " + HexFormat.of().toHexDigits(M0));

    value = (value >> 1 & M0) + (value & M0);
    value = (value >> 2 & M1) + (value & M1);
    value = ((value >> 4) + value) & M2;
    value = ((value >> 8) + value) & M3;
    value = ((value >> 16) + value) & M4;
    value = ((value >> 32) + value) & M5;

    return value;
  }

  @Test
  void name() {
    long popcount = popcount(0x80000000L);
    assertThat(popcount).isEqualTo(1);
  }
}