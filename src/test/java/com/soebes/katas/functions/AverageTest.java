package com.soebes.katas.functions;

import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
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
		
//		IntStream.generate(supplier).forEach(s -> System.out.println(s));
		LongStream.rangeClosed(1L, 100L).forEach(s -> System.out.println(s));
	}
}
