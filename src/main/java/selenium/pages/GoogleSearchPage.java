package selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.driver.WebDriverUtility;
import selenium.driver.WebDriverWrapper;

public class GoogleSearchPage extends WebDriverWrapper {

	@FindBy(how = How.NAME, using="q") private WebElement txtQuery;
	
	public GoogleSearchPage() {
		PageFactory.initElements(driver, this);
		
		driver.get("https://www.google.com/");				
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Before you continue pop-up
		try {		
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//span[text()='I agree']")).click();
			driver.switchTo().defaultContent();
		}
		catch(Exception e) {
			System.out.println("GoogleSearchPage Exception: " + e.getMessage());
		}
	}
	
	public GoogleResultsPage enterGoogleSearch() {
		txtQuery.sendKeys("AODocs", Keys.ENTER);
		return new GoogleResultsPage();		
	}	
}
