package com.soebes.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BubbleSortTest {

  @Test
  void first() {
    int[] datenDieSortiertWerdenSollen = {1, 5, 7, 12, 3, 6};
    BubbleSort bs = new BubbleSort(datenDieSortiertWerdenSollen);
    int[] resultat = bs.sortiere();

    assertThat(resultat).containsExactly(1, 3, 5, 6, 7, 12);
  }

  @Test
  void second() {
    int[] datenDieSortiertWerdenSollen = {1};
    BubbleSort bs = new BubbleSort(datenDieSortiertWerdenSollen);
    int[] resultat = bs.sortiere();

    assertThat(resultat).containsExactly(1);
  }

  public class BubbleSort {
    private int[] daten;

    public BubbleSort(int[] daten) {
      this.daten = Arrays.copyOf(daten, daten.length);
    }

    public int[] sortiere() {
      for (int n = daten.length; n > 1; n--) {
        for (int i = 0; i < n - 1; i++) {
          if (daten[i] > daten[i + 1]) {
            swap(i, i + 1);
          }
        }
      }
      return Arrays.copyOf(daten, daten.length);
    }

    private void swap(int first, int second) {
      int tmp = daten[first];
      daten[first] = daten[second];
      daten[second] = tmp;
    }
  }
}
