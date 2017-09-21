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

public class POMTestCase {
	private WebDriver driver;
	private LoginPage loginPage;
	private DashBoardPage dashBoardPage;
	private AssignLeavePage assignLeavePage;
	private LocalizationPage localizationPage;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		// System.setProperty("webdriver.Chrome.driver", "Chrome.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		assignLeavePage = new AssignLeavePage(driver);
		localizationPage = new LocalizationPage(driver);
		baseUrl="http://hrm.seleniumminutes.com/symfony/web/index.php/auth/login";
		driver.get(baseUrl);
		String username = "admin";
		String password = "Password";
		loginPage.login(username, password);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
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
