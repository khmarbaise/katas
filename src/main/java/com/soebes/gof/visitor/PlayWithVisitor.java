package com.soebes.gof.visitor;

import com.soebes.gof.visitor.model.Body;
import com.soebes.gof.visitor.model.Car;
import com.soebes.gof.visitor.model.Engine;
import com.soebes.gof.visitor.model.Wheel;

import java.util.List;
import java.util.stream.Collectors;

public class PlayWithVisitor {

  public static void main(String[] args) {

    Car renault = new Car();

    var visitor = new Visitor<String>() {
      @Override
      public String visit(Car car) {
        return "Visited car:" + car;
      }

      @Override
      public String visit(Body body) {
        return "Visited body:" + body;
      }

      @Override
      public String visit(Engine engine) {
        return "Visited engine:" + engine;
      }

      @Override
      public String visit(Wheel wheel) {
        return "Visited wheel:" + wheel;
      }
    };

    String accept = renault.accept(visitor, Collectors.joining(" -- "));
    System.out.println("accept = " + accept);

    List<String> resultList = renault.accept(visitor, Collectors.toList());
    resultList.forEach(System.out::println);
  }

}
