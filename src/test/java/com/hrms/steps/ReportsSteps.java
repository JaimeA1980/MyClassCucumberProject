package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.ReportsPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsSteps extends CommonMethods{
	
	
	
	@Given("I navigated to the Reports Page")
	public void i_navigated_to_the_Reports_Page() {
		
		dashboard.navigateToReports();

	}

	@When("I enter invalid report {string}")
	public void i_enter_invalid_report(String invalidReport) {
		reports=new ReportsPageElements();
		reports.reportSearch.sendKeys(invalidReport);
	}

	@When("I click search button")
	public void i_click_search_button() {
		reports=new ReportsPageElements();
		click(reports.searchBtn);
	}

	@Then("I see no record found message")
	public void i_see_no_record_found_message() {
		reports=new ReportsPageElements();
		Assert.assertTrue("No such message displayed", reports.noResultMsg.isDisplayed());
		
	}

	@When("I enter valid report {string}")
	public void i_enter_valid_report(String actualReport) {
		reports=new ReportsPageElements();
		reports.reportSearch.sendKeys(actualReport);
		
	}

	@Then("I see the search report is displayed")
	public void i_see_the_search_report_is_displayed() {
		reports=new ReportsPageElements();
		Assert.assertTrue("Report not found", reports.validReport.isDisplayed());

	}



}
