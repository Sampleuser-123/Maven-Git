package com.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class WorksheetReadUtil {
	public String excelRead(String sheet,int row,int column) throws EncryptedDocumentException, InvalidFormatException, IOException
	{ FileInputStream fin=new FileInputStream("C:\\Users\\Charanya Vivek\\Documents\\Sample.xlsx");
	Workbook wb = WorkbookFactory.create(fin);
	//to get num of rows in a sheet to iterate through
	//wb.getSheet(sheet).getLastRowNum();
	//to get the last cell
	//Cell cell=wb.getSheet(sheet).getRow(row).getCell(column);
	String Actualvalue=wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
	return Actualvalue;
	}
	public int rowCount(String sheet) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		int  rownum=0;
	FileInputStream fin=new FileInputStream("C:\\Users\\Charanya Vivek\\Documents\\Sample.xlsx");
	Workbook wb = WorkbookFactory.create(fin);
	//to get num of rows in a sheet to iterate through
	rownum=wb.getSheet(sheet).getLastRowNum();
	System.out.println(rownum);
	return rownum;
	}
	/*public static void main(String args[])
	{
		WorksheetRead workobj=new WorksheetRead();
		try {
			String data=workobj.excelRead("FirstSheet",3,0);
			workobj.rowCount("FirstSheet");
			System.out.println(data);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
