package com.bazyl.sorting;

import java.util.Comparator;

public abstract class AbstractSorter<T> {

  protected Comparator<T> comparator;


  protected AbstractSorter(Comparator<T> comparator) {
    this.comparator = comparator;
  }
  protected AbstractSorter(){}

  public final void sort(T[] array, int lowerBoundary, int upperBoundary){
    if(lowerBoundary<upperBoundary){
      int s = split(array,lowerBoundary,upperBoundary);
      sort(array,lowerBoundary,upperBoundary-1);
      sort(array,s,upperBoundary);
      join(array,lowerBoundary,s,upperBoundary);
    }
  }

  protected abstract int split(T[] array, int lowerBoundary, int upperBoundary);

  protected abstract void join(T[] array, int lowerBoundary, int splitBoundary, int upperBoundary);

  public void setAOrder(Comparator<T> comparator) {
    this.comparator = comparator;
  }

}
