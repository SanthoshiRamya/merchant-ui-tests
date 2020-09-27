package com.merchant.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.merchant.ui.TestBase;
import com.merchant.ui.pages.IndexPage;

public class IndexPageTests extends TestBase {
	
	private IndexPage indexPage;
	
	@BeforeClass
	public void beforeClass() {
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
