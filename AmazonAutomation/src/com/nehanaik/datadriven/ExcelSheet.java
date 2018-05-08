package com.nehanaik.datadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {

	private static XSSFWorkbook ExcelWorkBook = null;
	private static XSSFSheet ExcelWorkSheet = null;
	
	public static void setExcelFile(String path, String sheetName) throws Exception{

		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWorkBook = new XSSFWorkbook(ExcelFile);
			ExcelWorkSheet = ExcelWorkBook.getSheet(sheetName);
			System.out.println(ExcelWorkSheet);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] getTestData(String tableName){
		String[][] testData = null;
		
		try {
			DataFormatter formatter = new DataFormatter();

			XSSFCell[] boundryCells = findCells(tableName);
			XSSFCell startCell = boundryCells[0];
			
			XSSFCell endCell = boundryCells[1];
			
			int startRow = startCell.getRowIndex() + 1;
			int endRow = endCell.getRowIndex() - 1;
			int startColumn = startCell.getColumnIndex() + 1;
			int endColumn = endCell.getColumnIndex() - 1;
			
			testData = new String[endRow - startRow +1][endColumn - startColumn + 1];
			
			for(int i = startRow; i<endRow+1; i++) {
				for(int j = startColumn; j<endColumn+1;j++) {
					//System.out.println(testData[i][j]);
					Cell cell = ExcelWorkSheet.getRow(i).getCell(j);
					testData[i-startRow][j-startColumn] = formatter.formatCellValue(cell);
					
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return testData;
	}
	
	
	public static XSSFCell[] findCells(String tableName) {
		DataFormatter formatter = new DataFormatter();
		String pos = "begin";
		XSSFCell[] cells = new XSSFCell[2];
		
		for(Row row : ExcelWorkSheet) {
			for(Cell cell : row) {
				//if(tableName.equals(cell.getStringCellValue())) {
				if(tableName.equals(formatter.formatCellValue(cell))) {
					if(pos.equalsIgnoreCase("begin")) {
						cells[0] = (XSSFCell) cell;
						pos = "end";
						
					}
					else {
						cells[1] = (XSSFCell) cell;
						
					}
				}
			}
		}
		return cells;
		
	}
	
}
