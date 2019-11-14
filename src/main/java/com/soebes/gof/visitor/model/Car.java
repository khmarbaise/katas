package com.soebes.gof.visitor.model;

import com.soebes.gof.visitor.Visitor;

import java.util.stream.Collector;
import java.util.stream.Stream;

import static com.soebes.gof.visitor.model.Location.*;

public class Car {

  private Body body = new Body();
  private Engine engine = new Engine();
  private Wheel[] wheels = {new Wheel(FrontLeft), new Wheel(FrontRight), new Wheel(BackLeft), new Wheel(BackRight)};

  public <R, RR> RR accept(Visitor<R> visitor, Collector<? super R, ?, RR> collector) {
    R r1 = this.body.accept(visitor);
    R r2 = this.engine.accept(visitor);
    R rw0 = this.wheels[0].accept(visitor);
    R rw1 = this.wheels[1].accept(visitor);
    R rw2 = this.wheels[2].accept(visitor);
    R rw3 = this.wheels[3].accept(visitor);
    R rself = accept(visitor);
    return Stream.of(r1, r2, rw0, rw1, rw2, rw3, rself).collect(collector);
  }

  private <R> R accept(Visitor<R> visitor) {
    return visitor.visit(this);
  }


  public Body getBody() {
    return body;
  }

  public Engine getEngine() {
    return engine;
  }

  @Override
  public String toString() {
    return "Car";
  }

}
