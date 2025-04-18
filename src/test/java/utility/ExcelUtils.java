package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		int rowCount = wb.getSheet(xlsheet).getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public static int getColCount(String xlfile, String xlsheet, int rowNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		int colCount = wb.getSheet(xlsheet).getRow(rowNum).getLastCellNum();
		wb.close();
		fi.close();
		return colCount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rowNum,  int colNum) throws IOException{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rowNum);
		cell = row.getCell(colNum);
		
		String data;
		
		try {
		//data = cell.toString(); //to send the data in string format.
		
		//DataFormatter provided by Apache POI.
		DataFormatter format = new DataFormatter();
		data = format.formatCellValue(cell); // returns the formatted value of a cell as a string regardless of the cell type.
		}catch(Exception e) {
			data = "";
			System.out.println(e.getMessage());
		}
		
		wb.close();
		fi.close();
		return data;
	}
	
	public static void putCellData(String xlfile, String xlsheet, int rowNum,  int colNum, String data) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rowNum);
		cell = row.getCell(colNum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static void fillGreenColor(String xlfile, String xlsheet, int rowNum,  int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static void fillRedColor(String xlfile, String xlsheet, int rowNum,  int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
}
