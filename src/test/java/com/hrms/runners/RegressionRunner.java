package com.hrms.runners;

//make sure you use the io.cucumber imports
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features"     // /Login.feature"--this was there originally, left out to run through all glue path
		,glue = "com/hrms/steps"
		,dryRun = false
		,plugin = {"pretty", "html:target/html/cucumber-default-report"}
		,monochrome = true
		,tags = {"@regression"}
		)



public class RegressionRunner {
	

}
