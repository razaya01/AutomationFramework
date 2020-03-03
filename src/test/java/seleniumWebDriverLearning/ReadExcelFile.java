package seleniumWebDriverLearning;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ReusableFunctions.CommonlyUsedFunctionality;

public class ReadExcelFile extends CommonlyUsedFunctionality {
	  String filePath = "D:\\yasin\\flatmates.xls";
	  String fileName = "flatemates.xls";
	  String sheetName ="ExcelBioData";
	  String[] dataToWrite = { "totalOrderText", " yasin" };
	
	  
	  
	public String readExcel(String filePath, String fileName, String sheetName, int rowNo) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath);
		
		Workbook workbookObj = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xls")) {
			workbookObj = new HSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xlsx")) {
			workbookObj = new XSSFWorkbook(inputStream);

		}
		Sheet sheetobj = workbookObj.getSheet(sheetName);
		int rowCount = sheetobj.getLastRowNum() - sheetobj.getFirstRowNum();
		
//		for (int i = 0; i < rowCount + 1; i++) {
		      Row row = sheetobj.getRow(rowNo);

//			for (int j = 0; j < row.getLastCellNum(); j++) {
		      String xpath = row.getCell(1).getStringCellValue();
		      writeExcel(filePath,fileName,sheetName,dataToWrite);
				System.out.print(xpath);
				return xpath;
				
             
		}
	 
	
	 public static void main(String...strings) throws IOException{
		 ReadExcelFile readexcelfile = new ReadExcelFile();
		
		  String filePath = "D:\\yasin\\flatmates.xls";
		  String fileName = "flatemates.xls";
		  String sheetName ="ExcelBioData";
		 
		  readexcelfile.readExcel(filePath, fileName, sheetName,1);
	 }
}

