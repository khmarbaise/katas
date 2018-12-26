package com.soebes.katas.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsSecondTest {

	@Test
	void testName() {

		// 0..10 =>
		// k:0 v: 10*k
		// k:1 v: 10*1

		Map<Long, Long> result = IntStream.rangeClosed(0, 10)
										  .mapToObj(v -> Long.valueOf(v))
										  .collect(Collectors.toMap(kmap -> kmap, vmap -> 10L * vmap));

		result.entrySet().forEach(e -> System.out.println("k:" + e.getKey() + " v:" + e.getValue()));

	}
}
