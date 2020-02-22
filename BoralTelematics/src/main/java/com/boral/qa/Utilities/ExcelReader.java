package com.boral.qa.Utilities;

import com.boral.qa.base.TestBase;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String path;
	public String cellvalue;
	
	public void Readexcelfile(String path) throws IOException {
		this.path=path;
		workbook=new XSSFWorkbook(path); //Constructs a XSSFWorkbook object given a file name.
	}
	
	public int getRowCount(String sheetname) {
		sheet=workbook.getSheet(sheetname);
		int rowcount =sheet.getLastRowNum();
		return rowcount +1;
	}
	
	public Object[][] getcellvalue(String sheetname) {
		sheet=workbook.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		for (int i = 0; i <sheet.getLastRowNum(); i++) {
			for (int k = 0; k <sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public String getexcelvalue(String sheetname,int rownum,int column) {
		
		sheet=workbook.getSheet(sheetname);
		cell = sheet.getRow(rownum).getCell(column);
		String cellvalue = String.valueOf(cell);
		return cellvalue;
	}
 

}
