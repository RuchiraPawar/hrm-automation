package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;

	@Before
	public void baseSetUp() throws Exception {
		System.setProperty("webdriver.Chrome.driver", "Chrome.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		loginPage.gotoPage();
		
	}

	@After
	public void baseTearDown() throws Exception {
		driver.quit();
	}

}
