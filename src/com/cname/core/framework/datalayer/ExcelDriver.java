package com.cname.core.framework.datalayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cname.core.framework.utility.Constants;


public class ExcelDriver
{
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	
	public ExcelDriver()
	{
		try
		{
			//fis = new FileInputStream(Property.getProData("testDataPath"));
			fis = new FileInputStream(Constants.testDataPath);
			workbook = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * getData(): method will fetch the data from excel sheet
	 * @param sheetName: Sheet Name for the Excel from where we need to extract the data
	 * @param rowNum: Row no of test Data
	 * @param colNum: Coloumn numner of test data
	 * @return: it will return Data of given row and Col number
	 * @exception: FileNotFoundException
	 * @exception: IOException
	 */
	
	public String getData(String sheetName, int rowNum, int colNum)
	{
		String data=null;
		try
		{
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(colNum);
			CellType cellType = cell.getCellType();
			
			switch(cellType)
			{
				case STRING:
					data = cell.getStringCellValue();
					break;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * setData(): this method will set back the data to excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 */
	
	public void setData(String sheetName, int rowNum, int colNum, String data)
	{
		try
		{
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.createCell(colNum);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(Constants.testDataPath);
			workbook.write(fos);
			fos.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * getRowCount(): get total number of row in the excel sheet
	 * @param sheetName
	 * @return
	 */
	
	public int getRowCount(String sheetName)
	{
		int rowCount=0;
		try
		{
			Sheet sheet = workbook.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
	
	/**
	 *  getColCount(): get total number of coloumn in the excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */
	public int getColCount(String sheetName, int rowNum)
	{
		int colCount=0;
		try
		{
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			colCount = row.getLastCellNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return colCount;
	}
	
	/**
	 * getAllColData(): to fetch all column data
	 * @param sheetName
	 * @param colNum
	 * @return
	 */
	
	public List<String> getAllColData(String sheetName, int colNum)
	{
		List<String> lst = new ArrayList<String>();
		try
		{
			int rowCount = getRowCount(sheetName);
			for(int i=0; i<=rowCount-1; i++)
			{
				String value = getData(sheetName, i, colNum);
				lst.add(value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	
	/**
	 * getAllRowData(): to fetch all row data
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */
	
	public List<String> getAllRowData(String sheetName, int rowNum)
	{
		List<String> lst = new ArrayList<String>();
		try
		{
			int colCount = getColCount(sheetName, rowNum);
			for(int i=0; i<=colCount-1; i++)
			{
				String value = getData(sheetName, rowNum, i);
				lst.add(value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	
}
