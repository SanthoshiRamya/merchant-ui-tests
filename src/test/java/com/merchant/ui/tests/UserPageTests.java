package com.merchant.ui.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merchant.ui.TestBase;
import com.merchant.ui.pages.UserPage;

public class UserPageTests extends TestBase {
	
	private UserPage userPage;
	
	@BeforeMethod
	public void beforeClass(ITestContext context) {
		userPage = new UserPage();
	}
	
	
	@Test
	public void testIndexPage() {
		String title = userPage.getTitle();
		Assert.assertEquals(title, "Users | Active Admin Depot");
		userPage.clickOnNewUserButton();
	}

}
