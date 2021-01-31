package selenium.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverWrapper {
	protected static WebDriver driver;	
	
	public void initDriver(Browser browser) {
		System.out.println("SETTING DRIVER!!!!");
		driver = WebDriverUtility.getWebDriver(browser);
		System.out.println("DRIVER: " + driver.toString());
	}
	
	public void closeDriver() {
		WebDriverUtility.closeWebDriver(driver);
	}	
	
}
