package com.soebes.gof.visitor.model;

import com.soebes.gof.visitor.Visitor;

public class Wheel {

  private Location location;

  public Wheel(Location location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "Wheel(" + location + ")";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
