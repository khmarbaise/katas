package com.soebes.katas.list;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {

	private final IntPredicate EVEN = s -> s % 2 == 0;
	
	private final IntPredicate LESS_THAN_TEN = s -> s < 10;

	private IntStream rangeClosed;


	@BeforeEach
	void before() {
		this.rangeClosed = IntStream.rangeClosed(0, 1_000);
	}

	@Test
	void firstTest() {
		List<Integer> collect = rangeClosed.takeWhile(LESS_THAN_TEN.and(EVEN)).boxed().collect(Collectors.toList());
		collect.forEach(s -> System.out.println("s: " + s));

	}

	@Test
	void secondTest() {
		List<Integer> collect2 = rangeClosed.filter(LESS_THAN_TEN.and(EVEN)).boxed().collect(Collectors.toList());
		collect2.forEach(s -> System.out.println("s2: " + s));
	}

	@Test
	void thirdTest() {
		List<Integer> collect2 = rangeClosed.filter(s -> s > 10 && s < 100).boxed().collect(Collectors.toList());
		collect2.forEach(s -> System.out.println("s3: " + s));
	}

	@Test
	void forthTestWithtakeWhile() {
		List<Integer> collect2 = rangeClosed.takeWhile(s -> (s > 0 && s < 100)).boxed().collect(Collectors.toList());
		collect2.forEach(s -> System.out.println("s4: " + s));
	}


	@Test
	void othetr() {
		boolean collect2 = rangeClosed.noneMatch(s -> s > 999);
		System.out.println("noneMatch:" + collect2);
	}
}
