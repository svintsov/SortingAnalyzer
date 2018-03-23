package com.bazyl.sorting;

import java.util.Comparator;

public class BubbleSorter<T> extends AbstractSorter<T> {

  public BubbleSorter(Comparator<T> comparator) {
    super(comparator);
  }

  @Override
  protected int split(final T[] array, final int lowerBoundary, final int upperBoundary) {

    T temp;

    for (int i = 0; i < upperBoundary; i++) {

        if (comparator.compare(array[i], array[i+1]) >= 1) {

          //swap elements
          temp = array[i];
          array[i] = array[i+1];
          array[i+1] = temp;
      }
    }

    return upperBoundary;
  }

  @Override
  protected void join(final T[] array, final int lowerBoundary, final int splitBoundary,
      final int upperBoundary) {

  }
}
