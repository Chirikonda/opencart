package utilities;


	import java.io.File;
	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	import org.apache.poi.hssf.usermodel.HSSFCell;
	import org.apache.poi.hssf.usermodel.HSSFRow;
	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class Utility {
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static HSSFWorkbook wb;
		public static HSSFSheet sheet1;
		public static HSSFRow row;
		public static HSSFCell cell;
		public static CellStyle style;
		String path;
	    public Utility(String path) {
	    	
	  this.path=path;
	}
	    public int  getrowcount(String sheetName) throws IOException {
	    	fi=new FileInputStream(path);
	    	wb=new HSSFWorkbook(fi);
	    	sheet1=wb.getSheet(sheetName);
	    	int rowcount=sheet1.getLastRowNum();
	    	wb.close();
			fi.close();
			return rowcount;
	    }
	    
	    public  int  getcellcount(String  sheetName,int rownum) throws IOException {
			fi=new FileInputStream(path);
			wb=new HSSFWorkbook(fi);
			sheet1=wb.getSheet(sheetName);
			row=sheet1.getRow(rownum);
			int cellcount=row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
		public  String   getcelldata(String sheetName,int  rownum,int colnum) throws IOException {
			fi=new FileInputStream(path);
			wb=new HSSFWorkbook(fi);
			sheet1=wb.getSheet(sheetName);
			row=sheet1.getRow(rownum);
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
				wb=new HSSFWorkbook();
				fo=new FileOutputStream(path);
				wb.write(fo);
						
			}
			fi=new FileInputStream(path);
			wb=new HSSFWorkbook(fi);
			if(wb.getSheetIndex(sheetName)==-1)
				wb.createSheet(sheetName);
			sheet1=wb.getSheet(sheetName);
			
			if(sheet1.getRow(rownum)==null) {
				sheet1.createRow(rownum);
				row=sheet1.getRow(rownum);
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
			wb=new HSSFWorkbook(fi);
			sheet1=wb.getSheet(sheetName);
			
			row=sheet1.getRow(rownum);
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
			wb=new HSSFWorkbook(fi);
			sheet1=wb.getSheet(sheetName);
			
			row=sheet1.getRow(rownum);
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

		


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	