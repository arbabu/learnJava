package calculate;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter
{
	public static void main(String[] args) throws Exception {
		writeXLSFile();
	}
	
	
	public static void writeXLSFile() throws Exception{
		
		String[][] excelData = new String[][]{
			{"Name", "Eng", "Math", "Sci", "Result"},
			{"Tory", "67", "89", "23", ""},
			{"Flint", "36", "67", "69", ""},
			{"Ann", "90", "89", "100", ""},
			{"Kelly", "78", "56", "89", ""},
			{"Saha", "87", "88", "78", ""}
		};

		FileOutputStream outStream = new FileOutputStream("C:/Users/daddyiscrybaby/Downloads/studmarkresult.xlsx");
		XSSFWorkbook xlsbook = new XSSFWorkbook();		
		XSSFSheet sheet = xlsbook.createSheet("Sheet1");

		for(int x=0; x<excelData.length; x++)
		{
			XSSFRow row = sheet.createRow(x);
			for(int y=0; y<excelData[x].length; y++)
			{				
				XSSFCell cell = row.createCell(y);
				cell.setCellValue(excelData[x][y]);
			}
		}
		
		/*FileOutputStream outStream = new FileOutputStream("C:/Users/daddyiscrybaby/Downloads/studmarkresult.xlsx");
		XSSFWorkbook xlsbook = new XSSFWorkbook();
		XSSFSheet sheet = xlsbook.createSheet("Sheet1");
		
		//Row 0
		XSSFRow row = sheet.createRow(0);
		
		XSSFCell cell0 = row.createCell(0);
		cell0.setCellValue("Name");
		
		XSSFCell cell1 = row.createCell(1);
		cell1.setCellValue("Eng");
		
		XSSFCell cell2 = row.createCell(2);
		cell2.setCellValue("Math");

		XSSFCell cell3 = row.createCell(3);
		cell3.setCellValue("Sci");

		XSSFCell cell4 = row.createCell(4);
		cell4.setCellValue("Result");

		//Row 1
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("Tory");
		row1.createCell(1).setCellValue("67");
		row1.createCell(2).setCellValue("89");
		row1.createCell(3).setCellValue("23");
		row1.createCell(4).setCellValue("");
		
		//Row 2
		XSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("Flint");
		row2.createCell(1).setCellValue("36");
		row2.createCell(2).setCellValue("67");
		row2.createCell(3).setCellValue("69");
		row2.createCell(4).setCellValue("");
		
		//Row 3
		XSSFRow row3= sheet.createRow(3);
		row3.createCell(0).setCellValue("Ann");
		row3.createCell(1).setCellValue("90");
		row3.createCell(2).setCellValue("89");
		row3.createCell(3).setCellValue("100");
		row3.createCell(4).setCellValue("");
		
		//Row 4
		XSSFRow row4= sheet.createRow(4);
		row4.createCell(0).setCellValue("Kelly");
		row4.createCell(1).setCellValue("78");
		row4.createCell(2).setCellValue("56");
		row4.createCell(3).setCellValue("89");
		row4.createCell(4).setCellValue("");
		*/
		
		xlsbook.write(outStream);
		
		xlsbook.close();
		outStream.flush();
		outStream.close();		
	}
	
}