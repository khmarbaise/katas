package com.soebes.playground;

import java.util.function.Consumer;

/**
 * Class which represents a single resource.
 */
public class Resource {

  private Resource() {
    System.out.println("Creating Resource");
  }

  // Loan Pattern
  public static void use(Consumer<Resource> consumer) {
    Resource resource = new Resource();
    try {
      consumer.accept(resource);
    } finally {
      resource.close();
    }
  }

  public void operation1() {
    System.out.println("Resource.operation1");
  }

  public void operation2() {
    System.out.println("Resource.operation2");
  }

  private void close() {
    System.out.println("Resource cleaned up.");
  }
}
