package com.kavi.learnJava;

//This is very good code and documented well for future references
import java.io.File; //it is a class which represents file and directory path names

import java.io.FileInputStream; //this class helps to read a file

import java.io.IOException; //it throws input/output operation is failed or interrupted

import java.util.ArrayList; //he

import java.util.HashMap; //

import java.util.Properties;  //


import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestExcel {

Properties prop = new Properties();

FileInputStream propertyFileStream; /*to read property file u need a class called FileInputStream*/

FileInputStream excelFileStream; /*to read excel file u need a class called FileInputStream*/

public static void main(String[] args) throws IOException {

TestExcel te = new TestExcel();

ArrayList employeePrintList = te.ReadExcel();


for(int m=0; m<employeePrintList.size(); m++)

{

HashMap hm= (HashMap) employeePrintList.get(m);

System.out.println("Name : "+hm.get("NAME"));

System.out.println("EmpId : "+hm.get("EMPID"));

System.out.println("Age : "+hm.get("AGE"));

System.out.println("Alias : "+hm.get("ALIAS"));


}

}

private ArrayList ReadExcel() throws IOException {

ArrayList employeeList= new ArrayList();

// 1.Read the property file to get the Excel File name

propertyFileStream = new FileInputStream("/Users/arunmozhibabu/Documents/workspace/learningSelenium/src/calculate/test.properties");

prop.load(propertyFileStream);

System.out.println("The property value is : "+prop.getProperty("excel_path"));

//2. Read excel spread sheet

excelFileStream = new FileInputStream(new File(prop.getProperty("excel_path")));

XSSFWorkbook excelBook=new XSSFWorkbook(excelFileStream);

XSSFSheet sheet1 = excelBook.getSheet("Sheet1"); /*XSSFSheet sheet=null;

sheet=excelBook.getSheet("Sheet1");*/

//3. Dump into temporary array list tempList

ArrayList tempList = new ArrayList();

for(int i=1; i<=sheet1.getLastRowNum();i++) {

System.out.println("No Of Columns -- > in row "+i+ "--> "+ sheet1.getRow(i).getLastCellNum());

for(int j=0; j<sheet1.getRow(i).getLastCellNum(); j++) {

String value = sheet1.getRow(i).getCell(j).getStringCellValue();

System.out.println("The Value on Cell "+j+ "is --> "+value);

tempList.add(value);

}

//4.Dump into hashmap dataMap == single line of excel sheet

HashMap dataMap = new HashMap();

dataMap.put("EMPID", tempList.get(0));

dataMap.put("NAME", tempList.get(1));

dataMap.put("AGE", tempList.get(2));

dataMap.put("ALIAS", tempList.get(3));

//5.add into arraylist employeeList

employeeList.add(dataMap);

tempList.clear();

}

//6.return arraylist employeeList

return employeeList;

}

}
	
