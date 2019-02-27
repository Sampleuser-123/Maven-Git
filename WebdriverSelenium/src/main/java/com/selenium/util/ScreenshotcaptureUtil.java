package com.selenium.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.AWTException;

import java.awt.HeadlessException;

public class ScreenshotcaptureUtil {
	public static void screenShot(String filename) throws HeadlessException, AWTException, IOException 
	{ //File f1=new File(filename);Will create a file if the file is not present in write operation
		BufferedImage in=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(in, "png",new File("C:\\Users\\Charanya Vivek\\eclipse-workspace\\WebdriverSelenium\\resources\\"+filename));
	}

	public static void main(String[] args) throws HeadlessException, AWTException, IOException {
		// TODO Auto-generated method stub
		//ScreenshotcaptureUtil screenshot1=new ScreenshotcaptureUtil();
		screenShot("dynamicscreenshot.png");
	}

}
