import com.bazyl.sorting.AbstractSorter;
import com.bazyl.sorting.BubbleSorter;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("ALL")
public class BubbleSortTest {

  private int[] arrayExpected = {5,7,2,1};
  private int[] arrayActual = {5,1,7,2};
  private AbstractSorter<Integer> sorter;

  @Before
  public void before(){
    sorter = new BubbleSorter<>(Comparator.<Integer>naturalOrder());
  }

  @Test
  public void whenArrayPassedThenQuickSortAlgorithm(){
    Arrays.sort(arrayExpected);

    Integer[] actual = Arrays.stream( arrayActual ).boxed().toArray( Integer[]::new );
    Integer[] expected = Arrays.stream( arrayExpected ).boxed().toArray( Integer[]::new );

    sorter.sort(actual,0,arrayActual.length-1);

    Assert.assertArrayEquals(expected,actual);
  }

}
