package com.soebes.pattern.course;

public interface TheInterface {


  default void first() {

  }

  static void xyz() {
    // This is a static method in interface.
  }

  private static void w () {
    // This is a private static method in interface
  }
}
