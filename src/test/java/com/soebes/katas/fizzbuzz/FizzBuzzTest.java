package com.soebes.katas.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

	/*
	 * "Write a program that prints the numbers from 1 to 100. But for multiples of
	 * three print “Fizz” instead of the number and for the multiples of five print
	 * “Buzz”. For numbers which are multiples of both three and five print
	 * “FizzBuzz”."
	 * 
	 */
	@Test
	public void first() {
		assertThat(fizzBuzz(1)).isEqualTo("1");
	}

	@Test
	public void second() {
		assertThat(fizzBuzz(3)).isEqualTo("Fizz");
	}

	@Test
	public void third() {
		assertThat(fizzBuzz(4)).isEqualTo("4");
	}

	@Test
	public void forth() {
		assertThat(fizzBuzz(6)).isEqualTo("Fizz");
	}

	@Test
	public void fifth() {
		assertThat(fizzBuzz(10)).isEqualTo("Buzz");
	}

	@Test
	public void sixth() {
		assertThat(fizzBuzz(15)).isEqualTo("FizzBuzz");
	}

	private String fizzBuzz(int i) {
		StringBuilder sb = new StringBuilder();

		if (i % 15 == 0) {
			sb.append("FizzBuzz");
		} else if (i % 3 == 0) {
			sb.append("Fizz");
		} else if (i % 5 == 0) {
			sb.append("Buzz");
		} else {
			sb.append(Integer.toString(i));
		}

		return sb.toString();
	}
}
