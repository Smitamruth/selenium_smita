package advanced_programs;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWritingDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Write data into xls.
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\write.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");

		// 1st row
		XSSFRow row1 = sheet.createRow(0);
		
		row1.createCell(0).setCellValue("BookName");
		row1.createCell(1).setCellValue("PurchaseDate");
		row1.createCell(2).setCellValue("Price");
		row1.createCell(3).setCellValue("Location");

		// 2nd row
		XSSFRow row2 = sheet.createRow(1);
		
		row2.createCell(0).setCellValue("Java");
		row2.createCell(1).setCellValue("29-Aug-2025");
		row2.createCell(2).setCellValue("350");
		row2.createCell(3).setCellValue("Dvg");

		// 3rd row
		XSSFRow row3 = sheet.createRow(2);
		
		row3.createCell(0).setCellValue("C#");
		row3.createCell(1).setCellValue("3-Sep-2024");
		row3.createCell(2).setCellValue("200");
		row3.createCell(3).setCellValue("Hubli");

		workbook.write(file);
		workbook.close();
		file.close();
	}

}
