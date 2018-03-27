package com.bazyl.view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSDisplayer implements Displayable {

  private static final String FILE_NAME = "data.xls";

  private final XSSFWorkbook workbook = new XSSFWorkbook();
  private final XSSFSheet sheet = workbook.createSheet("Sorting Data");

  private final List<Row> rowList = new ArrayList<>();

  @Override
  public void display(final Map<String, Map<String, Integer>> book) {

    writeHeaderRow(book);
    writeFirstColumn(book);
    writeData(book);

    saveToFile();
  }

  private void writeHeaderRow(final Map<String, Map<String, Integer>> book) {
    int rowNum = 0;
    int colNum = 1;

    Row row = sheet.createRow(rowNum);
    rowList.add(row);

    for (String header : book.keySet()) {

      Cell cell = row.createCell(colNum++);
      cell.setCellValue(header);

    }

  }

  private void writeFirstColumn(final Map<String, Map<String, Integer>> book) {
    int rowNum = 1;

    for (String header : book.keySet()) {

      for (String rowHeader : book.get(header).keySet()) {

        Row row = sheet.createRow(rowNum++);
        rowList.add(row);

        Cell cell = row.createCell(0);
        cell.setCellValue(rowHeader);

      }

      break;
    }

  }

  private void writeData(final Map<String, Map<String, Integer>> book) {
    int rowNum;
    int colNum = 1;

    for (Map.Entry<String, Map<String, Integer>> outerEntry : book.entrySet()) {

      rowNum = 1;

      for (Map.Entry<String, Integer> innerEntry : outerEntry.getValue().entrySet()) {

        Row row = rowList.get(rowNum++);
        Cell cell = row.createCell(colNum);
        cell.setCellValue(innerEntry.getValue());

      }

      colNum++;

    }
  }


  private void saveToFile() {
    try {

      FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
      workbook.write(outputStream);
      workbook.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
