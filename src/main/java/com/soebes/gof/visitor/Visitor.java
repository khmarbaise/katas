package com.soebes.gof.visitor;

import com.soebes.gof.visitor.model.Body;
import com.soebes.gof.visitor.model.Car;
import com.soebes.gof.visitor.model.Engine;
import com.soebes.gof.visitor.model.Wheel;

public interface Visitor {

  void visit(Car car);

  void visit(Body body);

  void visit(Engine engine);

  void visit(Wheel wheel);

}
