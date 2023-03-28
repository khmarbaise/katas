package com.soebes.sleeping;

import java.util.concurrent.TimeUnit;

public class Sleeping {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Before sleep");
    TimeUnit.SECONDS.sleep(5);
    System.out.println("After sleep");
  }

}
