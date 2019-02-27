package com.selenium.page;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.util.ScreenshotcaptureUtil;

public class DataDriverExcel {
	WebDriver driver;
	public DataDriverExcel(WebDriver driver)
	{
		this.driver=driver;
	}
	public String clickLogin()
	{   
		driver.get("http://www.whiteboxqa.com/");
	
		WebElement login=driver.findElement(By.id("loginButton"));
		login.click();
		WebElement logintitle=driver.findElement(By.xpath("//h1[@class='heading-title pull-left']"));
		//to get the login text so that we can confirm thet we are in login page
		String loginstr=logintitle.getText();
		System.out.println(loginstr);
		
				//driver.findElement(By.id());
				//driver.findElement(By.
		return loginstr;
	}
	public String getData(String username,String password) throws InterruptedException, HeadlessException, AWTException, IOException
	{ 
		String actualsucesslogin=null;
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
		//Thread.sleep(1000);
		//to check sucessful login
		//WebElement sucesslogin=driver.findElement(By.linkText("Click Here To Change Password"));
		//String actualsucesslogin=sucesslogin.getText();
		//System.out.println(actualsucesslogin);
		//driver.navigate().back();
		Thread.sleep(2000);
		//driver.findElement(By.id("logout")).click();//if successful login then click
		WebElement logoutvisible=driver.findElement(By.id("logout"));
		if(logoutvisible.isDisplayed())
		{
			WebElement sucesslogin=driver.findElement(By.linkText("Click Here To Change Password"));
			actualsucesslogin=sucesslogin.getText();
			//System.out.println(actualsucesslogin);
			logoutvisible.click();
		}
		else if(!logoutvisible.isDisplayed()) //take screenshot for wrong password
		{
			ScreenshotcaptureUtil.screenShot("dynamicscreenshot.png");//dynamically pass the file name
		}
		return actualsucesslogin;
	}

}
