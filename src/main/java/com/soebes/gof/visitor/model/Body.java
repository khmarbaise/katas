package com.soebes.gof.visitor.model;

import java.util.StringJoiner;

public class Body {

  @Override
  public String toString() {
    return new StringJoiner(", ", Body.class.getSimpleName() + "[", "]").toString();
  }
}
