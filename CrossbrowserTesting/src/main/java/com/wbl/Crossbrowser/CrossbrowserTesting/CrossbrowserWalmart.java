package com.wbl.Crossbrowser.CrossbrowserTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossbrowserWalmart {
	WebDriver driver;
	public CrossbrowserWalmart(WebDriver driver)
	{
		this.driver=driver;
	}
	//Walmart search flow
	public boolean addCart(String entervalue)
	{
		driver.get("https://www.walmart.com/");
	    WebElement search=driver.findElement(By.id("global-search-input"));
	    search.sendKeys(entervalue);
	    driver.findElement(By.name("elc-icon-search-nav")).click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.linkText("Lenovo Ideapad 330, 15.6\" screen Laptop, Intel Celeron N4000, 4GB RAM, 1TB HDD, WIN 10, Platinum Grey")).click();
	   String title= driver.getTitle();
	   System.out.println(title);
	   boolean b=title.contains("Laptop");
	   System.out.println(b);
	   return b;
	    //option-overlay
	    
	  // driver.findElement(By.xpath("//div[@class='variant-option-inner-container']/div[1]")).click();
	   // driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    //driver.findElement(By.xpath("//button[@class='button spin-button prod-ProductCTA--primary button--primary']/span/span[1]")).click();
	}

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrossbrowserWalmart cr=new CrossbrowserWalmart();
		cr.addCart();
	}*/

}
