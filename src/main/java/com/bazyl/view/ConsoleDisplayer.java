package com.bazyl.view;

public class ConsoleDisplayer implements Displayable<Integer> {

  @Override
  public void display(final Integer[] array, String algorithm) {
    System.out.println(algorithm);

    for (int element : array) {
      System.out.print(" " + element);
    }
  }
}
