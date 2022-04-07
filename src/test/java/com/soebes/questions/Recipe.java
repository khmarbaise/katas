package com.soebes.questions;

public class Recipe {

  public void cook() throws BadRecipeExceptions {
    var ingredients = new int[0];
    System.out.println(ingredients[0]);
  }

  public static void main(String[] args) {
    try {
      new Recipe().cook();
    } catch (Throwable e) {
      System.out.print("Caught!");
    }
  }

}
