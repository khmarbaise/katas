package com.soebes.stream;

import java.util.StringJoiner;

public record P(String name, Integer age) {

  public String toString() {
    return new StringJoiner(", ", P.class.getSimpleName() + "[", "]").add("name='" + name + "'")
        .add("age=" + age)
        .toString();
  }

}
