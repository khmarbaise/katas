package com.soebes.sleeping;

import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Sleeping1 {

  public static void main(String[] args) throws InterruptedException {

  }

  private static void wait_variant_1() throws InterruptedException {
    System.out.println("Before sleep");
    TimeUnit.MILLISECONDS.sleep(5);
    TimeUnit.MICROSECONDS.sleep(5);
    TimeUnit.NANOSECONDS.sleep(5);
    TimeUnit.MINUTES.sleep(5);
    TimeUnit.HOURS.sleep(5);
    TimeUnit.DAYS.sleep(5);
    System.out.println("After sleep");

    TimeUnit.of(SECONDS).sleep(5);
    TimeUnit.of(MINUTES).sleep(5);
    TimeUnit.of(HOURS).sleep(5);
  }

}
