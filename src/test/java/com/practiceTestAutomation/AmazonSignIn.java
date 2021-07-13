package com.practiceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSignIn {
	
	
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


@Test

public void dropDown() throws InterruptedException {
	
	// Here to click on Account Sign in
	WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	ele.click();
	
	// send email id 
	WebElement UserName = driver.findElement(By.id("ap_email"));
	UserName.sendKeys("test@gmail.com");
	
	// To click on submit button
	WebElement Send = driver.findElement(By.id("continue"));
	Send.click();
	
	// WebElement fetch the pass
	 WebElement password = driver.findElement(By.id("ap_password"));
	 password.sendKeys("abcd121");
	 
	 // click on submit btn
	 WebElement submit = driver.findElement(By.id("signInSubmit"));
	 submit.click();
	
	 
	 // Alert masg Text on console
	 WebElement alertPopup = driver.findElement(By.xpath("//span[@class='a-list-item']"));
	// Alert alertPop = driver.switchTo().alert();
	 System.out.println(alertPopup.getText());
	 
	 Thread.sleep(3000);
	 
	 // Validation
	 
	 String titleOfApplication = driver.getTitle();
	 System.out.println("The title of Application is :" +titleOfApplication);
	 
	 String ExpectedTitleOfApp = "https://www.amazon.in/ap/signin";
	 
	 if(ExpectedTitleOfApp.equals(titleOfApplication))
	 {
		 System.out.println("The Excepted and Actual title is matching");
	 }
	 else
	 {
		 System.out.println("The Two titles are not matching");
	 }
	 
}
	



@After

public void teardown() {
	driver.quit();
	
}
	
	

}
