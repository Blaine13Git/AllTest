package com.windsing.myTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPOI {

	//读取excel文件
	@SuppressWarnings("resource")
	public static void onePOI() throws IOException {
		String fileName = "D:\\123.xls";
		String sheetName = "Sheet1";

		FileInputStream file = new FileInputStream(fileName);
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		XSSFRow rowOne = sheet.getRow(0);
		
		String cellOne = rowOne.getCell(0).toString();
		System.out.println("第一行第一格cellOne:" + cellOne);
	}

	/*
	 * readExcel
	 */

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
		// Create a object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		/*
		 * get Extension name 获取扩展名(用以判断xls or xlsx)
		 */
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		Workbook wb = null;

		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet sheetOne = wb.getSheet(sheetName);

		// Find number of rows in excel file
		int rowCount = sheetOne.getLastRowNum() - sheetOne.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount; i++) {
			Row rowEach = sheetOne.getRow(i);
			for (int j = 0; j < rowEach.getLastCellNum(); j++) {
				Cell cellEach = rowEach.getCell(j);
				System.out.println(cellEach.getStringCellValue() + "||");
			}
		}
	}

	public static void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {

		// Create a object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);
		
		file.delete();
		file.createNewFile();
		
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		/*
		 * get Extension name 获取扩展名(用以判断xls or xlsx)
		 */
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		Workbook wb = null;

		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet sheetOne = wb.getSheet(sheetName);

		// Find number of rows in excel file
		int rowCount = sheetOne.getLastRowNum() - sheetOne.getFirstRowNum();

		// Create a new row and append it at last of sheet
		Row newRow = sheetOne.createRow(rowCount + 1);

		Row row = sheetOne.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			// Fill data in row
			Cell cell = newRow.createCell(i);
			cell.setCellValue(dataToWrite[i]);
		}
		
		inputStream.close();
		
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		
		//write data in the excel file
		wb.write(outputStream);
		outputStream.close();

	}

	public static void main(String[] args) throws IOException {
		
		String filePath ="D:\\";
		String fileName ="in.xls";
		String sheetName ="mem";
		String[] dataToWrite ={"qwe","asd","zxc"}; 
		
		writeExcel(filePath,fileName,sheetName,dataToWrite);
		
		//onePOI();
	}
}
