package com.selenium.pagetest;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.page.DataDriverExcel;
import com.selenium.util.WorksheetReadUtil;

public class DataDrivenTest {
	WebDriver driver;
	DataDriverExcel drvobj;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Charanya Vivek\\eclipse-workspace\\WebdriverSelenium\\resources\\geckodriver.exe");
	   driver=new FirefoxDriver();
		//drvobj=new DataDriverExcel(new FirefoxDriver());
	   drvobj=new DataDriverExcel(driver);
		 //driver.manage().window().maximize();
	  
	}
	@Test(testName="Login")
	public void validateLogin() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, HeadlessException, AWTException
	{
		//drvobj=new DataDriverExcel(new FirefoxDriver());
		//String loginvalidate=drvobj.clickLogin();
		//assertEquals(loginvalidate,"Login");
		//assert.assertEqual
	//}
	//@Test(dependsOnMethods="Login")
	//public void readExcel() throws EncryptedDocumentException, InvalidFormatException, IOException
	//{
		WorksheetReadUtil extractcolumnvalue=new WorksheetReadUtil();
		int rowcount=extractcolumnvalue.rowCount("FirstSheet");
		for(int i=1;i<=rowcount;i++)
		{
		//String loginvalidate=drvobj.clickLogin();
		String usernameexcel=extractcolumnvalue.excelRead("FirstSheet",i,0);
		String passwordexcel=extractcolumnvalue.excelRead("FirstSheet",i,1);
		String loginvalidate=drvobj.clickLogin();
		String actsucessloginconfirm=drvobj.getData(usernameexcel,passwordexcel);
		Thread.sleep(3000);
		//drvobj.clickLogin();
		assertEquals(loginvalidate,"Login");
		//assertEquals(actsucessloginconfirm,"Click Here To Change Password");
		}
	}
	
	/*@AfterSuite
	public void tearDown()
	{
		driver.close();
	}*/

}
