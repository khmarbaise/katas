package com.soebes.enums;

public class FirstEnuMain {

  public static void main(String[] args) {
    FirstEnum montreal = FirstEnum.valueOf("Montreal", true);
    System.out.println("montreal = " + montreal);
  }
}
