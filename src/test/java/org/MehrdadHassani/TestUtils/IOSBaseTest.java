package org.MehrdadHassani.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.MehrdadHassani.pageObjects.ios.HomePage;
import org.MehrdadHassani.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class IOSBaseTest extends AppiumUtils{
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public HomePage homePage;
	
	@BeforeClass
	public void ConfigureAppium() throws IOException
	{
//		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//org//MehrdadHassani//resources//data.properties");
		
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		// This comes directly from AppiumUtils
//		service = startAppiumServer();

//AndroidDriver, IOSDriver
// Creating AndroidDriver object class
// Appium code -> Appium Server -> Mobile


		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15 Pro Max");
//		options.setApp("//Users/mehrdadfhassani//eclipse-workspace//Appium4//src/test//java//resources//TestApp 3.app");
		options.setApp("//Users//mehrdadfhassani//Desktop//UIKitCatalog.app");
		options.setPlatformVersion("17.0");
		//Appium - Webdriver Agent -> IOS Apps.
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));


		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		homePage = new HomePage(driver);
		
		
	}
	
	
	
	@AfterMethod
	@AfterClass
	public void tearDown()
	{
		driver.quit();
//		service.stop();
	}

}



