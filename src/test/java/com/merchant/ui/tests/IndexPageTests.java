package com.merchant.ui.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merchant.ui.TestBase;
import com.merchant.ui.pages.IndexPage;
import com.merchant.ui.pages.UserPage;

public class IndexPageTests extends TestBase {
	
	private IndexPage indexPage;
	
	@BeforeMethod
	public void beforeClass(ITestContext context) {
		indexPage = new IndexPage();
		driver.get(baseUrl);
	}
	
	@Test
	public void testIndexPage() {
		String homePageTitle = indexPage.getTitle();
		Assert.assertEquals(homePageTitle, "Dashboard | Active Admin Depot");
		indexPage.clickOnUserTab();
	}

}
