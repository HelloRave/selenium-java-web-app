package com.sddevops.selenium_maven.eclipse;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class ELearning2 {
	private WebDriver webDriver;
	private WebElement element;
	private String testUrl = "https://www.tp.edu.sg/schools-and-courses/adult-learners/all-courses.html";

	@Test
	public void testSearch() {
		element = webDriver.findElement(By.className("search"));
		element.click();

		String searchTerms = "devops";
		String enterKey = "Keys.ENTER";
		element.sendKeys(searchTerms, enterKey);

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.get("https://www.tp.edu.sg/schools-and-courses/adult-learners/all-courses.html?keyword=devops");
		
		element = webDriver.findElement(By.className("courselisting"));
		AssertJUnit.assertEquals(element.getAttribute("data-total"), "4");

	}

	@BeforeMethod
	public void beforeMethod() {
		webDriver.navigate().to(testUrl);
	}

	@BeforeTest
	public void beforeTest() {
		String chromeDriverDir = "/Users/weiwei/Desktop/chromedriver-mac-x64/chromedriver";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}

}
