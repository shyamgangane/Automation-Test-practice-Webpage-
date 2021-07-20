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

public class AmazonTestCase {

	WebDriver driver;

	@Before	
	public void Setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");


	}

	@Test
	public void AccountDetail() {

		// WebElement Sign in click on 
		WebElement SignIn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		SignIn.click();

		// Enter the Emailid 
		WebElement EmailId = driver.findElement(By.id("ap_email"));
		EmailId.sendKeys("test@gmail.com");

		// To click the continue next button 
		WebElement ContinueTOClick = driver.findElement(By.id("continue"));
		ContinueTOClick.click();

		// fill the password
		WebElement Password = driver.findElement(By.id("ap_password"));
		Password.sendKeys("abc121");

		// click on sign in submit button
		WebElement submit = driver.findElement(By.id("signInSubmit"));
		submit.click();
		
		
		try {
			WebElement AlertMessage = driver.findElement(By.xpath("//h4[@class='a-alert-heading']"));
			System.out.println(AlertMessage.getText());
		} catch (Exception e) {
			
			WebElement AlertMessage = driver.findElement(By.xpath("//h4[@class='a-alert-heading']"));
			
			System.out.println(AlertMessage.getText());
		}
		
		
		

	}

	@After
	public void Home() {
		driver.quit();
	}


}
