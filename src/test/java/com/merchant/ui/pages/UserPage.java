package com.merchant.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.merchant.ui.TestBase;

public class UserPage extends TestBase{
	
    protected WebDriverWait wait; 

	
	
	@FindBy(xpath = "//*[@id=\"titlebar_right\"]/div/span/a")
	WebElement newUserButton;
	
	
	
	public UserPage() {
		PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,20);

	}

	
	public String getTitle(){
		return driver.getTitle();
	}
	
	
	public NewUserPage clickOnNewUserButton() {
        //wait.until(ExpectedConditions.visibilityOf(newUserButton)).click();
        newUserButton.click();
        wait.until(ExpectedConditions.titleContains("New User"));
        return new NewUserPage();
	}
}
