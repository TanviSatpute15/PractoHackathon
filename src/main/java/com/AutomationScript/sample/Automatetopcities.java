package com.AutomationScript.sample;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

//Finding Top cities in Diagnostic Page.
public class Automatetopcities extends BaseUI {
			
	       @Parameters("browser")
        	@Test(priority=1)		
			public void OpenBrowser(String browser)
				{
					openBrowserAndNavigateToPracto(browser);
				}
	       
	       @Test(priority=2)			
			public void diagnostic()
				{
					clickElement("diagnostic_xpath");
				}
	       
	       @Test(priority=3)			
			public void ListCities()
			    {
					List<WebElement> topCity = (List<WebElement>) getElements("city_xpath");
					for(WebElement city:topCity)
					{
						System.out.println(city.getText());
						
					}
				}
	       
	       @Test(priority=4)			
			public void close()
				{
	    	   driver.navigate().back();
					closeBrowser(); 
				}
			}