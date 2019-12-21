package com.soebes.katas.enums;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TheEnumValuePattern {

	/**
	 * FIRST
	 */
	FIRST(Values.FIRST),
	/**
	 * SECOND
	 */
	SECOND(Values.SECOND),
	/**
	 * THIRD.
	 */
	THIRD(Values.THIRD);

	private final String value;

	TheEnumValuePattern(String value) {
		this.value = value;
	}

	public final String getValue() {
		return this.value;
	}

	public static final class Values {
		private static final String PREFIX = "BEGINNING-";

		public static final String FIRST = PREFIX + "First";
		public static final String THIRD = PREFIX + "Third";
		public static final String SECOND = PREFIX + "Second";

		private Values() {
			// prevent instantiation.
		}
	}

	/**
	 * @param value The {@link Values} which should be converted to the appropriate
	 *              enum {@link TheEnumValuePattern}.
	 * @return a value of {@link TheEnumValuePattern}
	 * @throws {@link IllegalArgumentException} in case of an non existing text.
	 */
	public static TheEnumValuePattern fromValue(final String value) {
		return Arrays.stream(TheEnumValuePattern.values())
		    .filter(s -> s.getValue().equals(value))
		    .findAny()
		    .orElseThrow(() -> new IllegalArgumentException("The given.."));
	}

	public static String validValues() {
		return Stream.of(TheEnumValuePattern.values())
		    .map(TheEnumValuePattern::getValue)
		    .collect(Collectors.joining(",", "[", "]"));
	}
}
