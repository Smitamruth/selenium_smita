package advanced_programs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDynamicWritingDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\dynamic.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Data");

		Scanner sc = new Scanner(System.in);

		int rows = sc.nextInt();
		System.out.println("Enter the number of rows you want to have: " + rows);

		int cols = sc.nextInt();
		System.out.println("Enter the number of columns you want to have: " + cols);

		for (int i = 0; i < rows; i++) {
			XSSFRow currRow = sheet.createRow(i);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = currRow.createCell(j);
				cell.setCellValue(sc.next());
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();

	}

}
