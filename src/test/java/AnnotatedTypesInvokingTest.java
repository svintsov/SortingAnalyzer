import com.bazyl.sorting.AbstractSorter;
import com.bazyl.util.AnnotationFinder;
import com.bazyl.util.Sorter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnnotatedTypesInvokingTest {

  Set<Class<?>> types;
  int[] arrayExpected = {2,1,3};
  int[] arrayActual = {2,1,3};

  @Before
  public void before(){
    types = AnnotationFinder
        .findAnnotatedClasses(Sorter.class);
  }

  @Test
  public void tryToInvokeParameterizedType()
      throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    for(Class<?> type : types){

      Constructor constructor = type.getConstructor(Comparator.class);
      AbstractSorter<Integer> sorter = (AbstractSorter<Integer>) constructor.newInstance(Comparator.<Integer>naturalOrder());

      Arrays.sort(arrayExpected);

      Integer[] actual = Arrays.stream( arrayActual ).boxed().toArray( Integer[]::new );
      Integer[] expected = Arrays.stream( arrayExpected ).boxed().toArray( Integer[]::new );

      sorter.sort(actual,0,arrayActual.length-1);

      Assert.assertArrayEquals(expected,actual);

    }
  }

}
