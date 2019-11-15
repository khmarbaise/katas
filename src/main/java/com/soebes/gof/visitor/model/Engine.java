package com.soebes.gof.visitor.model;

import java.util.StringJoiner;

public class Engine {

  @Override
  public String toString() {
    return new StringJoiner(", ", Engine.class.getSimpleName() + "[", "]").toString();
  }
}
