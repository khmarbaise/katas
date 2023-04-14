package com.soebes.equals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArraysTest {


  @Test
  void string_arrays() {
    String[] first =  {"apple", "banana", "orange"};
    String[] second = {"apple", "banana", "orange"};

    var equals0 = first[0].equals(second[0]);
    var equals1 = first[1].equals(second[1]);
    var equals2 = first[2].equals(second[2]);

    System.out.println("compare index 0 = " + equals0);
    System.out.println("compare index 1 = " + equals1);
    System.out.println("compare index 2 = " + equals2);

    boolean sign0 = first[0] == second[0];
    boolean sign1 = first[1] == second[1];
    boolean sign2 = first[2] == second[2];

    System.out.println("compare index 0 = " + sign0);
    System.out.println("compare index 1 = " + sign1);
    System.out.println("compare index 2 = " + sign2);
  }

  @Test
  void compare_two_strings_with_equals() {
    String s1 = "first";
    String s2 = "first";

    System.out.println("s1.equals(s2) = " + s1.equals(s2));
    System.out.println("s1 == s2 " + (s1 == s2));
  }

  @Test
  void compare_two_int_arrays() {
    int[] first = {1, 2, 3, 1024,123456789};
    int[] second = {1, 2, 3, 1024, 123456789};

    boolean equals0 = first[0] == second[0];
    boolean equals1 = first[1] == second[1];
    boolean equals2 = first[2] == second[2];
    boolean equals3 = first[3] == second[3];
    boolean equals4 = first[4] == second[4];

    System.out.println("equals0 = " + equals0);
    System.out.println("equals1 = " + equals1);
    System.out.println("equals2 = " + equals2);
    System.out.println("equals3 = " + equals3);
    System.out.println("equals4 = " + equals4);

    var compare = Arrays.compare(first, second);
    System.out.println("compare = " + compare);
  }
}
