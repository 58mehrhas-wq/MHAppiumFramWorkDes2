package org.MehrdadHassani.pageObjects.android;

import java.util.List;

import org.MehrdadHassani.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	
	AndroidDriver driver;
	
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
//	driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
//	driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
//	driver.findElement(By.id("android:id/button1"))
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
//	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
//	driver.findElement(AppiumBy.className("android.widget.CheckBox"))
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;

	
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public double getProductsSum()
	{
		int count = productList.size();
		
		double totalSum = 0 ;
		
		for(int i=0; i<count; i++) 
		{
			String amountString = productList.get(i).getText();
			// $160.07
			Double price = getFormattedAmount(amountString);
			
			totalSum = totalSum + price; // 160.97 + 120 = 280.97			
			
			
		}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed()
	{
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions()
	{
		longPressAction(terms);
		acceptButton.click();
	}
	

	
	public void submitOrder()
	{
		checkBox.click();
		proceed.click();
	}
	

}
