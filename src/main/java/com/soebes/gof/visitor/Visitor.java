package com.soebes.gof.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Visitor<R> {

  static <R> Visitor<R> of(VisitorInitializer<R> visitorInitializer) {
    Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
    visitorInitializer.init(registry::put);
    return o -> registry.get(o.getClass()).apply(o);
  }

  R visit(Object o);

}
