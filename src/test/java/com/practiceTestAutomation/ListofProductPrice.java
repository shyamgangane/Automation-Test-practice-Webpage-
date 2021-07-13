package com.practiceTestAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListofProductPrice {
	
	WebDriver driver;
	
@Before	
		//Before setup the browser
	public void Setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com");
	
	}
	
@Test
	public void Product() {
	//finding all product price
	List<WebElement> AllProductPrice = driver.findElements(By.xpath("//span[@class='price product-price']"));	
	System.out.println("All product Price are as:" +AllProductPrice.size());
	for(int j = 0; j< AllProductPrice.size(); j++) {
	//	String list_price = AllProductPrice.get(j).getText();
		System.out.println(j+1 + ". " + AllProductPrice.get(j).getText());
   // 	int x=0;
 	//	x = x + Integer.valueOf(list_price.get(j).getText().substring(6));
	}
	
		
	}

@After
	public void BackHome() {
	driver.quit();
}
	
	

}
