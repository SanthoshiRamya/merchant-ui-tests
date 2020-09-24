package com.merchant.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.merchant.ui.TestBase;

public class IndexPage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"users\"]/a")
	WebElement userTablink;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public UserPage clickOnUserTab() {
		userTablink.click();
		return new UserPage();
	}
	


}
