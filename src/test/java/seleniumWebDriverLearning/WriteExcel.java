package seleniumWebDriverLearning;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {
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
		Row row = sheetobj.getRow(0);
		Row newRow = sheetobj.createRow(rowCount + 1);
		for (int j = 0; j < row.getLastCellNum(); j++) {

			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);

		}

		inputStream.close();

		FileOutputStream outputStream = new FileOutputStream(filePath);

		workbookObj.write(outputStream);

		outputStream.close();

	}

	public static void main(String[] args) throws IOException {

		  String filePath = "D:\\yasin\\flatmates.xls";
		  String fileName = "flatemates.xls";
		  String sheetName ="ExcelBioData";
		WriteExcel writeexcel = new WriteExcel();
		String[] valueToWrite = {"AFA_PICKED_QTY ","(//input[@data-header='picked-qty'])[3]"};
		
		writeexcel.writeExcel(filePath, fileName, sheetName, valueToWrite);
	}

}
