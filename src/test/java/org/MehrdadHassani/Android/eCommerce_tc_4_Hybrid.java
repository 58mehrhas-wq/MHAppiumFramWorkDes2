package org.MehrdadHassani.Android;





import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.MehrdadHassani.TestUtils.AndroidBaseTest;
import org.MehrdadHassani.pageObjects.android.CartPage;
import org.MehrdadHassani.pageObjects.android.FormPage;
import org.MehrdadHassani.pageObjects.android.ProductCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest{
	
	@Test(dataProvider = "getData")
//	public void FillForm(String name, String gender, String country) throws InterruptedException
	public void FillForm(HashMap<String, String> input) throws InterruptedException
	{
		// Since the following method is added in the BaseTest, it's not required to have it here!
//		FormPage formPage = new FormPage(driver);
		
		formPage.setNameField(input.get("name"));
		
		formPage.setGender(input.get("gender"));
		
		formPage.setCountrySelection(input.get("country"));
		
		ProductCatalog productcatalog = formPage.submitForm();
		
		
		// The following method is not required after changing the above line to include ProductCatalog		
//		ProductCatalog productCatalog = new ProductCatalog(driver);
		
		productcatalog.addItemToCartByIndex(0);
		productcatalog.addItemToCartByIndex(0);
		
		CartPage cartPage =productcatalog.goToCartPage();
		

		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		
		Thread.sleep(3000);
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		
		cartPage.acceptTermsConditions();
	
		
		cartPage.submitOrder();
		
		

//		Thread.sleep(2000);		
////		
////		
////		// Hybrid - Google page
//		Set<String> contexts = driver.getContextHandles();
//		
//		for(String contextName: contexts)
//		{
//			System.out.println(contextName);
//		}	
		

		
	}
	
//	@BeforeMethod
//	public void preSetup()
//	{
//		formPage.setActivity();
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//MehrdadHassani//Android//testData//eCommerce.json");
//		return new Object [] [] {  {"Ooh la la", "female", "Austria"}  };
		return new Object [] [] {  {data.get(0)} };
	}
	
	// key-name, value Ooh la la

}
