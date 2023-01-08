package com.soebes.security;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

class STest {

  String generateOTP(int lengthOfOTP) {
    StringBuilder generatedOTP = new StringBuilder();
    SecureRandom secureRandom = new SecureRandom();

    try {

      secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());

      for (int i = 0; i < lengthOfOTP; i++) {
        generatedOTP.append(secureRandom.nextInt(9));
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return generatedOTP.toString();
  }
  @Test
  void generateHash() {
    var s = generateOTP(64);
    System.out.println("s = " + s);
  }

}
