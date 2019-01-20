package com.soebes.katas.quiz.pythagoras;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class PythagorasTest {

	static final BiFunction<Integer, Integer, Double> Squared = (a, b) -> Math.sqrt(a * a + b * b);

	static final DoubleFunction<Boolean> DIVIDER = (t) -> t % 1.0 == 0;

	@Test
	void testName() {

		Stream<Pythagoras> result = IntStream
		    .rangeClosed(1, 100)
		    .boxed()
		    .flatMap(a -> IntStream
		        .rangeClosed(a, 100)
		        .filter(b -> DIVIDER.apply(Squared.apply(a, b)))
		        .mapToObj(
		            b -> new Pythagoras(a, b, Squared.apply(a, b).intValue())));

		result.forEach(t -> System.out.println(t));
	}

}
