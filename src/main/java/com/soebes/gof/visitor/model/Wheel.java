package com.soebes.gof.visitor.model;

import com.soebes.gof.visitor.Visitor;

public class Wheel {

  private Location location;

  public Wheel(Location location) {
    this.location = location;
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visit(this);
  }

  @Override
  public String toString() {
    return "Wheel(" + location + ")";
  }

}
