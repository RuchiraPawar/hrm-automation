import static org.junit.Assert.*;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import general.General;

public class LocatorsTest {
	
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
	public void test() {

     General.login(driver, "admin", "Password");
     driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
     //driver.findElement(By.className("firstLeaveMenu")).click();
     //driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule")).click();
     
     //driver.findElement(By.cssSelector("")).click();
     String actualheight=driver.findElement(By.xpath("//*[@id='branding']/img")).getAttribute("height");
     String actualwidth=driver.findElement(By.xpath("//*[@id='branding']/img")).getAttribute("width");
    // String actualwidth1=driver.findElement(By.cssSelector("[alt=''orangeHRM]")).getAttribute("width");
    // String actualwidth2=driver.findElement(By.tagName("img")).getAttribute("width");


     assertEquals( "56", actualheight);
    //assertEquals(56, (int) Integer.valueOf(actualwidth)); 
     assertEquals( "283", actualwidth);

     org.openqa.selenium.Dimension size = driver.findElement(By.tagName("img")).getSize();
    assertEquals(283, size.width);
    assertTrue(size.height==56);
    
     Point location = driver.findElement(By.xpath("//*[@id='branding']/img")).getLocation();
     
     assertTrue( location.x <40 );
     assertTrue(location.y <40);     
     System.out.println(location.x+" "+location.y);
     //To check image is in left half of the page
     int documentWidth = driver.findElement(By.tagName("body")).getSize().width;
     int logoWidth = driver.findElement(By.xpath(".//*[@id='branding']/img")).getSize().width;

     int logoX=driver.findElement(By.tagName("img")).getLocation().x;
     
     int logoRightCorner=logoWidth+logoX;
     assertTrue(logoRightCorner < documentWidth/2);
     
     
	}

}
