package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ReportsPageElements extends CommonMethods {
	@FindBy(xpath="//input[@id='search_search']")
	public WebElement reportSearch;
	
	@FindBy(xpath = "//input[@class='searchBtn']")
	public WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td")
	public WebElement noResultMsg;
	
	@FindBy(id="frmList_ohrmListComponent")
	public WebElement validReport;
	
	public ReportsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
		
	}

}
