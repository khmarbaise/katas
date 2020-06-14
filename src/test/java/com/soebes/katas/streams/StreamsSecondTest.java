package com.soebes.katas.streams;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

class StreamsSecondTest {

	@Test
	void testName() {

		// 0..10 =>
		// k:0 v: 10*k
		// k:1 v: 10*1

		Map<Long, Long> result = IntStream.rangeClosed(0, 10)
				.mapToObj(v -> Long.valueOf(v))
				.collect(toMap(kmap -> kmap, vmap -> 10L * vmap));

		result.entrySet().forEach(e -> System.out.println("k:" + e.getKey() + " v:" + e.getValue()));

	}

	@Test
	void second_test() {
		// 0..10 =>
		// k:0 v: 10*k
		// k:1 v: 10*1
		Map<Long, Long> result = IntStream.rangeClosed(0, 10)
				.mapToObj(Long::valueOf)
				.collect(valueMapperOnly(vmap -> 10L * vmap));

		result.entrySet().forEach(e -> System.out.println("k:" + e.getKey() + " v:" + e.getValue()));
	}

	public static <T, K, U> Collector<T, ?, Map<K, U>> valueMapperOnly(Function<? super T, ? extends U> valueMapper) {
		return toMap(Function.identity(), valueMapper);
	}

//	public static <T, K, U>
//	Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
//									Function<? super T, ? extends U> valueMapper) {
//
//
//	}
}