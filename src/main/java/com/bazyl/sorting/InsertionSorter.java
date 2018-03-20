package com.bazyl.sorting;

import com.bazyl.util.Sorter;
import java.util.Comparator;

@Sorter
public class InsertionSorter<T> extends AbstractSorter<T> {

  public InsertionSorter(Comparator<T> comparator) {
    super(comparator);
  }

  protected int split(T[] array, int lowerBoundary, int upperBoundary) {
    return upperBoundary;
  }

  protected void join(T[] array, int lowerBoundary, int splitBoundary, int upperBoundary) {
    // Pre: array[lowerBoundary:upperBoundary-1] is sorted.
    // Algo: Inserts array[upperBoundary] in order into array[lowerBoundary:upperBoundary-1].
    // Post: array[lowerBoundary:upperBoundary] is sorted.
    int j;
    T key = array[upperBoundary];

    for (j = upperBoundary; lowerBoundary < j && comparator.compare(key, array[j - 1]) < 0; j--) {
      array[j] = array[j - 1];
    }

    array[j] = key;
  }
}
