package seleniumWebDriverLearning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import ReusableFunctions.CommonlyUsedFunctionality;
import ReusableFunctions.XpathsConstants;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
public class ReadExcel extends XpathsConstants {
	
	

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
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
		System.out.println("row count is: "+rowCount);
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheetobj.getRow(i);
			

			for (int j = 0; j < row.getLastCellNum(); j++) {

				System.out.print(row.getCell(j).getStringCellValue());

			}

			System.out.println();
		}
//	Row row = sheetobj.getRow(1);
//	Cell cell = row.getCell(1);
//		System.out.println(cell);
//		System.out.println(sheet.getRow(0).getCell(0));
		// String cellval = cell.getStringCellValue();
		// System.out.println(cellval);

	}
}
