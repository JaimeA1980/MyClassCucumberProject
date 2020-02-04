package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps extends CommonMethods{
	


	@Given("I open browser and navigated to the HRMS")
	public void i_open_browser_and_navigated_to_the_HRMS() {
		setUp();
		
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
	
		sendText(login.username, "Admin");
		sendText(login.password, "Syntax@123");
		// could have been CommonMethods.sendtext but extended the class
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		System.out.println("I am logged in");
	}
	
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_username_and_invalid_password() {
		
		sendText(login.username, "Admin");
		sendText(login.password, "I am invalid");
	}

	@Then("I see error message")
	public void i_see_error_message() {
	   boolean error = login.errorMsg.isDisplayed();
	   Assert.assertTrue("Error message is not displayed", error);
	}
	
	@Then("I close browser")
	public void i_close_browser() {
		tearDown();
	}
	@When("I enter {string} and {string}")
	public void i_enter_and(String username, String password) {
		
		sendText(login.username, username);
		sendText(login.password, password);
	}
	@Then("I see {string}")
	public void i_see(String errorMsg) {
		
		boolean error = login.errorMsg.isDisplayed();
		Assert.assertTrue("Error message is not displayed", error);
	}

}
