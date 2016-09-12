
package calculate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddressClass {

	public static void main(String[] args) throws IOException {
		AddressClass ac = new AddressClass(); //----
		//return arraylist masterAddressList
		ArrayList masterAddressList = ac.ReadExcel();
		for(int m=0; m<masterAddressList.size(); m++)
		{
			HashMap hm= (HashMap) masterAddressList.get(m);
			
			System.out.println("Name : "+hm.get("NAME"));
			System.out.println("Address1 : "+hm.get("Address1"));
			System.out.println("Address2 : "+hm.get("Address2"));
			System.out.println("City: "+hm.get("City"));
			System.out.println("State: "+hm.get("State"));
			System.out.println("Zipcode: "+hm.get("Zipcode"));
			
		}
	}
	
	public ArrayList ReadExcel() throws IOException {
		ArrayList masterAddressList = new ArrayList();
		//Find test.properties file
		FileInputStream propertiesFileStream = new FileInputStream("/Users/arunmozhibabu/Desktop/ArunJob/githubProjects/learnJava/src/main/java/calculate/test.properties");

		//Load test.properties file to get address_path
		Properties prop = new Properties();
		prop.load(propertiesFileStream);
		
		//Find AddressExcel file using address_path	
		FileInputStream excelFileStream = new FileInputStream(new File(prop.getProperty("address_path")));
		XSSFWorkbook AddressBook = new XSSFWorkbook(excelFileStream);
		XSSFSheet AddressSheet = AddressBook.getSheet("AddressSheet");
		
		//Dump into temporary arraylist AddressList
		ArrayList AddressList = new ArrayList();
		for (int i=1; i<=AddressSheet.getLastRowNum(); i++){
			for (int j=0; j<AddressSheet.getRow(i).getLastCellNum(); j++) {
				String value = AddressSheet.getRow(i).getCell(j).getStringCellValue();
				AddressList.add(value);
			}
		//Dump into hashmap dataMap == single line of excel sheet
			HashMap dataMap = new HashMap();
			dataMap.put("Name", AddressList.get(0));
			dataMap.put("Address1", AddressList.get(1));
			dataMap.put("Address2", AddressList.get(2));
			dataMap.put("City", AddressList.get(3));
			dataMap.put("State", AddressList.get(4));
			dataMap.put("Zipcode", AddressList.get(5));
		//add into arraylist masterAddressList
			masterAddressList.add(dataMap);
		}
		return masterAddressList;		
	}
	
	

}