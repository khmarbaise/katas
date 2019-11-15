package com.soebes.gof.visitor.model;

import java.util.StringJoiner;

public class Wheel {

  private Location location;

  public Wheel(Location location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Wheel.class.getSimpleName() + "[", "]").add("location=" + location).toString();
  }
}
