package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	
	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		
		dashboard.navigateToAddEmployee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and_(String fName, String mName, String lName) {
		
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		empId = addEmp.empId.getText();
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String fName, String mName, String lName) {
	
		Assert.assertTrue("Not Created", pdetails.personalDetailsText.isDisplayed());
	}

	@When("I click Save")
	public void i_click_Save() {
		
		addEmp.saveBtn.click();
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {
		
		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(), empId);
	}

	@When("I delete employee id")
	public void i_delete_employee_id() {
		
		addEmp.empId.clear();

	}

	@Then("I see employee without employee id is being added")
	public void i_see_employee_without_employee_id_is_being_added() {
		
		Assert.assertTrue("Employee not added", pdetails.personalDetailsText.isDisplayed());
	}

	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
		
		Assert.assertTrue("Required message not displayed", addEmp.fNErrorMsg.isDisplayed());
		Assert.assertTrue("Required message not displayed", addEmp.lNErrorMsg.isDisplayed());

	}

	@When("I click on create login checkbox")
	public void i_click_on_create_login_checkbox() {
		
		addEmp.createLoginDetails.click();

	}

	@When("I enter {string}, {string} and confirm {string}")
	public void i_enter_username_password_and_confirm_password(String username, String userPassword,
			String confirmUserPassword) {
		
		sendText(addEmp.username, username);
		sendText(addEmp.userPassword, userPassword);
		sendText(addEmp.confirmUserPassword, confirmUserPassword);

	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {
		List<Map<String, String>> empDetailList = empDetails.asMaps();
		for (Map<String, String> map : empDetailList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
		}
	}

	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetail) {
		List<Map<String, String>> modifyList = modifyEmpDetail.asMaps();
		
		for (Map<String, String> map : modifyList) {
			// click on edit
			click(pdetails.edit_saveBtn);
			sendText(pdetails.licenNo, map.get("DriverLicense"));
			sendText(pdetails.licExpDate, map.get("ExpirationDate"));
			sendText(pdetails.SSN, map.get("SSN"));
			sendText(pdetails.SIN, map.get("SIN"));
			clickRadio(pdetails.genderLabel, map.get("Gender"));
			selectDdValue(pdetails.maritalStatus, map.get("MaritalStatus"));
			selectDdValue(pdetails.nationality, map.get("Nationality"));
			sendText(pdetails.DOB, map.get("DOB"));
			// click on save
			click(pdetails.edit_saveBtn);
		}

	}

	@When("I click on Edit")
	public void clickOnEdit_SaveButton() {
		click(pdetails.edit_saveBtn);
	}
}
