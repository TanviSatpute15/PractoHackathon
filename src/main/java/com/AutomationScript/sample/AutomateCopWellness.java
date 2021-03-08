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

//Capturing the warning message for invalid details
public class AutomateCopWellness extends BaseUI {
	int itemCount = 0;
	String searchPageId, itemPageId;

@Parameters("browser")
	@Test(priority=1)
		public void OpenBrowser(String browser) throws IOException
		
		{
			openBrowserAndNavigateToPracto(browser);
				
		}

         @Test(priority=2)
		public void provider() {
			
			clickElement("Provider_xpath");
		}


        @Test(priority=3)
		public void copwell()
		{
			new WebDriverWait(driver, 50).until(ExpectedConditions
					.visibilityOfElementLocated(By.partialLinkText(prop.getProperty("co_partialLinkText"))));
			clickElement("co_partialLinkText");
		}
		
        @Test(priority=4)
		public void newwindow()
		{
			Set <String> windowIDs =driver.getWindowHandles();
			Iterator <String> itr = windowIDs.iterator();
			String mainpage=itr.next();
			String nextpage=itr.next();
			driver.switchTo().window(nextpage);
		}
		
        @Test(priority=5)
		public void enterdetails()
		{
			enterText("name_id", "uytr4r566");
			enterText("org_id", "ere3332");
			enterText("offemail_id","wwwweeee2222");
			enterText("offphn_id","rree2222666");
			clickElement("submit_id");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
        @Test(priority=6)
		public void alertBox()
		{
	        Alert alt = driver.switchTo().alert();	   
			System.out.println(alt.getText());
		
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
				  
				alt.accept();
		}
		
        @Test(priority=7)
		public void close()
		{
		    closeBrowser();
	}
}
		
		
		
		
		
		
	
