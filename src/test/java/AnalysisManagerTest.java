import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import com.bazyl.analisys.AnalysisManager;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class AnalysisManagerTest {

  AnalysisManager manager = new AnalysisManager();
  final int SORTER_CLASS_COUNTER = 3;
  final int FILLER_CLASS_COUNTER = 4;

  @Test
  public void whenGetTimeBookInvokedMapIsNotNull()
      throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

    Map<String, Map<String,Integer>> book = manager.getTimeBook();

    Assert.assertNotNull(book);
  }

  @Test
  public void whenGetTimeBookInvokedMapContainsAllKeysAsSorterClassNames()
      throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

    Map<String, Map<String,Integer>> book = manager.getTimeBook();

    assertThat(book.size(),is(SORTER_CLASS_COUNTER));
  }

  @Test
  public void whenGetTimeBookInvokedMapContainsAllKeysAsFillerClassNames()
      throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

    Map<String, Map<String,Integer>> book = manager.getTimeBook();

    assertThat(book.get("QuickSorter").size(),is(FILLER_CLASS_COUNTER));
  }

  @Test
  public void whenGetTimeBookInvokedMapContainsTimeWhichIsNotNull()
      throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

    Map<String, Map<String,Integer>> book = manager.getTimeBook();

    assertNotEquals(0,
        java.util.Optional.ofNullable(book.get("QuickSorter").get("generateRandomFilledArray")));
  }

}
