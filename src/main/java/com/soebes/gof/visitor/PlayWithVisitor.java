package com.soebes.gof.visitor;

import com.soebes.gof.visitor.model.Body;
import com.soebes.gof.visitor.model.Car;
import com.soebes.gof.visitor.model.Engine;
import com.soebes.gof.visitor.model.Wheel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayWithVisitor {

  public static void main(String[] args) {

    Car renault = new Car();

    //    VisitorInitializer<String> visitorInitializer = builder -> {
    //      builder.register(Car.class, car -> "Visited car " + car);
    //      builder.register(Body.class, body -> "Visited body " + body);
    //      builder.register(Engine.class, engine -> "Visited engine " + engine);
    //      builder.register(Wheel.class, wheel -> "Visited wheel " + wheel);
    //    };
    VisitorInitializer<String> visitorInitializer =
      Visitor.<Car, String>forType(Car.class).execute((Car car) -> "Visited car " + car)
        .forType(Body.class).execute((Body body) -> "Visited body " + body)
        .forType(Engine.class).execute((Engine engine) -> "Visited engine " + engine)
        .forType(Wheel.class).execute((Wheel wheel) -> "Visited wheel " + wheel);

    Visitor<String> visitor = Visitor.of(visitorInitializer);

    String visit = visitor.visit(renault);
    System.out.println("renault  = " + visit);

    String visit1 = visitor.visit(renault.getBody());
    System.out.println("visit1 = " + visit1);

    List<Integer> integers = List.of(1, 2, 3);
    integers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
  }

}
