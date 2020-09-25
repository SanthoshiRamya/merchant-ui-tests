package com.merchant.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.merchant.ui.TestBase;
import com.merchant.ui.tests.filter.json.User;

public class NewUserPage extends TestBase {

	protected WebDriverWait wait;

	@FindBy(xpath = "//input[@id=\"user_username\"]")
	WebElement usernameTextField;

	@FindBy(xpath = "//input[@id=\"user_password\"]")
	WebElement passwordTextField;

	@FindBy(xpath = "//input[@id=\"user_email\"]")
	WebElement emailTextField;

	@FindBy(xpath = "//*[@id=\"user_submit_action\"]/input")
	WebElement submitButton;
	
	@FindBy(css = "flash flash_notice")
	WebElement confirmationDiv;
	
	@FindBy(xpath = "//*[@id=\"users\"]/a")
	WebElement userTablink;

	public NewUserPage() {
		PageFactory.initElements(driver, this);
		driver.navigate().refresh();

		wait = new WebDriverWait(driver,30);

	}

	public String getTitle() {
		return driver.getTitle();
	}


	public void enterInformation(User user) {
		usernameTextField.sendKeys(user.getUserName());
		passwordTextField.sendKeys(user.getPassword());
		emailTextField.sendKeys(user.getEmail());
		submitButton.click();

	}
	
	public boolean verifyUserCreated() {
		String confirmationText = "User was successfully created";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + confirmationText + "')]"));
		return list.size() > 0;
	}
	
	
	public UserPage clickOnUserTab() {
		userTablink.click();
		return new UserPage();
	}
	

}
