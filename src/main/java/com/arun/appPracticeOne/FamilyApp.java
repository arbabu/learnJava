package com.arun.appPracticeOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
/* 
 * 
 * 
 * 1.Read property file and get excel path
 * 2. Read excel spread sheet
 * 3. Dump into temporary array list famList
 * 4.Dump into hashmap dataMap == single line of excel sheet
 * 5.add into arraylist employeeList
 * 6.return arraylist employeeList
 */

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FamilyApp {

	Properties multiProp = new Properties();
	FileInputStream multiPropFileStream;
	FileInputStream applicantsExcelFileStream;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FamilyApp fa = new FamilyApp();
		ArrayList masterFamilyList = fa.ReadApplicants();
		//6.return arraylist masterFamilyList
		for (int m=0;m<masterFamilyList.size();m++){
			HashMap hm= (HashMap) masterFamilyList.get(m);
			System.out.println("Family name is "+hm.get("Family Name"));
			System.out.println("Father name is "+hm.get("Father Name"));
			System.out.println("Mother name is "+hm.get("Mother Name"));
			System.out.println("First child name is "+hm.get("First Child Name"));
			System.out.println("Second child name is "+hm.get("Second child name"));	
		}
		
	}
	
	private ArrayList ReadApplicants() throws IOException {
		ArrayList masterFamilyList = new ArrayList();
		
		//1.Read property file and get excel path
		multiPropFileStream = new FileInputStream("/Users/arunmozhibabu/Desktop/ArunJob/githubProjects/learnJava/src/main/java/calculate/test.properties");
		
		multiProp.load(multiPropFileStream);
		System.out.println("The property value is : "+multiProp.getProperty("app_path"));
		
		//2. Read excel spread sheet
		applicantsExcelFileStream = new FileInputStream(new File(multiProp.getProperty("app_path")));
		XSSFWorkbook excelBook=new XSSFWorkbook(applicantsExcelFileStream);
		XSSFSheet Family = excelBook.getSheet("Family");
		//3. Dump into temporary array list famList
		ArrayList famList = new ArrayList();
		for(int i=1;i<=Family.getLastRowNum();i++) {
			System.out.println("No of columns in row of "+i+" is "+Family.getRow(i).getLastCellNum());
			for(int j=0;j<Family.getRow(i).getLastCellNum();j++) {
				String value = Family.getRow(i).getCell(j).getStringCellValue();
				System.out.println("The value on cell "+j+" is "+value);
				famList.add(value);			
			}
			//4.Dump into hashmap dataMap == single line of excel sheet
			HashMap dataMap = new HashMap();
			
			dataMap.put("Family Name", famList.get(0));
			dataMap.put("Father Name", famList.get(1));
			dataMap.put("Mother Name", famList.get(2));
			dataMap.put("First Child Name", famList.get(3));
			dataMap.put("Second child name", famList.get(4));
			
			//5.add into arraylist masterFamilyList
			masterFamilyList.add(dataMap);
			
		    famList.clear();	
		}
		

		return masterFamilyList; 
		
	}
	

}
