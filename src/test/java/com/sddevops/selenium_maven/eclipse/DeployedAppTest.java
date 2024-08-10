package com.sddevops.selenium_maven.eclipse;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;

public class DeployedAppTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;
	private WebElement element;
	private String testUrl = "http://localhost:8888/java-web-app/";

	@Test
	public void checkHeader() {
		element = webDriver.findElement(By.tagName("h1"));

		AssertJUnit.assertEquals(element.getText(), "Hello JSP and Servlet!");
	}

	@Test
	public void checkNavigate() {
		webDriver.findElement(By.linkText("To Dashboard")).click();

		element = webDriver.findElement(By.tagName("h2"));
		AssertJUnit.assertTrue(element.getText().contains("Manga Collection"));
	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "/Users/weiwei/Desktop/chromedriver-mac-x64/chromedriver";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		webDriver.navigate().to(testUrl);
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.quit();
	}

}
