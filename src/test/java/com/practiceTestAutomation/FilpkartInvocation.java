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

public class FilpkartInvocation {
	WebDriver driver;
	
	// Before steup for browser
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");

	}

	@Test
	public void searchResult() throws InterruptedException {
		
		// WebElement for loginPopup close button
		WebElement PotentialAction = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		PotentialAction.click();

		Thread.sleep(3000);


		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchBox.sendKeys("mobile");



		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		searchButton.click();

		Thread.sleep(3000);

		List<WebElement> resultslist = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println("Total no of value:" +resultslist.size());


		int count = 0;
		for(int i = 0; i< resultslist.size(); i++ ) {
			String resultText = resultslist.get(i).getText();
			System.out.println(resultText );

			if(resultslist.get(i).getText().contains("realme") || resultslist.get(i).getText().contains("Realme"))
			{

				count++;
			}

		}
		System.out.println("Realme mobile count " + count );

		List<WebElement> resultslist_price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println("All Product Price count:" +resultslist_price.size());
		for(int j = 0; j< resultslist_price.size(); j++) {
			String list_price = resultslist_price.get(j).getText();
			System.out.println(j+1 + ". " + resultslist.get(j).getText() + " : " + list_price);
			

		}


	}

	@After
	public void homepage()
	{
		driver.quit();
	}




}
