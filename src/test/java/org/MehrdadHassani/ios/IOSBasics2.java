package org.MehrdadHassani.ios;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.MehrdadHassani.TestUtils.IOSBaseTest;
import org.MehrdadHassani.pageObjects.ios.AlertViews;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics2 extends IOSBaseTest{
	
	// This test is with UiKitCatalog App
	@Test
	public void IOSBasicTest2() throws InterruptedException
	{
		
				AlertViews alertViews = homePage.selectAlertViews();				
				
				alertViews.fillTextLabel("Bonjour mon fidèle ami");
				
				String actualMessage = alertViews.getConfirmMessage();			
				
				AssertJUnit.assertEquals(actualMessage, "A message should be a short, complete sentence.");
		
		
		
		
	}	

}
