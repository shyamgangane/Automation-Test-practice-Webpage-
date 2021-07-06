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

public class WebPage {
	
	WebDriver driver;

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
	}
	
	
	@Test
	public void searchboxTest() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("mobile");
		
		Thread.sleep(3000);

		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		
//		List<WebElement> resultslist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
//		
//		for(int i = 0; i< resultslist.size(); i++ ) {
//		String resultText = resultslist.get(i).getText();
//			System.out.println(resultText );
//		}
		
		
		Thread.sleep(3000);
	
		WebElement searchResult = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
		
		
		// Validation
		

		Assert.assertEquals("\"mobile\"", searchResult.getText());
		
	}	


	@Test
	public void searchResult() {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("mobile");
		
		

		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		
		List<WebElement> resultslist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		for(int i = 0; i< resultslist.size(); i++ ) {
		String resultText = resultslist.get(i).getText();
			System.out.println(resultText );

	

		}
	}

		
	

	@After
	public void homepage()
	{
		driver.quit();
	}
		

}
