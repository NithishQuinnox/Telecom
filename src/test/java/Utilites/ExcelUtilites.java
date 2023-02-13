package Utilites;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import telecompagefactory.CustomerPageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelUtilites {

	
	static Workbook book;
	static Sheet sheet;
	
	public static String path="./TestData/telecominfo.xlsx";
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file=null;
		try {
			file=new FileInputStream(path);
		
			book=WorkbookFactory.create(file);
		}
		catch(Exception e) {
			e.printStackTrace();
	}
		sheet=book.getSheet(sheetName);
		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
		
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
		return data;
	}


	
	

	public static void writeToExcel() throws IOException {
		int r=1;
		File file =    new File("./TestData/CustomerId1.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		//				        XSSFCell cell = null;
		//                       int colno=sheet1.getRow(0).getLastCellNum();
		//                       int rowno=sheet1.getPhysicalNumberOfRows();
		//                       Cell cell;
		XSSFRow row2=sheet1.createRow(0);
		XSSFRow row3=sheet1.createRow(1);
		//                       for(int j=1;j<=colno;j++) {
		//                    	   cell=sheet1.getRow(0).getCell(j);
		//                       
		//                       if(cell==null || cell.toString().trim().isEmpty()) {
		//                    	   System.out.println("hi");
		//                    	   row2.createCell(0).setCellValue("customer_id");
		//                    	
		//                    	   row3.createCell(0).setCellValue(CustomerPageFactory.new_Customer_Id);
		//                       }
		//                       }
		//                       System.out.println( rowno);
		//                       for(int i=0;i<=rowno;i++) {
		//                    	   for(int j=0;j<=colno;j++) {
		//		                          int rowno1=0;
		//		                          XSSFRow row = null;
		//		                       
		//	                            row2.createCell(0).setCellValue("customer_id");
		//                    		   if(row3.equals(null)
		//                    				 row =sheet1.createRow( rowno++);
		//                    		   
		//                    				row.createCell(0).setCellValue(CustomerPageFactory.new_Customer_Id);
		//                    		   }
		//                    		   else
		//                    		   {
		//                    			   row.createCell(0).setCellValue(CustomerPageFactory.new_Customer_Id);
		//                    		   }

		row2.createCell(0).setCellValue("customer_id");
		row3.createCell(0).setCellValue(CustomerPageFactory.new_Customer_Id);
		//		sheet1.getRow(1).createCell(0).setCellValue("customer_id");
		//		sheet1.getRow(2).createCell(0).setCellValue(CustomerPageFactory.new_Customer_Id);		
		FileOutputStream outputStream = new FileOutputStream("./TestData/CustomerId1.xlsx");
		wb.write(outputStream);
		wb.close();
		//

	}
}
//public static String[][] primaryKeyGetData(String primaryKey, int sheetNum, String filePath) {
//XSSFSheet sheet = getSheet(sheetNum, filePath);
//// String[][] = new String[sheet.get]
//String[][] data = new String[1][sheet.getRow(0).getLastCellNum()];
//System.out.println(sheet.getRow(0).getLastCellNum());
//for (int i = 0; i < sheet.getLastRowNum(); i++) {
//if (sheet.getRow(i).getCell(0).getStringCellValue().equals(primaryKey)) {
//for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
//// System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
//data[0][j] = sheet.getRow(i).getCell(j).getStringCellValue();
//
//
//
//}
//}
//}
//return data