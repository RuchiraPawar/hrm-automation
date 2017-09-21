import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminConfigLocalizationTest {
	private WebDriver driver;
	private String baseUrl;
   
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.Chrome.driver", "Chrome.exe");
		driver = new ChromeDriver();
		baseUrl = "http://hrm.seleniumminutes.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
    
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test_valid() {
		 WebDriverWait wait= new WebDriverWait(driver,5);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Password");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Configuration")).click();
		driver.findElement(By.id("menu_admin_localization")).click();
		sleep(2);
	
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("localization_dafault_language")).click();
		Select dropdown = new Select(driver.findElement(By.id("localization_dafault_language")));
        dropdown.selectByValue("zh_CN");
		driver.findElement(By.id("btnSave")).click();
		
		sleep(2);
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("localization_dafault_language")).click();
		Select dropdown1 = new Select(driver.findElement(By.id("localization_dafault_language")));
        dropdown1.selectByValue("en_US");
		driver.findElement(By.id("btnSave")).click();
       // sleep(1);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("message success fadable")));
		//String message=driver.findElement(By.className("message success fadable")).getText();
		//System.out.println(message);
		
		
	/*	String actualResult = driver.findElement(By.id("welcome")).getText();
		assertEquals("Welcome Admin", actualResult);*/
		
		
		
	}
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
