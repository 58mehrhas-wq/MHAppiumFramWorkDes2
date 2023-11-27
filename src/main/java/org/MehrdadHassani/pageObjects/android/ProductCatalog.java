package org.MehrdadHassani.pageObjects.android;

import java.util.List;

import org.MehrdadHassani.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


// GrandParent(AppiumUtils) --> AndroidActions --> ProductCatalog
public class ProductCatalog extends AndroidActions{
	
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
//	driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
//	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	
	
	public ProductCatalog(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	}
	
	public CartPage goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}


}
