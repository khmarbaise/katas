package com.soebes.gof.visitor.model;

import com.soebes.gof.visitor.Visitor;

public class Body {

  @Override
  public String toString() {
    return "Body";
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
