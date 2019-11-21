package com.soebes.gof.visitor;

import java.util.function.Consumer;

public interface VisitorInitializer<R> extends Consumer<VisitorBuilder<R>> {

  default void init(VisitorBuilder<R> visitorBuilder) {
    this.accept(visitorBuilder);
  }

}
