package com.soebes.katas.another;

public class FirstClassInThisPackage {
  private String name;
  private Long age;

  public FirstClassInThisPackage() {
  }

  public FirstClassInThisPackage(String name, Long age) {
    this.name = name;
    this.age = age;
    System.out.println("Message of the day.");
  }
}
