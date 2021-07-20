package com.practiceTestAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAction {


	WebDriver driver;

	@Before	
	public void Setup() {

		// Before setup the browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");

	}


	//	@Test
	//
	//	public void dropDown() throws InterruptedException {
	//
	//		// Here to click on Account Sign in
	//		WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	//
	//		Thread.sleep(3000);
	//
	//		Actions act = new Actions(driver);
	//		act.moveToElement(ele);
	//		act.build().perform();
	//	}

	@Test
	public void Accountlist() throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.moveToElement(ele);
		act.build().perform();

		List<WebElement> accountlist = driver.findElements(By.xpath("//a[@class='nav-link nav-item']"));
		System.out.println("Total no of list" +accountlist.size());
		for(int i=0; i<accountlist.size(); i++) {
			String alllist = accountlist.get(i).getText();
			System.out.println(alllist);


		}
		
	}	


	}
