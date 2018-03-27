import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.bazyl.filler.ArrayGenerator;
import com.bazyl.util.AnnotationFinder;
import com.bazyl.util.Filler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class InvocationFillerMethodTest {

  private final int ARRAY_LENGTH = 5;

  @Test
  public void whenFillerMethodInvokedThenReturnedArray() throws InvocationTargetException,IllegalAccessException{
    List<Method> methods = AnnotationFinder.findAnnotatedMethods(ArrayGenerator.class, Filler.class);
    Object object = methods.get(0).invoke(null,ARRAY_LENGTH);
    Assert.assertNotNull(object);
  }

  @Test
  public void whenFillerMethodInvokedThenReturnedArrayWithSpecificLength() throws InvocationTargetException,IllegalAccessException{
    List<Method> methods = AnnotationFinder.findAnnotatedMethods(ArrayGenerator.class, Filler.class);
    Object object = methods.get(0).invoke(null,ARRAY_LENGTH);
    int[] array = (int[])object;
    assertThat(array.length,is(ARRAY_LENGTH));
  }

}
