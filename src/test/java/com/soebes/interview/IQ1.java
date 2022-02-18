package com.soebes.interview;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.Map;

import static java.util.Map.entry;

public class IQ1 {

  // Given:
  //  An integer array with 100 elements in it.
  //
  // ToDo:
  //  Find a missing number within the array?

  @Test
  void firstTest() {

    BitSet bs = new BitSet();

    bs.set(0);
    bs.set(1);
    bs.set(2);
    bs.set(3);
    bs.set(5);
    bs.set(22);
    bs.set(32);
    System.out.println("Count:" + bs.stream().count());

    bs.stream().forEach(s -> System.out.println("Bit: " + s));

    int i = bs.nextClearBit(0);

    System.out.println("Index:" + i);
    Map.ofEntries(entry("A", 1), entry("B", 2), entry("C", 3));

    int a = Integer.MAX_VALUE + 1;
    System.out.println("Result: " + a);

    int b = Integer.MIN_VALUE;

    int c = -1 * b;

    System.out.println("Result c:=" + c);
  }

  @Test
  void intersecteOne() {
    BitSet bs_first = new BitSet();
    BitSet bs_second = new BitSet();

    bs_first.set(0);
    bs_first.set(3);

    System.out.println("bs_first:");
    bs_first.stream().forEach(s -> System.out.println("s = " + s));

    bs_second.set(0);
    bs_second.set(4);

    System.out.println("bs_second");
    bs_second.stream().forEach(s -> System.out.println("s = " + s));
    boolean intersects = bs_second.intersects(bs_first);
    System.out.println("intersects:" + intersects);

    bs_second.and(bs_first);
    System.out.println("bs_scond.and(bs_first)");
    bs_second.stream().forEach(s -> System.out.println("s = " + s));
  }

  @Test
  void cardinality() {
    BitSet bs = new BitSet();
    bs.set(1);
    bs.set(2);
    bs.set(5);
    bs.set(255);

    System.out.println("cardinality: " + bs.cardinality());
    bs.stream().forEach(s -> System.out.println("Item:" + s));
  }

  @Test
  void flip() {
    BitSet bs = new BitSet();
    bs.set(1);
    bs.set(2);
    bs.set(5);
    bs.set(255);

    System.out.println("Before");
    bs.stream().forEach(s -> System.out.println("s = " + s));
    bs.flip(1);
    System.out.println("After");
    bs.stream().forEach(s -> System.out.println("s = " + s));
  }

  @Test
  void convert_from_int_to_bitset() {

    int value = 0b10101100;

    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(value);
    System.out.println("numberOfLeadingZeros = " + numberOfLeadingZeros);
    int maxSizeInBits = Integer.SIZE - numberOfLeadingZeros;
    System.out.println("maxSizeInBits = " + maxSizeInBits);
    BitSet bitSet = new BitSet(maxSizeInBits);
    for (int i = 0; i < maxSizeInBits; i++) {
      int bit = value & 0x1;
      System.out.println("v = " + bit);
      if (bit != 0) {
        bitSet.set(i);
      }
      value = value >> 1;
    }
    System.out.println("bitSet = " + bitSet);
    int result = bitSet.stream().peek(s -> System.out.println("s = " + s)).reduce(0, (a, b) -> a >> 1 + b);
    System.out.println("result = " + result);

    int calculatedResult = IntStream.range(0, 8).reduce(0, (a, b) -> b << 1 + (bitSet.get(a) ? 1 : 0));
    System.out.println("calculatedResult = " + calculatedResult);
  }
}
