package utilities;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_data_excel 
{
 
	//Excel sheet--> workbook-->sheet-->row-->columns
	
	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("./" + "//src//test//java//testdata//TestData_WFH.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		
		// Two ways to get the sheet (sheet name and index):
		XSSFSheet sheet = wb.getSheet("Data_WFH1"); // 1st sheet name by name
	//	XSSFSheet sheet1 = wb.getSheetAt(0); // 1st sheet by index
		
		
	    // To count no. of rows and columns
		int rowcount= sheet.getLastRowNum(); // return the row count
		int colcount= sheet.getRow(0).getLastCellNum(); // no .of columns present in row 0
		

		for (int i=0; i<rowcount; i++)  // incrementing the rows
		{
			XSSFRow currentrow= sheet.getRow(i);          // focus on current row
			
		for (int j=0; j<colcount; j++)    // incrementing the columns from each row
			{
			String value= currentrow.getCell(j).toString();  // to get the value from columns (toString can read all values)
			System.out.print("      "+value);     // for alignment issue using print
			}
		
		    System.out.println();
	  
		}
	}

}
