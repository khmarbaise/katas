package com.soebes.katas.enums;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

class TheEnumValuePatternTest {
  
  public static final String FIRST = "Das ist ein sehr langer Text. " + "Der geht hier weiter " +
    "als" + " Ihr alle Denkt. Es doch noch weiter.";

  private final Predicate<Field> isStatic = s -> Modifier.isStatic(s.getModifiers());
  private final Predicate<Field> isFinal = s -> Modifier.isFinal(s.getModifiers());
  private final Predicate<Field> isPublic = s -> Modifier.isPublic(s.getModifiers());
  /**
   * Synthetic fields seemed to be generated during running of unit tests in relationship with
   * JaCoCo code coverage tool.
   */
  private final Predicate<Field> isSynthetic = Field::isSynthetic;
  private final Predicate<Field> isValidField = not(isSynthetic).and(isPublic)
    .and(isStatic)
    .and(isFinal);
  
  @Test
  void testName() {
    // Arrays.stream(TheEnumValuePattern.values()).filter(s -> s.);
  }
  
  @Test
  void firstValueShouldBeconverted() {
    TheEnumValuePattern fromValue = TheEnumValuePattern.fromValue("BEGINNING-First");
    
    assertThat(fromValue).isEqualTo(TheEnumValuePattern.FIRST);
  }
  
  @Test
  void first() {
    Field[] declaredFields = TheEnumValuePattern.Values.class.getDeclaredFields();
    
    List<Field> collect = Stream.of(declaredFields)
      .filter(s -> s.isSynthetic() && s.canAccess(null))
      .toList();
    
    collect.forEach(s -> {
      try {
        System.out.println("Field:" + s.getName() + " " + Modifier.isPublic(s.getModifiers()) +
          " V:" + s
          .get(null));
      } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
    
  }
  
  private String getValueOfField(Field f) {
    String result = "";
    try {
      result = (String) f.get(null);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return result;
  }
  
  @Test
  void first_a() {
    Field[] declaredFields = TheEnumValuePattern.Values.class.getDeclaredFields();
    
    List<Field> collect = Arrays.stream(declaredFields)
      .filter(isValidField)
      .collect(Collectors.toList());
    
    collect.forEach(s -> System.out.println("Field:" + s.getName() + " public static final:" + isValidField
      .test(s)));
    
  }
  
  @Test
  void third() {
  
  }
}
