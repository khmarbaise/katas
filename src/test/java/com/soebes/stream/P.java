package com.soebes.stream;

import java.util.Objects;
import java.util.StringJoiner;

public class P {
  private String name;
  private Integer age;

  public P(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String toString() {
    return new StringJoiner(", ", P.class.getSimpleName() + "[", "]").add("name='" + name + "'")
      .add("age=" + age)
      .toString();
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    P p = (P) o;
    return Objects.equals(name, p.name) && Objects.equals(age, p.age);
  }

  public int hashCode() {
    return Objects.hash(name, age);
  }
}
