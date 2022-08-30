package com.soebes.supplier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class SuppConsumerTest {

  private <T> void setValueNonNull(Supplier<T> keyExtractor, Consumer<T> setter) {
    if (Objects.nonNull(keyExtractor.get())) {
      setter.accept(keyExtractor.get());
    }
  }
  @Test
  void name() {
    var source = new Source("First", List.of("A", "B"));
    var target = new Target();

    setValueNonNull(source::getName, target::setName);
    setValueNonNull(source::getItems, target::setItems);

    assertThat(target.getName()).isEqualTo(source.getName());
    assertThat(target.getItems()).containsAll(source.getItems());
  }

  static class Source {
    private final String name;
    private final List<String> items;

    public Source(String name, List<String> items) {
      this.name = name;
      this.items = new ArrayList<>(items);
    }

    public String getName() {
      return name;
    }

    public List<String> getItems() {
      return items;
    }

  }

  static class Target {
    private String name;
    private List<String> items;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public List<String> getItems() {
      return items;
    }

    public void setItems(List<String> items) {
      this.items = new ArrayList<>(items);
    }
  }


}
