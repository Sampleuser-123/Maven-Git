package com.wbl.practice.WebdriverSelenium;

public class HelloWorld {
public static void main(String args[])
{
String filepath="C:\\Users\\Charanya Vivek\\Documents\\Sample.xlsx";
System.out.println("hello");
int index=filepath.indexOf(".");
System.out.println(index);
String diffExtention=filepath.substring(index);
System.out.println(diffExtention);
}
}
