package hms.store.webapp.commom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	WebDriver driver;

	public WebDriver startApplication(String url, String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(url);
		}
		else if (browserType.equalsIgnoreCase("Chrome")) {
			System.out.println("No BrowerType defined. Running default Chrome Browser");
			System.setProperty("webdriver.chrome.driver","C:\\V9-Workspace\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
		}
		else {
			System.out.println("No BrowerType defined. Running default IE Browser");
			System.setProperty("webdriver.chrome.driver","C:\\V9-Workspace\\IEDriverServer.exe");
			driver = new ChromeDriver();
			driver.get(url);
		}
		return driver;
	}
	
	public boolean isElementPresent(By by) {
	    try {
	        driver.findElement(by);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

}
