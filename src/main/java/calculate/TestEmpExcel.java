package calculate;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Objective: 
 * Read an Excel file which has details of all employees
 * 
 * Note: Please make the location of excel file configurable using properties file
 * 		  and add logic to handle multiple sheets
 *  
 * Steps:
 * 	1) Load properties file
 * 	2) Open and Read the excel using POI API
 * 	3) Loop to read each row from the excel
 * 	4) Loop to read each cell from previous step and populate an array list
 * 	5) Populate an array list by adding cell array from previous step
 * 	6) Close IO resources
 * 	7) Read user input for row. column and print the values
 */
public class TestEmpExcel {

	public static void main(String[] args) throws Exception 
	{
	  TestEmpExcel empExcel = new TestEmpExcel();
		
	  Properties properties = empExcel.loadProperties("C:/Users/daddyiscrybaby/Downloads/test.properties");
	  String excelFile = properties.getProperty("excel_path");
	  //String sheetNames = properties.getProperty("sheet_names");
	  
		  
	  ArrayList sheetContent = empExcel.readExcel(excelFile);
	  empExcel.display(sheetContent);
		
	  //display given row and column value. example: Row: 3 Column: 2
	  int row = 3, column = 2;
	  ArrayList columnList = (ArrayList)sheetContent.get(row-1);
	  String value = (String)columnList.get(column-1);
	  System.out.println(value);
	  
	  //
	}
	
	private Properties loadProperties(String propertiesFile) throws Exception
	{
	  FileInputStream fileInputStream = new FileInputStream(propertiesFile);	
	  Properties properties = new Properties();
	  properties.load(fileInputStream);
	  
	  fileInputStream.close();
	  
	  return properties;
	}
	
	
	private ArrayList readExcel(String excelFile)
	{
	  ArrayList rowArray = null;
	  
	  try{
	  FileInputStream fileInputStream = new FileInputStream(excelFile);
	  XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
	  XSSFSheet sheet = workbook.getSheet("Sheet1");
	  
	  rowArray = new ArrayList(); //holds row values	 
	  for(int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)	  //row index start with 1 to skip header
	  {
		Row row = sheet.getRow(rowIndex);
		ArrayList columnArray = new ArrayList(); //holds column vaues
		for(int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++)
		{
			Cell cell = row.getCell(columnIndex);
			columnArray.add(cell.getStringCellValue());
		}
		
		rowArray.add(columnArray);
	  }
	  
	  workbook.close();
	  fileInputStream.close();
	  } catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  return rowArray;
	}
	
	
	private void display(ArrayList sheetContent)
	{
		  //Header - Name	EmpId	Age	Alias
		  System.out.println("Name\tEmpId\tAge\tAlias");	  
		  for(int rowIndex = 0; rowIndex < sheetContent.size(); rowIndex++)
		  {
			ArrayList list = (ArrayList)sheetContent.get(rowIndex);
			for(int columnndex = 0; columnndex < list.size(); columnndex++)
			{
				System.out.print(list.get(columnndex) + "\t");
			}
			System.out.println();
		  }
		
	}

	
	private HashMap readExcel(String excelFile, String sheetNamesCSV)
	{
	  HashMap hashMap = null;
	  
	  try{
	  FileInputStream fileInputStream = new FileInputStream(excelFile);
	  XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
	  XSSFSheet sheet = workbook.getSheet("Sheet1");
	  
	  hashMap = new HashMap(); //Holds each sheet
	  ArrayList rowArray = new ArrayList(); //holds row values	 
	  for(int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)	  //row index start with 1 to skip header
	  {
		Row row = sheet.getRow(rowIndex);
		ArrayList columnArray = new ArrayList(); //holds column vaues
		for(int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++)
		{
			Cell cell = row.getCell(columnIndex);
			columnArray.add(cell.getStringCellValue());
		}
		
		rowArray.add(columnArray);
	  }
	  
	  hashMap.put("Sheet1", rowArray);
	  
	  workbook.close();
	  fileInputStream.close();
	  } catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  
	  return hashMap;
	}
	
}
