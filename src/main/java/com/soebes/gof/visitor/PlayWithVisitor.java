package com.soebes.gof.visitor;

import com.soebes.gof.visitor.model.Body;
import com.soebes.gof.visitor.model.Car;
import com.soebes.gof.visitor.model.Engine;
import com.soebes.gof.visitor.model.Wheel;

public class PlayWithVisitor {

  public static void main(String[] args) {

    Car renault = new Car();

    var visitor = new Visitor() {
      private String visited = "";

      @Override
      public void visit(Car car) {
        this.visited += "Visited car:" + car;
      }

      @Override
      public void visit(Body body) {
        this.visited += "Visited body:" + body;
      }

      @Override
      public void visit(Engine engine) {
        this.visited += "Visited engine:" + engine;
      }

      @Override
      public void visit(Wheel wheel) {
        this.visited += "Visited wheel:" + wheel;
      }

      public String getVisited() {
        return this.visited;
      }
    };


    renault.accept(visitor);
    String visited = visitor.getVisited();
    System.out.println("visitor = " + visited);
  }
}
