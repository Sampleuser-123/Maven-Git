package com.wbl.Crossbrowser.CrossbrowserTesting;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrossbrowserWalmartTest {
	 WebDriver driver;
	 @BeforeClass
	public void setup() 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Charanya Vivek\\eclipse-workspace\\CrossbrowserTesting\\resources\\geckodriver.exe");
	   // driver=new FirefoxDriver();//cannot instantiate webdriver
	    
	}
	 @Test
public void validatePage()
{
	CrossbrowserWalmart cr=new CrossbrowserWalmart(new FirefoxDriver());
	boolean PageTitle=cr.addCart("laptop");
	assertEquals(PageTitle,true);
	}
public void tearDown() 
{
	driver.quit();
}
}
