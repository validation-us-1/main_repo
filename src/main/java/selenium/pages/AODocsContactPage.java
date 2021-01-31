package selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import selenium.driver.WebDriverWrapper;
import selenium.utils.RandomString;

public class AODocsContactPage extends WebDriverWrapper {

	@FindBy(how = How.NAME, using = "firstname")
	private WebElement txtFirstName;
	
	@FindBy(how = How.NAME, using = "lastname")
	private WebElement txtLastName;
	
	@FindBy(how = How.NAME, using = "email")
	private WebElement txtEmail;
	
	@FindBy(how = How.NAME, using = "company_size__c")
	private WebElement ddCompanySize;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	private WebElement btnSubmit;
	
	@FindBy(how = How.CLASS_NAME, using = "hs-error-msg")
	private List<WebElement> lblErrors;
	
	public AODocsContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AODocsContactPage enterFirstName() {
		txtFirstName.sendKeys("Foo");
		return this;
	}
	
	public AODocsContactPage enterLastName() {
		txtLastName.sendKeys("Bar");
		return this;
	}
	
	public AODocsContactPage enterEmail() {
		txtEmail.sendKeys(RandomString.generate());
		return this;
	}
	
	public AODocsContactPage selectCompanySize() {
		new Select(ddCompanySize).selectByVisibleText("0-4 employees");
		return this;
	}
	
	public AODocsContactPage clickSubmit() {
		btnSubmit.click();
		System.out.println("Errors on Submit: " + lblErrors.size());		
		return this;
	}
	
	public List<String> getErrors() {
		List<String> lstErrors = new ArrayList<String>();
		
		for(int i = 0; i < lblErrors.size(); i++ ) {
			lstErrors.add(lblErrors.get(i).getText());
		}
			
		return lstErrors;
	}
}
