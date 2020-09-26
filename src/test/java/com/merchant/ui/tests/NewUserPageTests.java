package com.merchant.ui.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merchant.ui.TestBase;
import com.merchant.ui.pages.NewUserPage;
import com.merchant.ui.tests.data.DataProviders;
import com.merchant.ui.tests.data.User;


public class NewUserPageTests extends TestBase {
	
	private NewUserPage newUserPage;
	
	@BeforeMethod
	public void beforeClass(ITestContext context) {
		newUserPage = new NewUserPage();
	}
	
	
	@Test
	public void testPageTitle() {
		String title = newUserPage.getTitle();
		Assert.assertEquals(title, "New User | Active Admin Depot");
		User user = DataProviders.getAFakeUser();
		newUserPage.enterInformation(user);
		Assert.assertEquals(newUserPage.verifyUserCreated(), true);
		
		newUserPage.clickOnUserTab();

	}

}
