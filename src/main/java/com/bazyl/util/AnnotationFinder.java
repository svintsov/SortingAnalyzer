package com.bazyl.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;

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

  public static Set<Class<?>> findAnnotatedClasses(Class<? extends Annotation> annotationClass){
    Reflections reflections = new Reflections("com.bazyl");

    return reflections.getTypesAnnotatedWith(annotationClass);
  }
}
