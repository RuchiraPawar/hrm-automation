package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

public class POMTestCase extends AdminLogin {

	private DashBoardPage dashBoardPage;
	private AssignLeavePage assignLeavePage;
	private LocalizationPage localizationPage;

	@Before
	public void setUp() throws Exception {
		dashBoardPage = new DashBoardPage(driver);
		assignLeavePage = new AssignLeavePage(driver);
		localizationPage = new LocalizationPage(driver);
		login();
	}

	@Test
	public void validLoginTest() {

		By locator = By.cssSelector(".head > h1:nth-child(1)");
		String actualPage = dashBoardPage.getHeader(locator);
		assertEquals("Dashboard", actualPage);
		String actual = dashBoardPage.getGreeting();

		assertEquals("Welcome Admin", actual);

	}

	@Test
	public void quickLaunchTest() {
		By locator = By.xpath("//span[@class='quickLinkText' and contains(text(),'Assign Leave')]");
		dashBoardPage.launch("Assign Leave");
		String actual = assignLeavePage.getHeader(locator);

		assertEquals("Assign Leave", actual);

	}

	@Test
	public void configLocalization() throws InterruptedException {
		By locator = By.id("localizationHeading");
		localizationPage.adminClick();
		String actual = localizationPage.getHeader(locator);

		assertEquals("Localization", actual);

	}

}
