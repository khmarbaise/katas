package com.soebes.gof.visitor;

import com.soebes.gof.visitor.model.Body;
import com.soebes.gof.visitor.model.Car;
import com.soebes.gof.visitor.model.Engine;
import com.soebes.gof.visitor.model.Wheel;

public interface Visitor<R> {

  R visit(Car car);

  R visit(Body body);

  R visit(Engine engine);

  R visit(Wheel wheel);

}
