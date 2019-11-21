package com.soebes.gof.visitor;

import com.soebes.gof.visitor.model.Body;
import com.soebes.gof.visitor.model.Car;
import com.soebes.gof.visitor.model.Engine;
import com.soebes.gof.visitor.model.Wheel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PlayWithVisitor {

  public static void main(String[] args) {

    Car renault = new Car();

    Map<Class<?>, Function<Object, String>> registry = new HashMap<>();

    VisitorBuilder<String> visitorBuilder = (type, function) -> registry.put(type, function);

    visitorBuilder.register(Car.class, car -> "Visited car " + car);
    visitorBuilder.register(Body.class, body -> "Visited body " + body);
    visitorBuilder.register(Engine.class, engine -> "Visited engine " + engine);
    visitorBuilder.register(Wheel.class, wheel -> "Visited wheel " + wheel);

    Visitor<String> visitor = o -> registry.get(o.getClass()).apply(o);

    String visit = visitor.visit(renault);
    System.out.println("renault  = " + visit);

    String visit1 = visitor.visit(renault.getBody());
    System.out.println("visit1 = " + visit1);

  }

}
