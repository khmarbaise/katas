package com.soebes.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.junit.jupiter.api.Test;

public class BlockingQueueTest {

  @Test
  void name() {

    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

  }
}
