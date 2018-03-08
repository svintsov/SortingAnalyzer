package com.bazyl.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationFinder {

  private AnnotationFinder(){}


  public static List<Method> findAnnotatedMethods(Class<?> baseClass, Class<? extends Annotation> annotationClass) {
    Method[] methods = baseClass.getMethods();
    List<Method> annotatedMethods = new ArrayList<>(methods.length);
    for (Method method : methods) {
      if( method.isAnnotationPresent(annotationClass)){
        annotatedMethods.add(method);
      }
    }
    return annotatedMethods;
  }
}
