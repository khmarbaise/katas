package com.soebes.katas.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

public class StreamsTest {

  @Test
  public void testName() throws Exception {
    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
    
    Runnable task = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello " + threadName);
    };
    
    newSingleThreadExecutor.submit(task);
    
    
  }
}
