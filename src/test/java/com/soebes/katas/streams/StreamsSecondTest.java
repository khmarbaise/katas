package com.soebes.katas.streams;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

class StreamsSecondTest {

	@Test
	void key_identity() {
		// 0..10 =>
		// k:0 v: 10*k
		// k:1 v: 10*1
		Map<Long, Long> result = IntStream.rangeClosed(0, 10)
				.mapToObj(v -> Long.valueOf(v))
				.collect(toMap(Function.identity(), vmap -> 10L * vmap));

		result.entrySet().forEach(e -> System.out.println("k:" + e.getKey() + " v:" + e.getValue()));
	}

	@Test
	void value_identity_with_single() {
		// 0..10 =>
		// k:0 v: 10*k
		// k:1 v: 10*1
		Map<Long, Long> result = IntStream.rangeClosed(0, 10)
				.mapToObj(Long::valueOf)
				.collect(toMapValue(vmap -> 10L * vmap));

		result.entrySet().forEach(e -> System.out.println("k:" + e.getKey() + " v:" + e.getValue()));
	}

	@Test
	void key_identity_with_single() {
		// 0..10 =>
		// k:0 v: 10*k
		// k:1 v: 10*1
		Map<Long, Long> result = IntStream.rangeClosed(0, 10)
				.mapToObj(Long::valueOf)
				.collect(toMapKey(kmap -> kmap));

		result.entrySet().forEach(e -> System.out.println("k:" + e.getKey() + " v:" + e.getValue()));
	}

	public static <T, K, U> Collector<T, ?, Map<K, U>> toMapValue(Function<? super T, ? extends U> valueMapper) {
		Function<K, K> identity = Function.identity();
		return toMap((Function<T, K>) identity, valueMapper);
	}

	public static <T, K, U> Collector<T, ?, Map<K, U>> toMapKey(Function<? super T, ? extends K> keyMapper) {
		Function<U, U> identity = Function.identity();
		return toMap(keyMapper, (Function<T, U>) identity);
	}

}