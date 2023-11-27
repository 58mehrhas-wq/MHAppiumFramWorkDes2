package org.MehrdadHassani.pageObjects.android;

import org.MehrdadHassani.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Moohoos ololey");
	
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
	

	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
//	driver.findElement(By.id("android:id/text1")).click();
//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"));
//	driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	@SuppressWarnings("deprecation")
	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);		
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("female"))
			femaleOption.click();
		else 
			maleOption.click();
	}
	
	public void setCountrySelection(String countryName)
	{
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public ProductCatalog submitForm()
	{
		shopButton.click();
		return new ProductCatalog(driver);
	}
	
	

}
