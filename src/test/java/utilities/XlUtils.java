package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils 

{

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	
	{
        fis = new FileInputStream(xlfile);
        wb= new XSSFWorkbook(fis);
        sheet= wb.getSheet(xlsheet);
        int rowcount = sheet.getLastRowNum();
        wb.close();
        fis.close();
		return rowcount;
		
	}
	
	public static int getCellCount (String xlfile, String xlsheet,int rownum) throws Exception
	{
		fis = new FileInputStream(xlfile);
        wb= new XSSFWorkbook(fis);
        sheet= wb.getSheet(xlsheet);
        row= sheet.getRow(rownum);
        int cellcount = row.getLastCellNum();
        wb.close();
        fis.close();
		return cellcount;
		
	
	}
	
	public static String getCellData (String xlfile, String xlsheet, int rownum, int colnum) throws Exception
	{
		
		fis = new FileInputStream(xlfile);
        wb= new XSSFWorkbook(fis);
        sheet= wb.getSheet(xlsheet);
        row= sheet.getRow(rownum);
        cell= row.getCell(colnum);
        String data;
        try {
			DataFormatter formatter = new DataFormatter();
			String cellData= formatter.formatCellValue(cell);
			return cellData;
			
		} 
        catch (Exception e) 
        {
		data= "";	
		}
        wb.close();
        fis.close();
		return data;
	}
	
	public static void  setCellData (String xlfile, String xlsheet, int rownum, int colnum, String data) throws Exception
	{
		
		fis = new FileInputStream(xlfile);
        wb= new XSSFWorkbook(fis);
        sheet= wb.getSheet(xlsheet);
        row= sheet.getRow(rownum);
        cell= row.createCell(colnum);
        cell.setCellValue(data);
        fos= new FileOutputStream(xlfile);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
	}
}
