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
	

	@Before
	public void setUp() throws Exception {
		dashBoardPage = new DashBoardPage(driver);
		assignLeavePage = new AssignLeavePage(driver);
		
		login();
	}

	//@Test
	public void validLoginTest() {

		By locator = By.cssSelector(".head > h1:nth-child(1)");
		String actualPage = dashBoardPage.getHeader(locator);
		assertEquals("Dashboard", actualPage);
		String actual = dashBoardPage.getGreeting();

		assertEquals("Welcome Admin", actual);

	}

	//@Test
	public void quickLaunchTest() {
		By locator = By.xpath("//span[@class='quickLinkText' and contains(text(),'Assign Leave')]");
		dashBoardPage.launch("Assign Leave");
		String actual = assignLeavePage.getHeader(locator);

		assertEquals("Assign Leave", actual);

	}

	

}
