package com.bazyl.sorting;

import java.util.Comparator;

public abstract class AbstractSorter<T> {

  protected Comparator<T> comparator;


  protected AbstractSorter(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  public final void sort(T[] array, int lo, int hi){
    if(lo<hi){
      int s = split(array,lo,hi);
      sort(array,lo,hi-1);
      sort(array,s,hi);
      join(array,lo,s,hi);
    }
  }

  protected abstract int split(T[] array, int lo, int hi);

  protected abstract void join(T[] array, int lo, int s, int hi);

  public void setAOrder(Comparator<T> comparator) {
    this.comparator = comparator;
  }

}
