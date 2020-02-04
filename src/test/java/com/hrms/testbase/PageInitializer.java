package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ReportsPageElements;

public class PageInitializer extends BaseClass{
	
	protected static DashboardPageElements dashboard;
	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	protected static PersonalDetailsPageElements pdetails;
	protected static ReportsPageElements reports;
	
	public static void initializeAllPage() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp=new AddEmployeePageElements();
		pdetails=new PersonalDetailsPageElements();
		reports=new ReportsPageElements();
	}

}
