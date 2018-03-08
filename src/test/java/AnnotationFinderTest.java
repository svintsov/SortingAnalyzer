import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.bazyl.filler.ArrayGenerator;
import com.bazyl.util.AnnotationFinder;
import com.bazyl.util.Filler;
import com.bazyl.util.Sorter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/*
  To pass successfully that test, encounter all entries of chosen annotation
*/
public class AnnotationFinderTest {


  @Test
  public void findAnnotatedMethodsTest() {

    final int FILLER_COUNTER = 4;

    List<Method> methods = AnnotationFinder
        .findAnnotatedMethods(ArrayGenerator.class, Filler.class);

    assertThat(methods.size(), is(FILLER_COUNTER));
  }

  @Test
  public void findAnnotatedTypesTest() {

    final int SORTER_COUNTER = 1;

    Set<Class<?>> types = AnnotationFinder
        .findAnnotatedClasses(Sorter.class);

    assertThat(types.size(), is(SORTER_COUNTER));
  }
}