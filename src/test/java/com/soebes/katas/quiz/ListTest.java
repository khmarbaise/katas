package com.soebes.katas.quiz;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ListTest {
	@Test
	void listTestNumber1() {
		List<Integer> integers = List.of(1, 2, 3, 4);

		String collect = integers.stream()
		    .map(s -> s.toString())
		    .collect(Collectors.joining());

		System.out.println("Result:" + collect);
	}
}
