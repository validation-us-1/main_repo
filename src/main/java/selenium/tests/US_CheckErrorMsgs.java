package selenium.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import selenium.driver.*;
import selenium.pages.GoogleSearchPage;
import selenium.pages.GoogleResultsPage;

public class US_CheckErrorMsgs extends WebDriverWrapper {
	
	@ParameterizedTest
	@EnumSource(selenium.driver.Browser.class)
	void testCase(Browser browser) {
		initDriver(browser);
				
		try {		
			System.out.println("BROWSER: " + driver.getClass().getSimpleName());
			
			ArrayList<String> err = (ArrayList<String>) new GoogleSearchPage()
			.enterGoogleSearch()
			.clckAODocsLink()
			.clckAcceptCoockie()
			.clckReqDemo()
			.enterFirstName()
			.enterLastName()
			.enterEmail()
			.selectCompanySize()
			.clickSubmit().getErrors();
			
//			System.out.println("Errors on Submit: " + err.size());
//			
//			for(int i = 0; i < err.size(); i++ ) {
//				System.out.println("Error " + i + ": " + err.get(i));
//			}
			
			Assertions.assertTrue(err.get(0).equalsIgnoreCase("Email must be formatted correctly."));
			Assertions.assertTrue(err.get(1).equalsIgnoreCase("Please complete this required field."));
			Assertions.assertTrue(err.get(2).equalsIgnoreCase("Please select an option from the dropdown menu."));
			Assertions.assertTrue(err.get(3).equalsIgnoreCase("Please complete this required field."));
			Assertions.assertTrue(err.get(4).equalsIgnoreCase("Please select an option from the dropdown menu."));
			
			Thread.sleep(1000);			
		} 
		catch(Exception e) {
			System.out.println("US_CheckErrorMsgs Exception: " + e.getMessage());
		}
		
		closeDriver();
	}
	
}
