import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

import com.bazyl.filler.ArrayGenerator;
import org.junit.Assert;
import org.junit.Test;

public class ArrayGenerationTest {


  /*
  Generation method just iterate through loop. [0..n)
   */
  @Test
  public void testSortedArrayCreation(){
    int[] expected = {0,1,2,3,4};

    int[] actual = ArrayGenerator.generateSortedArray(expected.length);

    Assert.assertArrayEquals(expected,actual);
  }

  @Test
  public void testReverseSortedArrayCreation(){
    int[] expected = {4,3,2,1,0};

    int[] actual = ArrayGenerator.generateReverseSortedArray(expected.length);

    Assert.assertArrayEquals(expected,actual);
  }

  @Test
  public void testRandomGeneratedArrayCreation(){
    int[] expected = ArrayGenerator.generateRandomFilledArray(5);

    int[] actual = ArrayGenerator.generateRandomFilledArray(5);

    assertThat(actual, not(equalTo(expected)));
  }

  @Test
  public void testLastRandomFilledArrayCreation(){
    int[] expected = {0,1,2,3,4};

    int[] actual = ArrayGenerator.generateLastRandomFilledArray(5);

    assertThat(actual, not(equalTo(expected)));
  }

}
