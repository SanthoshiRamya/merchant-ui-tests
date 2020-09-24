package com.merchant.ui.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merchant.ui.TestBase;
import com.merchant.ui.pages.UserSearchPage;
import com.merchant.ui.tests.filter.json.DataProviders;
import com.merchant.ui.tests.filter.json.SearchCriteria;
import com.merchant.ui.tests.filter.types.FilterTypes;

public class UserSearchPageTests extends TestBase {

	private UserSearchPage userSearchPage;

	@BeforeMethod
	public void beforeClass(ITestContext context) {
		userSearchPage = new UserSearchPage();
	}

	@Test(dataProvider = "user-search-provider", dataProviderClass = DataProviders.class)
	public void runTest(List<List<SearchCriteria>> testCases) throws Exception {
		for (List<SearchCriteria> testcase : testCases) {
			for (SearchCriteria sc : testcase) {
				String selectValue = sc.getSelect();
				String text = sc.getText();
				System.out.println(sc);
				if (FilterTypes.USERNANE_FILTER.name().equals(sc.getType())) {
					boolean searchNamesFound = userSearchPage.searchByUserName(selectValue, text);
					Assert.assertTrue(searchNamesFound);
				} else if (FilterTypes.EMAIL_FILTER.name().equals(sc.getType())) {
					boolean searchNamesFound = userSearchPage.searchByEmail(selectValue, text);
					Assert.assertTrue(searchNamesFound);
				} else if (FilterTypes.FROM_DATE_FILTER.name().equals(sc.getType())) {
					boolean searchNamesFound = userSearchPage.searchByFromDate(text);
					Assert.assertTrue(searchNamesFound);
				} else if (FilterTypes.TO_DATE_FILTER.name().equals(sc.getType())) {
					boolean searchNamesFound = userSearchPage.searchByToDate(text);
					Assert.assertTrue(searchNamesFound);
				} else {
					throw new Exception("Unknown filter: " + sc.getType());
				}
				userSearchPage.clearFilters();
			}
			System.out.println("*****************\n");
		}
	}

}
