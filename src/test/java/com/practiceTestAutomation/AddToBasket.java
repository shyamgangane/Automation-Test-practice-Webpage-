package com.practiceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AddToBasket {

	WebDriver  driver;
	String itemValue = "5";
	@Before
	public void Setup() {
		// Browser Setup Navigate the url
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://practice.automationtesting.in");
		

	}

	@Test
	public void Product() {
		// WebElement for click on book 
		WebElement BookProduct = driver.findElement(By.xpath("//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));
		BookProduct.click();

		// WebElement for firstly clear the quantity then select items
		WebElement BookQuantity = driver.findElement(By.xpath("//input[@value='1']"));
		BookQuantity.clear();
		BookQuantity.sendKeys(itemValue);

		// WebElement for Add to cart
		WebElement SubmitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		SubmitBtn.click();
		
		WebElement Addtocart = driver.findElement(By.xpath("//span[@class='cartcontents']"));
		
		String cart_Added = Addtocart.getText(); // cart_Added = "5 items"
		String[] valuesOfCartText = cart_Added.split(" "); // valuesOfCartText = ["5"] ["items"] // "the Books added as 5 in quantity"
//		for (int i = 0; i < valuesOfCartText.length; i++) {
//			System.out.println(valuesOfCartText[i]);
//		}
		
		Assert.assertEquals("The values not matching",itemValue, valuesOfCartText[0]);
		 
		
	}

	@After
	public void tearDown() {

		driver.quit();
	}


}
