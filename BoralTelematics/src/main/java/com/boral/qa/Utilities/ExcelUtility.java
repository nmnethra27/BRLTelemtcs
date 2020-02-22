package com.boral.qa.Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String path;
	public String cellvalue;
	
public String getexcelvalue(String sheetname,int rownum,int column) {
		
		sheet=workbook.getSheet(sheetname);
		cell = sheet.getRow(rownum).getCell(column);
		String cellvalue = String.valueOf(cell);
		return cellvalue;
	}
	

}
