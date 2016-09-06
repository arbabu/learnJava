package calculate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;



public class TestExcel {
	Properties prop = new Properties();
	FileInputStream propStream;
	FileInputStream excelStream;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TestExcel te = new TestExcel();
		
		ArrayList dataList=te.ReadExcel(); // call ReadExcel Method to read and get Arraylist
		
		//dump the data from arraylist 
		
		

	}

	private ArrayList ReadExcel() throws IOException {
		// TODO Auto-generated method stub
		ArrayList masterList= new ArrayList();
		
		/**
		 * 1./Read the property file to get the Excel File name
		 * 2. Read excel spread sheet
		 * 3. Dump into hashmap dataMap
		 * 4. add into arraylist
		 * 5. retun arraylist
		 * 
		 */
		propStream = new FileInputStream("/Users/arunmozhibabu/Documents/workspace/learningSelenium/src/calculate/test.properties");
		prop.load(propStream);
		System.out.println("The property value is : "+prop.getProperty("excel_path"));

		excelStream = new FileInputStream(new File(prop.getProperty("excel_path")));
		XSSFWorkbook excelBook=new XSSFWorkbook(excelStream);
		XSSFSheet sheet=null;
		
		return masterList;
	}

}
