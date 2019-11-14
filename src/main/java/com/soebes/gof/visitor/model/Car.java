package com.soebes.gof.visitor.model;

import com.soebes.gof.visitor.Visitor;

import java.util.List;

import static com.soebes.gof.visitor.model.Location.*;

public class Car {

  private Body body = new Body();
  private Engine engine = new Engine();
  private List<Wheel> wheels = List.of(new Wheel(FrontLeft), new Wheel(FrontRight), new Wheel(BackLeft),
    new Wheel(BackRight));

  public Body getBody() {
    return body;
  }

  public Engine getEngine() {
    return engine;
  }

  public List<Wheel> getWheels() {
    return wheels;
  }

  @Override
  public String toString() {
    return "Car";
  }

  public void accept(Visitor visitor) {
    this.body.accept(visitor);
    this.engine.accept(visitor);
    this.wheels.stream().forEach(wheel -> wheel.accept(visitor));
    visitor.visit(this);
  }
}
