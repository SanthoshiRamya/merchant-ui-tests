package com.merchant.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class TestBase {

    protected static WebDriver driver;
    
    protected static String baseUrl;
    
    @BeforeSuite
	public static void initialization(ITestContext context) {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        baseUrl =  context.getCurrentXmlTest().getParameter("BaseURI");

    }

	@AfterSuite
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
