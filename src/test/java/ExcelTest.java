import com.bazyl.analisys.AnalysisManager;
import com.bazyl.view.XLSDisplayer;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

public class ExcelTest {

  AnalysisManager manager = new AnalysisManager();
  XLSDisplayer displayer = new XLSDisplayer();

  @Test
  public void testHeaderWriting()
      throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

    displayer.display(manager.getTimeBook());
  }

}
