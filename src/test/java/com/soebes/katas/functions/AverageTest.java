package com.soebes.katas.functions;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class AverageTest {

	IntSupplier supplier = new IntSupplier() {
		private int nextInt = 0;
		@Override
		public int getAsInt() {
			return nextInt++;
		}
	};

	@Test
	void testName() {
		final int[] nextInt = { 0 }; // optionally mark as final
		IntSupplier supplier = () -> nextInt[0]++;
		
		IntUnaryOperator identity = IntUnaryOperator.identity();
		
		IntStream.generate(supplier).limit(10000L).forEach(s -> System.out.println(s));
		LongStream.rangeClosed(1L, 100L).forEach(s -> System.out.println(s));

		IntStream.rangeClosed(1, 20000)
				 .mapToObj(i -> Integer.valueOf(i))
				 .collect(Collectors.toList());

	}

}
