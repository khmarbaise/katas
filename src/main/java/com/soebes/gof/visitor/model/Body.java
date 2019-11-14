package com.soebes.gof.visitor.model;

import com.soebes.gof.visitor.Visitor;

public class Body {

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visit(this);
  }

  @Override
  public String toString() {
    return "Body";
  }

}
