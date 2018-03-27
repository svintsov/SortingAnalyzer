package com.bazyl.analisys;

import com.bazyl.filler.ArrayGenerator;
import com.bazyl.sorting.AbstractSorter;
import com.bazyl.util.AnnotationFinder;
import com.bazyl.util.Filler;
import com.bazyl.util.Sorter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Main class for collecting and analysing the time of execution of sorting algorithms
 *
 * @author svintsov
 */
public class AnalysisManager {

  private final int ARRAY_LENGTH = 1000;

  private Map<String, Map<String, Integer>> timeBook;


  /**
   * access to the collection of data
   *
   * @return instance of map with fulfilled time data
   * @throws InvocationTargetException
   * @throws NoSuchMethodException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  public Map<String, Map<String, Integer>> getTimeBook()
      throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

    collectDataForTimeBook();

    return timeBook;
  }

  /**
   * outer method that collects and measures time data for sorting algorithms
   *
   * @throws NoSuchMethodException
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  private void collectDataForTimeBook()
      throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

    final Set<Class<?>> types = AnnotationFinder
        .findAnnotatedClasses(Sorter.class);

    final List<Method> methods = AnnotationFinder
        .findAnnotatedMethods(ArrayGenerator.class, Filler.class);

    timeBook = new LinkedHashMap<>();

    for (Class<?> type : types) {

      timeBook.put(type.getSimpleName(), new LinkedHashMap<>());
      runThroughFillerMethods(type, methods);

    }
  }

  /**
   * inner method that collects and measures time data for sorting algorithms.
   * @param type      specific Class with Sorter annotation
   * @param methods   list of methods with Filler annotation
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   * @throws NoSuchMethodException
   * @throws InstantiationException
   */
  private void runThroughFillerMethods(Class<?> type, List<Method> methods)
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

    //new instance of sorter class
    Constructor constructor = type.getConstructor(Comparator.class);
    AbstractSorter<Integer> sorter = (AbstractSorter<Integer>) constructor
        .newInstance(Comparator.<Integer>naturalOrder());

    for (Method method : methods) {

      //generation of array
      Object object = method.invoke(null, ARRAY_LENGTH);
      int[] array = (int[]) object;

      //cast primitive array for Integer array for support on sorting method.
      Integer[] actual = Arrays.stream(array).boxed().toArray(Integer[]::new);

      long currentTime = System.currentTimeMillis();
      //invokation of sorting algorithm
      sorter.sort(actual, 0, actual.length - 1);

      long estimatedTime = System.currentTimeMillis() - currentTime;

      timeBook.get(type.getSimpleName()).put(method.getName().replaceFirst("generate",""),
          Math.toIntExact(estimatedTime));
    }
  }
}
