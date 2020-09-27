package com.merchant.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.merchant.ui.TestBase;
import com.merchant.ui.pages.UserPage;

public class UserPageTests extends TestBase {
	
	private UserPage userPage;
	
	@BeforeClass
	public void beforeClass() {
		userPage = new UserPage();
	}
	
	
	@Test
	public void testUserPage() {
		String title = userPage.getTitle();
		Assert.assertEquals(title, "Users | Active Admin Depot");
		userPage.clickOnNewUserButton();
	}

}
