package com.cname.core.framework.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cname.core.framework.utility.Constants;
import com.cname.core.framework.utility.Global;

public class SeWebDriver 
{
	public void get()
	{
		Driver.driver.get(Global.browserUrl);
	}
	
	public void implicitlyWait()
	{
		Driver.driver.manage().timeouts().implicitlyWait(Constants.waitTime, TimeUnit.SECONDS);
	}
	
	public void waitForPageLoad()
	{
		Driver.driver.manage().timeouts().pageLoadTimeout(Constants.waitTime, TimeUnit.SECONDS);
	}
	
	public void waitForWebElementToBoVisible(String locator, String locatorValue)
	{
		WebDriverWait wait = new WebDriverWait(Driver.driver, Constants.waitTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.seByMechanism(locator, locatorValue)));
	}
	
	public String getBrowserTitle()
	{
		return Driver.driver.getTitle();
	}
	
	public String getBrowserPageSource()
	{
		return Driver.driver.getPageSource();
	}
	
	public void to(String url)
	{
		Driver.driver.navigate().to(url);
	}
	
	public void back()
	{
		Driver.driver.navigate().back();
	}
	
	public void forward()
	{
		Driver.driver.navigate().forward();
	}
	
	public void maximizeWindow()
	{
		Driver.driver.manage().window().maximize();
	}
	
	public void setOwnWindowSize()
	{
		Dimension d1 = new Dimension(Constants.browserWidth, Constants.browserHight);
		Driver.driver.manage().window().setSize(d1);
	}
	
	// Select Class Wrapper method
}
