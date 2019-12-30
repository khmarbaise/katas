package com.soebes.pattern.course;

import java.util.AbstractList;
import java.util.Objects;

public class ReadOnlyArrayList<E> extends AbstractList<E> {

  private final Object[] elements;

  public ReadOnlyArrayList(Object... elements) {
    this.elements = elements.clone();
  }

  @Override
  public E get(int index) {
    Objects.checkIndex(index, size());
    return (E) elements[index];
  }

  @Override
  public int size() {
    return elements.length;
  }
}
