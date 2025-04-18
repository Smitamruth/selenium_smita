package advanced_programs;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//By default, selenium doesnot support excel files. Thus we use Apace POI.
		
				
		//Excel File ==> Workbook ==> Sheets ==> Rows ==> Cells.
		// To read data and write data into excel file, there are 2 classes provided by Apache POI--
		// 1) FileInputStream -- reading .
		// 2) FileOutputStream -- writing .
		
		//XSSFWorkbook -- workbook || XSSFSheet -- Sheet || XSSFRow -- Row || XSSFCell -- Cell.  
		
		//Reading data from excel.
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		
		int cols = sheet.getRow(1).getLastCellNum();
		
		System.out.println("No. of rows are : "+rows +" and No. of columns are : "+cols);
		
		for(int i=0; i<=rows ; i++) {
			XSSFRow currRow = sheet.getRow(i);
			for(int j = 0 ; j<cols;j++) {
				XSSFCell cell = currRow.getCell(j);
				System.out.print(cell.toString() + "\t"); 
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}
