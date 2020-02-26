package com.agario.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	//Screenshots, alerts, frames, windows, Sync issue, javascript executor
	
	public static void captureScreenshot(WebDriver driver, String testName, String screenshotName) 
	{
		try 
		{
			TakesScreenshot ts =((TakesScreenshot)driver);
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File DestFile=new File("./Screenshots/"+testName+"_"+screenshotName+"_"+getCurrentDateTime()+".png");
			
			FileUtils.copyFile(src,DestFile);
			
			System.out.println("Screenshot captured");
		}
		catch (Exception e) {
			
			System.out.println("Exception while capturing screenshot "+e.getMessage());
		} 
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("yyyy-MM-dd");
		
//		Full date format: DateFormat customFormat = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
	
	public static void waitForElementByID(WebDriver driver, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
	}
	
	public static void waitForElementByClassName(WebDriver driver, String className)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
	}
	

	public boolean checkForElementID(WebDriver driver, String value)
	{
		if (driver.findElements(By.id(value)).size() != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	public static boolean checkIfElementExists(WebElement element)
	{
		if (element.isDisplayed() && element.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void swithcWindow(WebDriver driver)
	{		
//		String handle= driver.getWindowHandle();//Return a string of alphanumeric window handle
//		Set handle= driver.getWindowHandles();//Return a set of window handle
		Set<String> handles = driver.getWindowHandles();
		 
		String firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);
		 
		String winHandle=handles.iterator().next();
		 
		if (winHandle!=firstWinHandle) //To retrieve the handle of second window, extracting the handle which does not match to first window handle
		{
			String secondWinHandle = winHandle; //Storing handle of second window handle
			driver.switchTo().window(secondWinHandle); //Switch control to new window
		}
	}
	public static void waitAsec()
	{
		try
		{
			Thread.sleep(1500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
