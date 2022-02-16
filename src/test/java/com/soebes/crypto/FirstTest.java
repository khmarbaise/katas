package com.soebes.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HexFormat;
import org.junit.jupiter.api.Test;

class FirstTest {

  @Test
  void name() throws NoSuchAlgorithmException {

    byte[] generatedHash = generateHash(100, "Das Ist ein Passwort", "Salt".getBytes(StandardCharsets.UTF_8));

    Encoder encoder = Base64.getEncoder();

    System.out.println(new String(encoder.encode(generatedHash)));

    HexFormat formatFingerprint = HexFormat.ofDelimiter(":").withUpperCase();
    byte[] bytes = {0, 1, 2, 3, 124, 125, 126, 127, (byte) 0xff};
    String str = formatFingerprint.formatHex(bytes);
    System.out.println(str);
    String generatedHashStr = formatFingerprint.formatHex(generatedHash);
    System.out.println(generatedHashStr);

  }

  @Test
  void another_test() {
    byte b_max0 = 0x7F;
    byte b_max1 = 0b0111_1111;
    byte b_max2 = (byte) 0x80;
    byte b_max3 = (byte) 0b1000_0000;
    byte b_max4 = (byte) 0xFF;
    byte b_max5 = (byte) 0b1111_1111;

    char c_max0 = 0x7F_FF;
    char c_max1 = 0b0111_1111__1111_1111;
    char c_max2 = 0x8000;
    char c_max3 = 0b1000_0000_0000_0000;
    char c_max4 = 0xFF_FF;
    char c_max5 = 0b1111_1111__1111_1111;

    short s_max0 = 0x7F_FF;
    short s_max1 = 0b0111_1111__1111_1111;
    short s_max2 = (short) 0x8000;
    short s_max3 = (short) 0b1000_0000_0000_0000;
    short s_max4 = (short) 0xFF_FF;
    short s_max5 = (short) 0b1111_1111__1111_1111;

    int i_max0 = 0x7F_FF_FF_FF;
    int i_max1 = 0b0111_1111__1111_1111__1111_1111__1111_1111;
    int i_max2 = 0x80000000;
    int i_max3 = 0b1000_0000__0000_0000__0000_0000__0000_0000;
    int i_max4 = 0xFF_FF_FF_FF;
    int i_max5 = 0b1111_1111__1111_1111__1111_1111__1111_1111;

    long l_max0 = 0x7F_FF_FF_FF_FF_FF_FF_FFL;
    long l_max1 = 0b0111_1111__1111_1111__1111_1111__1111_1111__1111_1111__1111_1111__1111_1111__1111_1111L;
    long l_max2 = 0x8000000000000000L;
    long l_max3 = 0b1000_0000__0000_0000__0000_0000__0000_0000__0000_0000__0000_0000__0000_0000__0000_0000L;
    long l_max4 = 0xFF_FF_FF_FF_FF_FF_FF_FFL;
    long l_max5 = 0b1111_1111__1111_1111__1111_1111__1111_1111__1111_1111__1111_1111__1111_1111__1111_1111L;

  }

  public static byte[] generateHash(int iterationNb, String password, byte[] salt) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      digest.update(salt);
      byte[] input = digest.digest(password.getBytes(StandardCharsets.UTF_8));
      for (int i = 0; i < iterationNb; i++) {
        input = digest.digest(input);
      }
      return input;

    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
