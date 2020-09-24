package com.merchant.ui.tests.filter.json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class DataProviders {

	private static final Random random = new Random();
	private static final Faker faker = new Faker();
	private static final int dateMin = 2;
	private static final int dateMax = 5;
	private static final FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
			new RandomService(random));

	private static final List<User> usersList = Collections.synchronizedList(new ArrayList<User>());

	@DataProvider(name = "user-search-provider")
	public Object[][] createDataProvider(ITestContext context) throws Exception {

		List<List<SearchCriteria>> criterias = getSearchTestCases();

		Object[][] providerData = new Object[1][1];
		
		providerData[0][0] = getSearchTestCases();
		
		return providerData;
	}

	private List<List<SearchCriteria>> getSearchTestCases() {
		List<List<SearchCriteria>> testCases = new ArrayList<List<SearchCriteria>>();
		for (User user : usersList) {
			testCases.add(getSearchCriteria(user));
		}
		return testCases;

	}

	private List<SearchCriteria> getSearchCriteria(User user) {

		String[] userSelectValues = new String[] { "username_contains", "username_equals", "username_equals",
				"username_starts_with", "username_ends_with" };
		String[] emailSelectValues = new String[] { "email_contains", "email_equals", "email_equals",
				"email_starts_with", "email_ends_with" };
		List<SearchCriteria> criteria = new ArrayList<SearchCriteria>();

		for (int i = 0; i < userSelectValues.length; i++) {
			criteria.add(new SearchCriteria(userSelectValues[i], getSubString(user.getUserName(), userSelectValues[i]),
					"USERNANE_FILTER"));

			for (int j = 0; j < emailSelectValues.length; j++) {
				criteria.add(new SearchCriteria(emailSelectValues[j],
						getSubString(user.getEmail(), emailSelectValues[j]), "EMAIL_FILTER"));

			}
			criteria.add(new SearchCriteria("NA", getRandomDate(user.getGeneratedAt(), false), "FROM_DATE_FILTER"));
			criteria.add(new SearchCriteria("NA", getRandomDate(user.getGeneratedAt(), true), "TO_DATE_FILTER"));
		}

		return criteria;

	}

	public static User getAFakeUser() {
		String email = fakeValuesService.bothify("????##@interviewTesting.com");
		User user = new User(faker.superhero().prefix() + faker.name().firstName() + faker.address().buildingNumber(),
				email, RandomStringUtils.randomAlphabetic(10), new Date());
		usersList.add(user);
		return user;
	}

	private String getSubString(String value, String criteria) {
		if (criteria.contains("equals")) {
			return value;
		} else if (criteria.contains("starts")) {
			return value.substring(0, 5);
		} else if (criteria.contains("ends")) {
			return value.substring(value.length() - 5, value.length());
		} else if (criteria.contains("contains")) {
			return value.substring(1, 5);
		}
		return null;
	}

	private String getRandomDate(Date date, boolean positive) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getRandomNumber(positive));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}

	private int getRandomNumber(boolean positive) {
		int rn = random.nextInt(dateMax - dateMin + 1) + dateMin;
		if (!positive)
			rn = rn * -1;
		return rn;
	}

}
