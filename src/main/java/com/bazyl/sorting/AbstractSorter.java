package com.bazyl.sorting;

import java.util.Comparator;

/**
 * Parent class for all implementations of sorting algorithms.
 * Defines template methods for algorithms.
 *
 * @param <T>
 */
public abstract class AbstractSorter<T> {

  protected Comparator<T> comparator;


  protected AbstractSorter(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  protected AbstractSorter() {
  }

  /**
   * Recursive method consists of 3 main phases(split,sort,join)
   *
   * @param array
   * @param lowerBoundary
   * @param upperBoundary
   */
  public final void sort(T[] array, int lowerBoundary, int upperBoundary) {
    if (lowerBoundary < upperBoundary) {

      int s = split(array, lowerBoundary, upperBoundary);

      sort(array, lowerBoundary, upperBoundary - 1);
      sort(array, s, upperBoundary);

      join(array, lowerBoundary, s, upperBoundary);

    }
  }

  /**
   * splits an array into two parts. may be omitted in implementation
   *
   * @param array
   * @param lowerBoundary
   * @param upperBoundary
   * @return
   */
  protected abstract int split(T[] array, int lowerBoundary, int upperBoundary);


  /**
   * joins an array into two parts. may be omitted in implementation
   *
   * @param array
   * @param lowerBoundary
   * @param splitBoundary
   * @param upperBoundary
   */
  protected abstract void join(T[] array, int lowerBoundary, int splitBoundary, int upperBoundary);

  /**
   * setter method for comparator
   *
   * @param comparator
   */
  public void setAOrder(Comparator<T> comparator) {
    this.comparator = comparator;
  }

}
