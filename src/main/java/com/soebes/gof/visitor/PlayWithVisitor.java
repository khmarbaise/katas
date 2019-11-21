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

    VisitorBuilder<String> biConsumer = (type, function) -> registry.put(type, function);

    biConsumer.accept(Car.class, car -> "Visited car " + car);
    biConsumer.accept(Body.class, body -> "Visited body " + body);
    biConsumer.accept(Engine.class, engine -> "Visited engine " + engine);
    biConsumer.accept(Wheel.class, wheel -> "Visited wheel " + wheel);

    Visitor<String> visitor = o -> registry.get(o.getClass()).apply(o);

    String visit = visitor.visit(renault);
    System.out.println("renault  = " + visit);

    String visit1 = visitor.visit(renault.getBody());
    System.out.println("visit1 = " + visit1);

  }

}
