package com.bazyl;

import com.bazyl.analisys.AnalysisManager;
import com.bazyl.view.XLSDisplayer;
import java.lang.reflect.InvocationTargetException;

public class Main {

  public static void main(String[] args) {

    AnalysisManager manager = new AnalysisManager();
    XLSDisplayer displayer = new XLSDisplayer();

    try {
      displayer.display(manager.getTimeBook());
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }

  }
}
