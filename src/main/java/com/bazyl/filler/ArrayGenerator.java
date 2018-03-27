package com.bazyl.filler;

import com.bazyl.util.Filler;
import java.util.Random;

/**
 * Utility class for generating arrays of integer
 * @author svintsov
 *
 */
public class ArrayGenerator {

  private ArrayGenerator() {
  }


  /**
   * generate fully sorted array
   *
   * @param length length of array
   * @return array of integer
   */
  @Filler
  public static int[] generateSortedArray(final int length) {
    int[] array = new int[length];

    for (int i = 0; i < length; i++) {
      array[i] = i;
    }

    return array;
  }

  /**
   * genearate array in descending order
   *
   * @param length length of array
   * @return array of integer
   */
  @Filler
  public static int[] generateReverseSortedArray(final int length) {
    int[] array = new int[length];

    for (int i = length - 1, j=0; i >= 0; i--,j++) {
      array[j] = i;
    }

    return array;
  }

  /**
   * genearate array with random int values
   *
   * @param length length of array
   * @return array of integer
   */
  @Filler
  public static int[] generateRandomFilledArray(final int length) {
    int[] array = new int[length];
    Random random = new Random();

    for (int i = 0; i < length; i++) {
      array[i] = random.nextInt();
    }

    return array;
  }

  /**
   * generate sorted array except last index which is random value
   *
   * @param length length of array
   * @return array of integer
   */
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
