package org.trmga.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {

	/**
	 * This method is used to maximize the browser window
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		
		//maximizing the browser window
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method is used to make driver wait implicitly for the given long seconds.
	 * @param driver
	 * @param longseconds
	 */
	public void toImplicitlyWait(WebDriver driver, int longseconds) {
		
		//implicit wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longseconds));
		
	}
	
	/**
	 * This method is used to mouse hover on the web element based on the target.
	 * Pass web element as arguments.
	 * @param driver
	 * @param element
	 */
	public void toMoveToElement(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		
		act.moveToElement(element).perform();
		
		
	}
	
	
	public static void getScreenShot(WebDriver driver) {
		
		JavaUtility jUtil = new JavaUtility();
		
		//step 1: type cast driver reference into TakesScreenshot reference
		TakesScreenshot ts = (TakesScreenshot) driver;
  
		//step 2: call getScreenshotAs() and pass file type argument
		File temp = ts.getScreenshotAs(OutputType.FILE);
		 
		//step 3: create a destination file
		//create object for File class form java.io package
		File dest = new File("./errorshots/errorshots"+jUtil.getTimeStamp()+".png");         
		
		//step 4: copy paste the temp into dest using FileHandler class from selenium.io
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
	
	
	
	
}
