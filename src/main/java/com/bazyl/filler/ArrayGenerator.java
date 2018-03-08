package com.bazyl.filler;

import com.bazyl.util.Filler;
import java.util.Random;

public class ArrayGenerator {

  private ArrayGenerator() {
  }

  @Filler
  public static int[] generateSortedArray(final int length) {
    int[] array = new int[length];

    for (int i = 0; i < length; i++) {
      array[i] = i;
    }

    return array;
  }

  @Filler
  public static int[] generateReverseSortedArray(final int length) {
    int[] array = new int[length];

    for (int i = length - 1, j=0; i >= 0; i--,j++) {
      array[j] = i;
    }

    return array;
  }

  @Filler
  public static int[] generateRandomFilledArray(final int length) {
    int[] array = new int[length];
    Random random = new Random();

    for (int i = 0; i < length; i++) {
      array[i] = random.nextInt();
    }

    return array;
  }

  @Filler
  public static int[] generateLastRandomFilledArray(final int length) {
    int[] array = new int[length];
    Random random = new Random();

    for (int i = 0; i < length - 1; i++) {
      array[i] = i;
    }

    array[length - 1] = random.nextInt();

    return array;
  }

}
