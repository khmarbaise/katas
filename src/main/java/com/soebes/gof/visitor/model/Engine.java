package com.soebes.gof.visitor.model;

import com.soebes.gof.visitor.Visitor;

public class Engine {

  @Override
  public String toString() {
    return "Engine";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
