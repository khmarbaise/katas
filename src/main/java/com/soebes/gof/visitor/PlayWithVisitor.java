package com.soebes.gof.visitor;

import com.soebes.gof.visitor.model.Body;
import com.soebes.gof.visitor.model.Car;
import com.soebes.gof.visitor.model.Engine;
import com.soebes.gof.visitor.model.Wheel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class PlayWithVisitor {

  public static void main(String[] args) {

    Car renault = new Car();

    Map<Class<?>, Function<Object, String>> registry = new HashMap<>();

    VisitorBuilder<String> visitorBuilder = (type, function) -> registry.put(type, function);

    Consumer<VisitorBuilder<String>> consumer = builder -> {
      builder.register(Car.class, car -> "Visited car " + car);
      builder.register(Body.class, body -> "Visited body " + body);
      builder.register(Engine.class, engine -> "Visited engine " + engine);
      builder.register(Wheel.class, wheel -> "Visited wheel " + wheel);
    };

    consumer.accept(visitorBuilder);
    Visitor<String> visitor = o -> registry.get(o.getClass()).apply(o);

    String visit = visitor.visit(renault);
    System.out.println("renault  = " + visit);

    String visit1 = visitor.visit(renault.getBody());
    System.out.println("visit1 = " + visit1);

  }

}
