package com.soebes.katas.java8;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

public class StreamsTest {

	@Test
	public void testName() throws Exception {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

		List<Runnable> runnables = List.of(
		    () -> {
			    String threadName = Thread.currentThread()
			        .getName();
			    System.out.println("Hello 1 " + threadName);
		    },
		    () -> {
			    String threadName = Thread.currentThread()
			        .getName();
			    System.out.println("Hello 2 " + threadName);
		    },
		    () -> {
			    String threadName = Thread.currentThread()
			        .getName();
			    System.out.println("Hello 3 " + threadName);
		    },
		    () -> {
			    String threadName = Thread.currentThread()
			        .getName();
			    System.out.println("Hello 4 " + threadName);
		    });
		runnables.forEach(newSingleThreadExecutor::submit);

	}
}
