package com.soebes.gof.visitor;

import java.util.function.BiConsumer;
import java.util.function.Function;

public interface VisitorBuilder<R> extends BiConsumer<Class<?>, Function<Object, R>> {

}
