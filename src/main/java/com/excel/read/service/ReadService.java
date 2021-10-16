package com.excel.read.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

@Service
public class ReadService {

  @Value("${excel.read.path}")
  private Resource file;

  public void readExcel() {

    try {
      FileInputStream excelFile = new FileInputStream(file.getFile());
      Workbook workbook = new XSSFWorkbook(excelFile);
      Sheet datatypeSheet = workbook.getSheetAt(1);
      Iterator<Row> iterator = datatypeSheet.iterator();

      while (iterator.hasNext()) {

        Row currentRow = iterator.next();
        Iterator<Cell> cellIterator = currentRow.iterator();

        while (cellIterator.hasNext()) {

          Cell currentCell = cellIterator.next();
          if (currentCell.getCellType() == CellType.STRING) {
            System.out.print(currentCell.getStringCellValue() + " || ");
          } else if (currentCell.getCellType() == CellType.NUMERIC) {
            System.out.print(currentCell.getNumericCellValue() + " || ");
          }
        }
        System.out.println();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
