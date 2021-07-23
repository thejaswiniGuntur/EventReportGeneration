package com.ibm.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		System.out.println("hai");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Drivers\\chromedriver_win32\\chromedriver_win32.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.google.com");

	}

}
