package com.initbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook workbook;
    private static Sheet sheet;
    private static Row row;
    private static Cell cell;

    // Method to get the row count
    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
    }

    // Method to get the cell count
    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    // Method to read the cell data
    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        
        String data;
        try {
            if (cell.getCellType() == CellType.STRING) {
                data = cell.getStringCellValue();
            } else if (cell.getCellType() == CellType.NUMERIC) {
                data = String.valueOf((int) cell.getNumericCellValue());
            } else {
                data = "";
            }
        } catch (Exception e) {
            data = "";
        }
        workbook.close();
        fis.close();
        return data;
    }

    // Method to set cell data
    public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        cell = row.createCell(colNum);
        cell.setCellValue(data);

        fos = new FileOutputStream(xlFile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }

    // Method to check if cell is numeric
    public static boolean isNumericCell(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        boolean isNumeric = false;
        if (cell.getCellType() == CellType.NUMERIC) {
            isNumeric = true;
        }
        workbook.close();
        fis.close();
        return isNumeric;
    }
}
