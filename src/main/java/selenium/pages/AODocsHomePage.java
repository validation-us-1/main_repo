package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.driver.WebDriverWrapper;

public class AODocsHomePage extends WebDriverWrapper {

	@FindBy(how = How.LINK_TEXT, using = "Request a demo")
	private WebElement lnkReqDemo;
	
	@FindBy(how = How.ID, using = "ccc-notify-accept")
	private WebElement btnAcceptCoockie;

	public AODocsHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public AODocsHomePage clckAcceptCoockie() {
		try {
			Thread.sleep(2000);
			btnAcceptCoockie.click();
		} catch (InterruptedException e) {
			System.out.println("AODocsHomePage Exception: " + e.getMessage());
		}
		return this;
	}
	
	public AODocsContactPage clckReqDemo() {		
		lnkReqDemo.click();
		return new AODocsContactPage();
	}	
	
}
