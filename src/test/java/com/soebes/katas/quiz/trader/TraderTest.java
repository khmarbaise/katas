package com.soebes.katas.quiz.trader;

import org.junit.jupiter.api.Test;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TraderTest {
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario", "Milan");
	Trader alan = new Trader("Alan", "Cambridge");
	Trader brian = new Trader("Brian", "Cambridge");
	List<Transaction> transactions = Arrays.asList(
	    new Transaction(brian, 2011, 300),
	    new Transaction(raoul, 2012, 1000),
	    new Transaction(raoul, 2011, 400),
	    new Transaction(mario, 2012, 710),
	    new Transaction(mario, 2012, 700),
	    new Transaction(alan, 2012, 950));

	@Test
	void quiz55_1() {
		List<Transaction> sorted = transactions.stream()
											   .filter(s -> s.getYear() == 2011)
											   .sorted(comparingInt(Transaction::getValue))
											   .collect(toList());
		sorted.forEach(s -> System.out.println(" " + s.getTrader()
													  .getName() + " Value:" + s.getValue()));
	}

	@Test
	void quiz55_2() {
		List<String> collect = transactions.stream()
		    .map(t -> t.getTrader()
		        .getCity())
		    .distinct()
		    .collect(toList());
		collect.forEach(s -> System.out.println("City:" + s));
	}

	@Test
	void quiz55_3() {
		List<Trader> cambridge = transactions
		    .stream()
		    .map(Transaction::getTrader)
		    .filter(s -> s
		        .getCity()
		        .equals("Cambridge"))
		    .distinct()
		    .sorted(comparing(Trader::getName))
		    .collect(toList());

		cambridge.forEach(s -> System.out.println("Name: " + s
		    .getName()));
	}

	@Test
	void quiz55_4() {
		String collect = transactions.stream()
		    .map(t -> t.getTrader()
		        .getName())
		    .distinct()
		    .sorted()
		    .collect(joining(","));

		System.out.println("Collect:" + collect);
	}

	@Test
	void quizz_5() {

		boolean milan = transactions.stream()
		    .anyMatch(s -> s.getTrader()
		        .getCity()
		        .equals("Milan"));

		System.out.println("any traders in milan: " + milan);

	}

	@Test
	void quizz_6() {
		List<Transaction> cambridge = transactions.stream()
		    .filter(s -> s.getTrader()
		        .getCity()
		        .equals("Cambridge"))
		    .collect(toList());

		cambridge.forEach(s -> System.out.println("Transaction:" + s.getTrader()
		    .getCity() + " v:" + s.getValue() + " y:" + s.getYear()));
	}

	@Test
	void quizz_7() {
		Optional<Transaction> max = transactions.stream()
		    .max(comparing(Transaction::getValue));

		System.out.println("Highest oder:" + max.orElseThrow());
	}

	@Test
	void quizz_8() {
		Optional<Transaction> min = transactions.stream()
		    .min(comparing(Transaction::getValue));

		System.out.println("Lowest oder:" + min.get()
		    .getValue());
	}

}
