package com.soebes.fraction;

import java.math.BigInteger;

public class MathUtil {

  private MathUtil() {
    // Absichtlich keine Instanz bildbar.
  }

  /**
   * @param zaehler Zaehler
   * @param nenner Nenner
   * @return kleinstes gemeinsames Vielfache.
   */
  public static int berechne_kgv(int zaehler, int nenner) {
    return BigInteger.valueOf(zaehler).gcd(BigInteger.valueOf(nenner)).intValueExact();
  }
}
