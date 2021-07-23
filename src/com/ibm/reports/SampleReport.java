package com.ibm.reports;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extents;
	static ExtentTest logger;
	static WebDriver driver;
	@BeforeClass
	static void reportGeneration() {
		htmlReporter=new ExtentHtmlReporter("./test-output/my own reports.html");
		extents=new ExtentReports();
		extents.attachReporter(htmlReporter);
		extents.setSystemInfo("OS", "windows");
		extents.setSystemInfo("HostName", "Thejaswini");
		extents.setSystemInfo("Environment", "testing");
		extents.setSystemInfo("Author", "Selenium Tester");
		htmlReporter.config().setDocumentTitle("My html Reports");
		htmlReporter.config().setReportName("My own report");
		htmlReporter.config().setTheme(Theme.DARK);
	
	}
	
	
	
	@Test
	static void init() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\chromedriver.exe");
		  driver = new ChromeDriver();
		 driver.get("https://www.google.com");
		 Thread.sleep(1000);
	}

	@Test
	public static void checkUrl() throws IOException {
		logger=extents.createTest("checkUrl");
		logger.addScreenCaptureFromPath("");
		logger.pass("fail becx some error",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\GunturThejaswini\\Desktop\\ammapic.jpg").build());
		String url = "www.google.com";
		Assert.assertEquals(url, "www.google.com");
	}

	@Test      
	static void enterText() throws InterruptedException {
		logger=extents.createTest("enterText");
		 driver.get("https://www.google.com");
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fakebox-input']")).sendKeys("text");
		Assert.assertTrue(true);
		System.out.println("pass");
	}
@AfterClass
static void results() {
	extents.flush();
	 
}
	

}
