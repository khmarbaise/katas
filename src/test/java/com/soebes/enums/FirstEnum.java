package com.soebes.enums;


import java.util.StringJoiner;
import java.util.stream.Stream;

public enum FirstEnum {

  RIO_DE_JANEIRO("Rio de Janeiro", true, 2000.0) {

  },
  MONTREAL_PARKNG_STREET("Montreal", true, 500.0) {

  };

  private String city;
  private boolean parkingInTheStreet;
  private Double price;

  FirstEnum(String city, boolean parkingInTheStreet, Double price) {
    this.city = city;
    this.parkingInTheStreet = parkingInTheStreet;
    this.price = price;
  }

  public static FirstEnum valueOf(String city, boolean parkingInTheStreet) {
    return Stream.of(FirstEnum.values())
        .filter(e -> e.city.equals(city) && e.parkingInTheStreet == parkingInTheStreet)
        .findAny().orElseThrow(IllegalArgumentException::new);
  }

    @Override
    public String toString() {
        return new StringJoiner(", ", FirstEnum.class.getSimpleName() + "[", "]")
            .add("city='" + city + "'")
            .add("parkingInTheStreet=" + parkingInTheStreet)
            .add("price=" + price)
            .toString();
    }
}