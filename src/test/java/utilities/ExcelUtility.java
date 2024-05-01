package utilities;

import java.io.File;
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


public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;
	
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int  getrowcount(String sheetName) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	public  int  getcellcount(String  sheetName,int rownum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	public  String   getcelldata(String sheetName,int  rownum,int colnum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			//data=cell.toString();
			DataFormatter formatter=new DataFormatter();
			data=formatter.formatCellValue(cell);
			return data;
			
		}
		catch(Exception e) {
			data="";
			
		}
		wb.close();
		fi.close();
		return data;
		
	}
	public  void   setcelldata(String sheetName,int rownum,int colnum,String data) throws IOException {
		File xlfile=new File(path);
		if(!xlfile.exists()) {
			wb=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			wb.write(fo);
					
		}
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		if(wb.getSheetIndex(sheetName)==-1)
			wb.createSheet(sheetName);
		sheet=wb.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null) {
			sheet.createRow(rownum);
			row=sheet.getRow(rownum);
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(path);
			wb.write(fo);
			fi.close();
			fo.close();
		}
	}
		public void fillGreenColour(String sheetName,int rownum,int colnum) throws IOException  {
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(sheetName);
			
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			style=wb.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
			
			
			public void fillRedColour(String sheetName,int rownum,int colnum) throws IOException  {
				fi=new FileInputStream(path);
				wb=new XSSFWorkbook(fi);
				sheet=wb.getSheet(sheetName);
				
				row=sheet.getRow(rownum);
				cell=row.getCell(colnum);
				style=wb.createCellStyle();
				
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell.setCellStyle(style);
				wb.write(fo);
				wb.close();
				fi.close();
				fo.close();
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
	
	

	}
	}


