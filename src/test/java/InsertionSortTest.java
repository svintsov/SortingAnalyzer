
import com.bazyl.sorting.AbstractSorter;
import com.bazyl.sorting.InsertionSorter;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {

  private AbstractSorter<Integer> sorter;
  private int[] arrayExpected = {5,7,2,1};
  private int[] arrayActual = {5,2,7,1};

  @Before
  public void before(){
    sorter = new InsertionSorter<>(Comparator.<Integer>naturalOrder());
  }

  @Test
  public void whenArrayPassedThenInsertionSortAlgorithm(){
    Arrays.sort(arrayExpected);

    Integer[] actual = Arrays.stream( arrayActual ).boxed().toArray( Integer[]::new );
    Integer[] expected = Arrays.stream( arrayExpected ).boxed().toArray( Integer[]::new );

    sorter.sort(actual,0,arrayActual.length-1);

    Assert.assertArrayEquals(expected,actual);
  }

}
