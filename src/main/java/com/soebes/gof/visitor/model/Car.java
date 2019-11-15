package com.soebes.gof.visitor.model;

import java.util.Arrays;
import java.util.StringJoiner;

import static com.soebes.gof.visitor.model.Location.*;

public class Car {

  private Body body = new Body();
  private Engine engine = new Engine();
  private Wheel[] wheels = {new Wheel(FrontLeft), new Wheel(FrontRight), new Wheel(BackLeft), new Wheel(BackRight)};

  public Body getBody() {
    return body;
  }

  public Engine getEngine() {
    return engine;
  }

  public Wheel[] getWheels() {
    return wheels;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]").add("body=" + body)
      .add("engine=" + engine)
      .add("wheels=" + Arrays.toString(wheels))
      .toString();
  }
}
