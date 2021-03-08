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

//Search for hospital with specified location
public class AutomateFindHospitals extends BaseUI {
			int itemCount = 0;
			String searchPageId, itemPageId;
		
		    @Parameters("browser")
			@Test(priority=1)
			public void OpenBrowser(String browser) 
			{
				openBrowserAndNavigateToPracto(browser);
			}
		
		    @Test(priority=2)
			public void SearchHospitals()
			{
				getElement("searchLocation_xpath").click();
				clickElement("clearSearchLocationButton_xpath");
				enterText("searchLocation_xpath", "Bangalore");
				new WebDriverWait(driver, 30).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(prop.getProperty("bangaloreLocationButton_xpath"))));
				clickElement("bangaloreLocationButton_xpath");
				enterText("searchBox_xpath", "Hospital");
				new WebDriverWait(driver, 30).until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("hospitalButton_xpath"))));
				clickElement("hospitalButton_xpath");
			}
			
		    @Test(priority=3)
			public void Hospitalsopen()
			{
				clickElement("open24X7CB_xpath");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		    @Test(priority=4)
			public void applyfilter()
			{
				clickElement("allFilters_xpath");
				clickElement("hasParkingCB_xpath");
		
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
				// Displaying the search results where rating greater than 3.5
		    @Test(priority=5)
		    public void ListHospitals()
			{
				int i = 0;
				float[] ratingsFloat = new float[10];
				List<WebElement> ratings = getElements("ratings_xpath");
				Iterator<WebElement> rItr = ratings.iterator();
				while (rItr.hasNext()) {
					WebElement ob = rItr.next();
					ratingsFloat[i] = Float.parseFloat(ob.getText());
					i++;
				}
			
				List<WebElement> hospitalNames = getElements("hospitalNames_xpath");
				Iterator<WebElement> hnItr = hospitalNames.iterator();
				i=0;
				while (hnItr.hasNext()) {
					WebElement ob = hnItr.next();
						if (ratingsFloat[i] > 3.5) {
							System.out.println(ob.getText());
						}
						i++;
				}
			}
			
		    @Test(priority=6)
			public void close() {
				closeBrowser();
			}
	
}