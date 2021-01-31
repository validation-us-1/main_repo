package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.driver.WebDriverWrapper;

public class GoogleResultsPage extends WebDriverWrapper {

	@FindBy(how = How.XPATH, using="//a[@href='https://www.aodocs.com/']") 
	private WebElement lnkAODocs;
	
	GoogleResultsPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public AODocsHomePage clckAODocsLink() {
		lnkAODocs.click();
		return new AODocsHomePage();
	}
	
}
