package com.merchant.ui.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.merchant.ui.TestBase;

public class UserSearchPage extends TestBase{
	
	
	private static final String RESULT_DATE_FORMAT = "MMMM dd, yyyy HH:mm";
	private static final String SEARCG_DATE_FORMAT = "yyyy-MM-dd";
	
    protected WebDriverWait wait; 
 
    
    @FindBy(xpath = "//*[@id=\"q_username_input\"]/select")
	WebElement userNameSelect;
	
	
	@FindBy(xpath = "//*[@id=\"q_username\"]")
	WebElement userNameText;
	
	
    @FindBy(xpath = "//*[@id=\"q_email_input\"]/select")
	WebElement emailSelect;
	
	
	@FindBy(xpath = "//*[@id=\"q_email\"]")
	WebElement emailText;
	
	
	@FindBy(xpath = "//*[@id=\"new_q\"]/div[4]/input[1]")
	WebElement filterButton;
	
	@FindBy(xpath = "//*[@id=\"index_table_users\"]")
	WebElement userTable;
	
	
	@FindBy(xpath = "//*[@id=\"new_q\"]/div[4]/a")
	WebElement clearFilterButton;
	
	
	@FindBy(xpath = "//*[@id=\"q_created_at_gteq_datetime\"]")
	WebElement fromDate;
	
	@FindBy(xpath = "//*[@id=\"q_created_at_lteq_datetime\"]")
	WebElement toDate;	

	
	public UserSearchPage() {
		PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,20);
	}
	
	
	public boolean searchByUserName(String selectValue, String searchText) {
		
		Select userSelect = new Select(userNameSelect);
		userSelect.selectByValue(selectValue);
		userNameText.sendKeys(searchText);
		filterButton.submit();
				
        List<WebElement>  userNames = driver.findElements(By.xpath("//*[@id=\"index_table_users\"]/tbody/tr/td[3]")); 
        return searchCorrectUsersfound(userNames, searchText);
	}
	
	public boolean searchByEmail(String selectValue, String searchText) {
		
		Select userSelect = new Select(emailSelect);
		userSelect.selectByValue(selectValue);
		emailText.sendKeys(searchText);
		filterButton.submit();
				
        List<WebElement>  userNames = driver.findElements(By.xpath("//*[@id=\"index_table_users\"]/tbody/tr/td[4]")); 
        return searchCorrectUsersfound(userNames, searchText);
	}
	
	public boolean searchByFromDate(String searchText) {
		
        SimpleDateFormat searchSdf = new SimpleDateFormat(SEARCG_DATE_FORMAT);
        Date searchDate;
		try {
			searchDate = searchSdf.parse(searchText);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		fromDate.sendKeys(searchText);
		filterButton.submit();
				
        List<WebElement>  datesSearchResult = driver.findElements(By.xpath("//*[@id=\"index_table_users\"]/tbody/tr/td[5]")); 
        boolean usernamesFound= datesSearchResult !=null && datesSearchResult.size() >0;
        SimpleDateFormat resultSdf = new SimpleDateFormat(RESULT_DATE_FORMAT);

        try {
			for(WebElement element: datesSearchResult) {
				Date date = resultSdf.parse(element.getText()) ;
				if(! date.after(searchDate)) {
					usernamesFound = false;
					break;
				}
			}
		} catch (ParseException e) {
			usernamesFound = false;
		}
       
        return usernamesFound;
	}
	
	
	
	public boolean searchByToDate(String searchText) {
		
        SimpleDateFormat searchSdf = new SimpleDateFormat(SEARCG_DATE_FORMAT);
        Date searchDate;
		try {
			searchDate = searchSdf.parse(searchText);
		} catch (ParseException e1) {
			e1.printStackTrace();
			return false;
		}

						
		toDate.sendKeys(searchText);
		filterButton.submit();
				
        List<WebElement>  datesSearchResult = driver.findElements(By.xpath("//*[@id=\"index_table_users\"]/tbody/tr/td[5]")); 
        boolean usernamesFound= datesSearchResult !=null && datesSearchResult.size() >0;
        SimpleDateFormat resultSdf = new SimpleDateFormat(RESULT_DATE_FORMAT);
    
        try {
			for(WebElement element: datesSearchResult) {
				Date date = resultSdf.parse(element.getText()) ;
				if(! date.before(searchDate)) {
					System.out.println(date +", "+searchDate);
					usernamesFound = false;
					break;
				}
			}
		} catch (ParseException e) {
			usernamesFound = false;
		}
               
        return usernamesFound;
	}
	
	
	
	public void clearFilters() {
        clearFilterButton.click();

	}
	
	
	
	private boolean searchCorrectUsersfound(List<WebElement> columnDataList, String searchText) {
        boolean usernamesFound= columnDataList !=null && columnDataList.size() >0;
        
        for(WebElement element: columnDataList) {
        	if(!element.getText().contains(searchText)) {
        		usernamesFound = false;
        		break;
        	}
        }
        
        return usernamesFound;
	}

}
