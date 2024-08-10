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


public class NewTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		
  
  @Test
  public void checkId() {
	  WebElement we =  webDriver.findElement(By.id("content"));
	  
	  System.out.println("id we: "+we.getAttribute("role"));
	  AssertJUnit.assertEquals(we.getAttribute("role"), "contentinfo");
  }
  @Test
  public void checkTitle() {
	  //Load website as a new page
	  AssertJUnit.assertEquals(webDriver.getTitle(), "Home");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Retrieve link using it's class name and click on it
	  webDriver.findElement(By.className("link")).click();

	  //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
	  AssertJUnit.assertTrue(webDriver.getTitle().contains("Wikipedia"));
	  System.out.println("new title: "+webDriver.getTitle());
  }
  
  

  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "/Users/weiwei/Desktop/chromedriver-mac-x64/chromedriver";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver(); 
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  webDriver.navigate().to("https://devopsessentials.github.io");
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }

}
