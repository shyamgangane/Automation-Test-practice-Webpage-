package com.practiceTestAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraInvocation {
	
	WebDriver driver;
	
@Before	
	
	// Before Setup the Browser
	public void Setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com");
	
	}

	
@Test
	public void ProductSearch() throws InterruptedException
	{	
		// WebElement for Search Bar 
		WebElement SearchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		SearchBox.sendKeys("Pepe jeans");
		
		// WebElement for Submit button is click
		WebElement SearchButton = driver.findElement(By.xpath("//a[@class='desktop-submit']"));
		SearchButton.click();
		
		List<WebElement> productlist = driver.findElements(By.xpath("//h4[@class='product-product']"));
		System.out.println("Total no of value:" +productlist.size());
		
		List<WebElement> productPrice = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		System.out.println("Product Price :" +productPrice.size());
		Thread.sleep(5000);
		
		
	//	Assert.assertEquals("\"Pepe Jeans Men\"",	productPrice.getText());
		
		int count = 0;
		for(int i = 0; i< productlist.size(); i++ ) {
			String resultText = productlist.get(i).getText();
			System.out.println(resultText );

			if(productlist.get(i).getText().contains("jeans") || productlist.get(i).getText().contains("Jeans"))
			{

				count++;
			}
			
		}
		
		for(int j = 0; j< productPrice.size(); j++) {
			String list_price = productPrice.get(j).getText();
			System.out.println(j+1 + ". " + productlist.get(j).getText() + " : " + list_price);
			

		}
		
		
	}

@After
	
	public void backtohome()
	{
	driver.quit();
	
	}

	



}
