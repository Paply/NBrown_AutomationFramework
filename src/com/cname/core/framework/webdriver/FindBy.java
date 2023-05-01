package com.cname.core.framework.webdriver;

import org.openqa.selenium.By;

public class FindBy 
{
	public static By seByMechanism(String findByMechanism, String locatorValue)
	{
		By by = null;
		switch(findByMechanism.toLowerCase())
		{
			case "id":
				by = By.id(locatorValue);
				break;
				
			case "class_name":
				by = By.className(locatorValue);
				break;
				
			case "name":
				by = By.name(locatorValue);
				break;
				
			case "linktext":
				by = By.linkText(locatorValue);
				break;
			
			case "partial_linktext":
				by = By.partialLinkText(locatorValue);
				break;
				
			case "css_selector":
				by = By.cssSelector(locatorValue);
				break;
			
			case "xpath":
				by = By.xpath(locatorValue);
				break;
				
			case "tagname":
				by = By.tagName(locatorValue);
				break;
				
		}
		return by;
	}
}
