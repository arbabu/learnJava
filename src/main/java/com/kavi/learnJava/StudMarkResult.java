package com.kavi.learnJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class StudMarkResult
{
	public static void main(String[] args) throws Exception {
		
		FileOutputStream outStream = new FileOutputStream("C:/Users/daddyiscrybaby/Downloads/studmarkresult1.xlsx");
		XSSFWorkbook outbook = new XSSFWorkbook();		
		XSSFSheet outsheet = outbook.createSheet("Sheet1");

		FileInputStream excelStream= new FileInputStream("C:/Users/daddyiscrybaby/Downloads/studmarkresult.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(excelStream);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int lastrownum = sheet.getLastRowNum();
		System.out.println("last rownumber=" + lastrownum);
		//Reading the value from the excel sheet
		String result = null;
		String subject = null;
		for (int i=1; i<=lastrownum; i++)
		{
			Row roww = sheet.getRow(i);
			Row outrow = outsheet.createRow(i);
			for (int j=0; j<roww.getLastCellNum(); j++){
				Cell cellv = roww.getCell(j);
				Cell outCell = outrow.createCell(j);
				System.out.print(cellv.getStringCellValue()+ "  ");
				
				String strval = cellv.getStringCellValue();//Java offers an object(thats y starts with caps)String which captures the string value
				if (j>0 && j< roww.getLastCellNum()-1){
					//System.out.println("the value of J:" +j +",lastcell=" + roww.getLastCellNum());
					 
					int intval = Integer.parseInt(strval); //parses to give/convert the string to integer value
					
					if (intval<35.0)  {
						//System.out.println("Mark is less than 35 for subject" + sheet.getRow(0).getCell(0).getStringCellValue());
						subject= sheet.getRow(0).getCell(j).getStringCellValue();
						result = "Fail";
					}else {
						subject = "";
						result = "Pass";
					}					
										
				}
				
				if(j == roww.getLastCellNum()-1){
					outCell.setCellValue(result);
				} else {
				outCell.setCellValue(cellv.getStringCellValue());
				}
				
			}
			
			
			System.out.println(subject + " - " + result); //to give a newline after every row
		}
		
		outbook.write(outStream);
		
	}
	
		
}