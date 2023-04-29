package com.testpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cname.core.framework.utility.Constants;
import com.cname.core.framework.utility.FileUploadhandler;

public class Test1
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/shalinik/Downloads/UploadC.html");
		driver.findElement(By.xpath("//label[text()='Select a file:']")).click();
		Thread.sleep(5000);
		FileUploadhandler.uploadFile("D:\\Automation_batch\\Test3.java");
	}
}
