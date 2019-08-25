package com.soebes.junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Junit5Test {

  @BeforeAll
  static void beforeAll() {
    System.out.println("Junit5Test.beforeAll");
  }

  @BeforeEach
  void beforeEach() {
    System. out.println("Junit5Test.beforeEach");
  }

  @Test
  void firstTest() {
    System.out.println("Junit5Test.firstTest");
  }

  @Test
  void secondTest() {
    System.out.println("Junit5Test.secondTest");
  }
}
