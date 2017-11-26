package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import general.GetProperties;
import menues.MainMenu;
import pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected MainMenu mainMenu;
	protected LoginPage loginPage;
	private static Integer explicitWait;
	
	
	@BeforeClass
	public static void baseSetUpClass() throws IOException {
		GetProperties prop=new GetProperties();
		explicitWait = Integer.valueOf(prop.getProperty("explicitWait"));
		
		
	}
	
	
	@Before
	public void baseSetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\lib\\chromedriver2.exe");
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,explicitWait);
		mainMenu=new MainMenu(driver);
		loginPage=new LoginPage(driver);
		loginPage.gotoPage();
		
	}

	@After
	public void baseTearDown() throws Exception {
		driver.quit();
	}

}
