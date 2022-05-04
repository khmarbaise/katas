package com.soebes.bitcount;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BitCountTest {
  
  
  public static int bitCount(short i) {
    // HD, Figure 5-2
    i = (short) (i - ((i >>> 1) & 0x5555));
    i = (short) ((i & 0x3333L) + ((i >>> 2) & 0x3333));
    i = (short) ((i + (i >>> 4)) & 0x0f0fL);
    i = (short) (i + (i >>> 8));
    return (int) i & 0x7f;
  }
  
  @Test
  void test_bitcount() {
    
    int bits = bitCount((short) -1);
    System.out.println("bits:" + bits);
    
    int minValue = bitCount(Short.MIN_VALUE);
    System.out.println("bits:" + minValue);
    int maxValue = bitCount(Short.MAX_VALUE);
    System.out.println("bits:" + maxValue);
  }
  
  long calculateNumberInteger(int populationCount) {
    long numberOf = 0L;
    for (int i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++) {
      if (Integer.bitCount(i) == populationCount) {
        numberOf++;
      }
    }
    return numberOf;
  }
  
  long calculateNumberForShort(int populationCount) {
    long numberOf = 0L;
    for (int i = Short.MIN_VALUE; i <= Short.MAX_VALUE; i++) {
      if (bitCount((short) i) == populationCount) {
        //        System.out.println("     i = " + Long.toBinaryString(Short.toUnsignedLong(
        //       (short) i)));
        numberOf++;
      }
    }
    return numberOf;
  }
  
  
  @Nested
  class CalculateBitCountForRange {
    // BitCount, Anzahl
    Map<Integer, Integer> calculateBitcountForShort() {
      var result = new HashMap<Integer, Integer>();
      for (int i = Short.MIN_VALUE; i <= Short.MAX_VALUE; i++) {
        int numberOfBits = bitCount((short) i);
        Integer orDefault = result.getOrDefault(numberOfBits, Integer.valueOf(0));
        orDefault++;
        result.put(numberOfBits, orDefault);
      }
      return result;
    }
  
    @Test
    @Disabled("Runs too long!! Only from IDE")
    void name() {
      BigDecimal pow = BigDecimal.valueOf(2L).pow(16);
      System.out.println("pow = " + pow);
      Map<Integer, Integer> integerIntegerMap = calculateBitcountForShort();
      for (int bitCount = 0; bitCount <= 16; bitCount++) {
        Integer numberOf = integerIntegerMap.get(bitCount);
        BigDecimal percentagOfShort = BigDecimal.valueOf(numberOf)
          .divide(pow)
          .multiply(BigDecimal.valueOf(100L));
    
        System.out.printf("%3d %8d %7.3f\n", bitCount, numberOf, percentagOfShort.doubleValue());
      }
      
    }
  }
  @Nested
  class CalculateBitCountForInteger {
    // BitCount, Anzahl
    int[] calculateBitcountForShort() {
      int[] result = new int[33];
      for (int i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++) {
        int numberOfBits = Integer.bitCount( i);
        result[numberOfBits]++;
      }
      return result;
    }
  
    @Test
    @Disabled("Runs tooo loooooongggg...")
    void name() {
      BigDecimal pow = BigDecimal.valueOf(2L).pow(32);
      System.out.println("pow = " + pow);
      int[] integerIntegerMap = calculateBitcountForShort();
      for (int bitCount = 0; bitCount <= 32; bitCount++) {
        Integer numberOf = integerIntegerMap[bitCount];
        BigDecimal percentagOfShort = BigDecimal.valueOf(numberOf)
          .divide(pow)
          .multiply(BigDecimal.valueOf(100L));
    
        System.out.printf("%3d %8d %7.3f\n", bitCount, numberOf, percentagOfShort.doubleValue());
      }
      
    }
  }
  
  @Test
  void short_percentag_of_numbers_short() {
    BigDecimal pow = BigDecimal.valueOf(2L).pow(16);
    System.out.println("pow = " + pow);
    for (int bitCount = 0; bitCount <= 16; bitCount++) {
      long numberOf = calculateNumberForShort(bitCount);
      BigDecimal percentagOfShort = BigDecimal.valueOf(numberOf)
        .divide(pow)
        .multiply(BigDecimal.valueOf(100L));
      
      System.out.printf("%3d %8d %7.3f\n", bitCount, numberOf, percentagOfShort.doubleValue());
    }
  }
  
  @Test
  @Disabled("Runs tooooooo loooooongggggg")
  void short_percentag_of_numbers_integer() {
    BigDecimal pow = BigDecimal.valueOf(2L).pow(32);
    System.out.println("pow = " + pow);
    for (int bitCount = 0; bitCount <= 32; bitCount++) {
      long numberOf = calculateNumberInteger(bitCount);
      BigDecimal percentagOfShort = BigDecimal.valueOf(numberOf)
        .divide(pow)
        .multiply(BigDecimal.valueOf(100L));
      
      System.out.printf("%3d %8d %7.3f\n", bitCount, numberOf, percentagOfShort.doubleValue());
    }
  }
  
  @Test
  void short_percentag_of_numbers_where_bitcount_is_equal_1() {
    long numberOf = 0L;
    for (long i = Short.MIN_VALUE; i < Short.MAX_VALUE; i++) {
      if (Long.bitCount(i) == 1) {
        numberOf++;
      }
    }
    BigDecimal pow = BigDecimal.valueOf(2L).pow(16);
    System.out.println("pow = " + pow);
    System.out.println("Number of: " + numberOf);
    BigDecimal percentagOfShort = BigDecimal.valueOf(numberOf)
      .divide(pow)
      .multiply(BigDecimal.valueOf(100L));
    System.out.println("Percentage = " + percentagOfShort);
  }
  
  @Test
  void short_percentag_of_numbers_where_bitcount_is_equal_2() {
    long numberOf = 0L;
    for (long i = Short.MIN_VALUE; i < Short.MAX_VALUE; i++) {
      if (Long.bitCount(i) == 2) {
        numberOf++;
      }
    }
    BigDecimal pow = BigDecimal.valueOf(2L).pow(16);
    System.out.println("pow = " + pow);
    System.out.println("Number of: " + numberOf);
    BigDecimal percentagOfShort = BigDecimal.valueOf(numberOf)
      .divide(pow)
      .multiply(BigDecimal.valueOf(100L));
    System.out.println("Percentage = " + percentagOfShort);
  }
  
  @Test
  @Disabled
  void integer_percentag_of_numbers_where_bitcount_is_equal_21() {
    long numberOf = 0L;
    for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
      if (Long.bitCount(i) == 21) {
        numberOf++;
      }
    }
    BigDecimal pow = BigDecimal.valueOf(2L).pow(32);
    System.out.println("pow = " + pow);
    System.out.println("Number of: " + numberOf);
    BigDecimal percentagOfLongs = BigDecimal.valueOf(numberOf)
      .divide(BigDecimal.valueOf(2L).pow(32))
      .multiply(BigDecimal.valueOf(100L));
    System.out.println("Percentage = " + percentagOfLongs);
  }
  
  @Test
  @Disabled
  void long_percentag_of_numbers_where_bitcount_is_equal_42() {
    long numberOf = 0L;
    for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
      //      System.out.println("i = " + i);
      if (Long.bitCount(i) == 21) {
        numberOf++;
      }
    }
    System.out.println("Number of: " + numberOf);
    BigInteger numberOfLongs = BigInteger.valueOf(2L).pow(64);
    double percentagOfLongs = (double) numberOf / numberOfLongs.doubleValue();
    System.out.println("Percentage = " + percentagOfLongs);
  }
}
