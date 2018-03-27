package com.bazyl.sorting;

import com.bazyl.util.Sorter;
import java.util.Comparator;

/**
 * Implementation of Insertion sorting algorithm.
 * @see <a href = "https://en.wikipedia.org/wiki/QuickSort">link</a>
 * @author svintsov
 *
 * @param <T>
 */
@Sorter
public class QuickSorter<T> extends AbstractSorter<T> {

  public QuickSorter(final Comparator<T> comparator) {
    super(comparator);
  }

  @Override
  protected int split(final T[] array, final int lowerBoundary, final int upperBoundary) {
    // pivot (Element to be placed at right position)
    T pivot = array[upperBoundary];

    int i = lowerBoundary - 1;  // Index of smaller element

    for (int j = lowerBoundary; j < upperBoundary; j++) {
      // If current element is smaller than or
      // equal to pivot
      if (comparator.compare(array[j], pivot) <= 0) {
        i++;    // increment index of smaller element
        swap(array, i, j);
      }
    }
    swap(array, i + 1, upperBoundary);
    return i + 1;
  }

  @Override
  protected void join(final T[] array, final int lowerBoundary, final int splitBoundary,
      final int upperBoundary) {

  }

  private void swap(final T[] array, int i, int j) {
    T temporal = array[i];
    array[i] = array[j];
    array[j] = temporal;
  }
}
