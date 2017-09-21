
import java.util.concurrent.TimeUnit;



import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import general.General;

public class LoginTestCase {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://hrm.seleniumminutes.com";
		//baseUrl = "http://hrm-online.portnov.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
    
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	

	@Test
	public void test_valid() {
		
		General.login(driver,"admin","Password");
		/*driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Password");
		driver.findElement(By.id("btnLogin")).click();*/
		driver.findElement(By.id("welcome")).click();
		//sleep(1);
		//driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.xpath("//a[@href='/symfony/web/index.php/auth/logout']")).click();
		sleep(1);
		assertEquals("http://hrm.seleniumminutes.com/symfony/web/index.php/auth/login", driver.getCurrentUrl());
		
		
		
	/*	String actualResult = driver.findElement(By.id("welcome")).getText();
		assertEquals("Welcome Admin", actualResult);*/
		
		
		

	}

	//@Test
	public void test_invalid() {
		
		General.login(driver,"admin","12345");

		/*driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("12345");
		driver.findElement(By.id("btnLogin")).click();*/
		String actualResult = driver.findElement(By.id("spanMessage")).getText();
		assertEquals("Invalid credentials", actualResult);
	}
	
	
	
	
	//@Test
	public void test_invalidUsername() {
		String expected="Invalid credentials";
		String invalid="abcde";
		General.login(driver,invalid,"Password");

		/*driver.findElement(By.id("txtUsername")).sendKeys(invalid);
		driver.findElement(By.id("txtPassword")).sendKeys("password");
		driver.findElement(By.id("btnLogin")).click();*/
		String actualResult = driver.findElement(By.id("spanMessage")).getText();
		
		String message="Expected to see '" + expected + "' but got '" + actualResult + "' instead";
		
		assertEquals(message,expected, actualResult);
	}
	
	//@Test
	public void test_EmptyUsername() {
		String expected="Username cannot be empty";
		General.login(driver,"","Password");

		
	/*	driver.findElement(By.id("txtUsername")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("password");
		driver.findElement(By.id("btnLogin")).click();*/
		String actualResult = driver.findElement(By.id("spanMessage")).getText();
		
		String message="Expected to see '" + expected + "' but got '" + actualResult + "' instead";
		
		assertEquals(message,expected, actualResult);
	}
	
	//@Test
	public void test_invalid_EmptyPassword() {
		
		General.login(driver,"admin","");

		
		/*driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();*/
		String actualResult = driver.findElement(By.id("spanMessage")).getText();
		assertEquals("Password cannot be empty", actualResult);
	}
	
	
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
