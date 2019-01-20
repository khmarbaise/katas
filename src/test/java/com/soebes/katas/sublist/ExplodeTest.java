package com.soebes.katas.sublist;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.LongFunction;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

class ExplodeTest {
	private List<String> LIST_OF_WORDS = List.of("alpha", "bravo", "charlie", "delta", "foxtrot",
	    "golf", "hotel", "india", "juliet", "kilo", "lima",
	    "mike", "november", "oscar", "papa", "quebec", "romeo",
	    "siera", "tango", "uniform", "victor",
	    "whiskey", "x-ray", "yankee", "zulu");

	List<String> expand(String word) {
		// JDK 11
		// word.codePoints().mapToObj( Character::toString ).collect(
		// Collectors.toList() );
		return word.codePoints()
		    .mapToObj((int t) -> String.valueOf((char) t))
		    .collect(toList());
	}

	@Test
	void testName() {
		String c = Character.toString((char) 65);

		System.out.println("C='" + c + "'");
		String a = "abcßüÖÄ";
		List<String> result = a.codePoints().mapToObj((int t) -> String.valueOf((char) t)).collect(toList());

		assertThat(result).containsExactly("a", "b", "c", "ß", "ü", "Ö", "Ä");
	}

	@Test
	void listTests() {
		LIST_OF_WORDS.stream()
		    .map(String::toUpperCase)
		    .filter(s -> s.length() == 6)
		    .forEach(System.out::println);
	}

	@Test
	void testMap1() {
		List<List<String>> collect = LIST_OF_WORDS
		    .stream()
		    .map(word -> expand(word))
		    .collect(toList());

		System.out.println("collect:" + collect);
	}

	@Test
	void testMap2() {
		System.out.println("Hello World-----------");
		List<String> collect = LIST_OF_WORDS //
		    .stream() //
		    .flatMap(word -> expand(word).stream()) //
		    .collect(toList());

		System.out.println("collect2:" + collect);
	}

	private List<String> sonnet = List.of(
	    "From fairest creatures we desire increase,",
	    "That thereby beauty's rose might never die,",
	    "But as the riper should by time decease,",
	    "His tender heir might bear his memory:",
	    "But thou contracted to thine own bright eyes,",
	    "Feed'st thy light's flame with self-substantial fuel,",
	    "Making a famine where abundance lies,",
	    "Thy self thy foe, to thy sweet self too cruel:",
	    "Thou that art now the world's fresh ornament,",
	    "And only herald to the gaudy spring,",
	    "Within thine own bud buriest thy content,",
	    "And, tender churl, mak'st waste in niggarding:",
	    "Pity the world, or else this glutton be,",
	    "To eat the world's due, by the grave and thee.");

	@Test
	void testFlatMap1() {
		List<String> collect = sonnet
		    .stream()
		    .flatMap(line -> Arrays.stream(line.split(" +")))
		    .collect(toList());

		System.out.println("testFlatMap1::" + collect);

	}

	LongFunction<BigInteger> CONVERT_TO_BIGINTEGER = (long s) -> {
		return BigInteger.valueOf(s);
	};

	@Test
	void factoral_Reduce() {
		BigInteger reduce = LongStream //
		    .rangeClosed(1, 500) //
		    .mapToObj(BigInteger::valueOf) //
		    .reduce(BigInteger.ONE, BigInteger::multiply);
		System.out.println("Reduce length=" + reduce.toString().length());
		System.out.println("Reduce=" + reduce);

	}

	@Test
	void mapReduceExample() {
		Pattern pattern = Pattern.compile("[, ':\\-]+");

		LIST_OF_WORDS.forEach(s -> System.out.println(s));
		// pattern.splitAsStream( input );
		Map<String, Long> map = Map.of("a", Long.valueOf(1));

		Map.Entry.comparingByValue();

		// map.entrySet().stream().max( Mapcomparator );
		// BigInteger reduce = LongStream
		// .rangeClosed( 1, 100 )
		// .mapToObj( Long::valueOf )
		// .reduce( LongI, LongAccumulator::accumulate );
	}
}
