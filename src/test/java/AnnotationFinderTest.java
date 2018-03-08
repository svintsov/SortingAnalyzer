package com.bazyl.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.bazyl.filler.ArrayGenerator;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.Test;

public class AnnotationFinderTest {


  /*
  To pass successfully that test, encounter all entries of chosen annotation
   */
  @Test
  public void findAnnotatedMethodsTest() {

    final int FILLER_COUNTER = 4;

    List<Method> methods = AnnotationFinder
        .findAnnotatedMethods(ArrayGenerator.class, Filler.class);

    assertThat(methods.size(), is(FILLER_COUNTER));
  }
}