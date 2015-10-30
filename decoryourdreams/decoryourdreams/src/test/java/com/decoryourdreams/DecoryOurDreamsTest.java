package com.decoryourdreams;

import hms.store.webapp.commom.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class DecoryOurDreamsTest {

	Browser browser;
	WebDriver driver;
	WebElement element;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "url", "browserType" })
	public void setUp(String url, String browserType) {
		// initialize the Browser class
		browser = new Browser();
		// start the Browser
		driver = browser.startApplication(url, browserType);

	}

	@Test
	public void checkSiteStatus() {
		String getTitleValue = driver.getTitle().toString();
		System.out.println("Title = " + getTitleValue);
		Assert.assertTrue(getTitleValue.equals("Welcome"), "Site is up and running.");
		Reporter.log("Site is up and running.");
	}

	@Test
	public void checkAllMenus() throws InterruptedException {
		element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[22]/div/ul/li[1]/a"));
		element.click();
		String getTitleValueWelcome = driver.getTitle().toString();
		System.out.println("Title = " + getTitleValueWelcome);
		Assert.assertTrue(getTitleValueWelcome.equals("Welcome"), "Welcome Menu page is working fine.");
		Reporter.log("Welcome Menu page is working fine.");

		Thread.sleep(3000);
		element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[22]/div/ul/li[2]/a"));
		element.click();
		String getTitleValueAboutUs = driver.getTitle().toString();
		System.out.println("Title = " + getTitleValueAboutUs);
		Assert.assertTrue(getTitleValueAboutUs.equals("About Us"), "About Us Menu page is working fine.");
		Reporter.log("About Us Menu page is working fine.");

		Thread.sleep(3000);
		element = driver.findElement(By.linkText("CONTACT US"));
		element.click();
		String getTitleValueContactUs = driver.getTitle().toString();
		System.out.println("Title = " + getTitleValueContactUs);
		Assert.assertTrue(getTitleValueContactUs.equals("Contact Us"), "Contact Us Menu page is working fine.");
		Reporter.log("Contact Us Menu page is working fine.");

		Thread.sleep(3000);
		element = driver.findElement(By.linkText("HIDDEN FACTS"));
		element.click();
		String getTitleValueHiddenFacts = driver.getTitle().toString();
		System.out.println("Title = " + getTitleValueHiddenFacts);
		Assert.assertTrue(getTitleValueHiddenFacts.equals("Hidden Facts"), "Hidden Facts Menu page is working fine.");
		Reporter.log("Hidden Facts Menu page is working fine.");
	}

	@Test
	public void checkContactUsEmail() throws InterruptedException {
		
		Thread.sleep(3000);
		element = driver.findElement(By.linkText("CONTACT US"));
		element.click();
		String getTitleValueContactUs = driver.getTitle().toString();
		System.out.println("Title = " + getTitleValueContactUs);
		Assert.assertTrue(getTitleValueContactUs.equals("Contact Us"), "Contact Us Menu page is working fine.");
		Reporter.log("Contact Us Menu page is working fine.");

		driver.findElement(By.name("name")).sendKeys("QA Automation");
		driver.findElement(By.name("email")).sendKeys("orsreddy@gmail.com");
		driver.findElement(By.name("subject")).sendKeys("QA automation testing");
		driver.findElement(By.name("message")).sendKeys("QA automation testing and validating email service.");
		driver.findElement(By.className("form-submit")).click();

		Thread.sleep(3000);
		Assert.assertTrue(
				driver.findElement(By.className("form-message")).getText()
						.equals("Thank you for contacting us! If needed, you will hear back within 48-72 hours."),
				"Email service working fine.");
		Reporter.log("Email service working fine.");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
