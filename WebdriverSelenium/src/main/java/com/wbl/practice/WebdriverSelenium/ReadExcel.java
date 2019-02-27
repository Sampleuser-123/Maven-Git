package com.wbl.practice.WebdriverSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	//workbook is an interface and its implementation is HSSFworkbook and XSSFworkbook classes
	Workbook wb;
	FileInputStream fin;
	static String filepath="C:\\Users\\Charanya Vivek\\Documents\\Sample.xlsx";
	public String readExcel1() 
	{   
		String cellvalue=null;
		String username=null;
		String password=null;
		try {
			File file1=new File("C:\\Users\\Charanya Vivek\\Documents\\Sample.xlsx");
			 fin=new FileInputStream(file1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//to get the extention of file
		String diffExtention=filepath.substring(filepath.indexOf("."));
		if(diffExtention.equals(".xlsx"))
		{
			System.out.println("XSSFWorkbook obj of type workbook is created");
			try {
				wb=new XSSFWorkbook(fin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("HSSFWorkbook obj of type workbook is created");
			try {
				wb=new HSSFWorkbook(fin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Sheet sheet1=wb.getSheet("FirstSheet");
		
		//Find number of rows in excel file

	    //int rowCount = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		int rowCount = sheet1.getLastRowNum();
	    System.out.println("No:of rows are:"+rowCount);
	    System.out.println(sheet1.getLastRowNum());
	    //Create a loop over all the rows of excel file to read it

	    for (int i = 1; i <rowCount+1; i++) 
	    	{
	    	Row row1=sheet1.getRow(i);
	    	for (int j = 0; j < row1.getLastCellNum(); j++) {

	            //Print Excel data in console
	    		cellvalue=row1.getCell(j).getStringCellValue();
	    		//username=row1.getCell(j).getStringCellValue();
	    		//password=row1.getCell(j+1).getStringCellValue();
	            //System.out.print(row1.getCell(j).getStringCellValue()+"\n ");
                
	        }
	    }
		
	    return username;
	    //return password;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ReadExcel readex= new ReadExcel();
		String getcellvalue=readex.readExcel1();
		System.out.print(getcellvalue);
	}*/

}
