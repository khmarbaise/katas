package com.soebes.gof.visitor;

@FunctionalInterface
public interface Visitor<R> {

  R visit(Object o);

}
