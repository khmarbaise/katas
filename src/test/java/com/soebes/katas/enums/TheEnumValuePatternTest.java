package com.soebes.katas.enums;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class TheEnumValuePatternTest {

	@Test
	void testName() {
//		Arrays.stream(TheEnumValuePattern.values()).filter(s -> s.);
	}

	@Test
	void firstValueShouldBeconverted() {
		TheEnumValuePattern fromValue = TheEnumValuePattern.fromValue("BEGINNING-First");

		assertThat(fromValue).isEqualTo(TheEnumValuePattern.FIRST);
	}

	@Test
	void first() {
		Field[] declaredFields = TheEnumValuePattern.Values.class.getDeclaredFields();

		List<Field> collect = Arrays.stream(declaredFields) //
				.filter(s -> !s.isSynthetic() && s.canAccess(null)) //
				.collect(Collectors.toList());

		collect.forEach(s -> {
			try {
				System.out.println(
						"Field:" + s.getName() + " " + Modifier.isPublic(s.getModifiers()) + " V:" + s.get(null));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	private final Predicate<Field> Field_Is_PublicStaticFinal = s -> //
			Modifier.isPublic(s.getModifiers()) //
		&&	Modifier.isStatic(s.getModifiers()) //
		&&	Modifier.isFinal(s.getModifiers()) //
	;

	/**
	 * Synthetic fields seemed to be generated during running of unit tests in
	 * relationship with JaCoCo code coverage tool.
	 */
	private final Predicate<Field> Field_Is_Not_Synthentic = s -> !s.isSynthetic();

	@Test
	void first_a() {
		Field[] declaredFields = TheEnumValuePattern.Values.class.getDeclaredFields();

		List<Field> collect = Arrays.stream(declaredFields) //
				.filter(Field_Is_Not_Synthentic.and(Field_Is_PublicStaticFinal)) //
				.collect(Collectors.toList());

		collect.forEach(s -> System.out.println("Field:" + s.getName() + " " + Modifier.isPublic(s.getModifiers())));
		
	}

	@Test
	void third() {

	}
}
