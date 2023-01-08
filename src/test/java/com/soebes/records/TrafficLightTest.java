package com.soebes.records;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Map.entry;

class TrafficLightTest {

  public enum TrafficLight {
    RED, YELLOW, GREEN
  }

  private static final Map<TrafficLight, Consumer<TrafficLight>> LIGHTS = Map.ofEntries(
      entry(TrafficLight.RED, (light) -> System.out.println("RED light = " + light)),
      entry(TrafficLight.YELLOW, (light) -> System.out.println("YELLOW light = " + light)),
      entry(TrafficLight.GREEN, (light) -> System.out.println("GREEN light = " + light))
  );


  static Consumer<TrafficLight> brokenLight = (light) -> {
    System.out.println("Broken Light!");
  };

  static class CampaignResults {

  }

  static class Customer {

  }
  @Test
  void name() {
    var customers = List.<Customer>of();
    var campaignResults = new ArrayList<CampaignResults>();

//    customers.stream().filter(c -> campain.xy(campaignResults, c));
  }

  static class Dog {

  }

  @Test
  void nullForInstanceOf() {
    Dog dog = null;
    boolean result = dog instanceof Dog;
    System.out.println("result = " + result);

    var dogs = new ArrayList<Dog>();
    dogs.add(new Dog());
    dogs.add(null);
    dogs.add(new Dog());

    var resultDogs = dogs.stream()
        .filter(Dog.class::isInstance)
        .toList();

    System.out.println("resultDogs = " + resultDogs);

  }
}
