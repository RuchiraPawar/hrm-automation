import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import general.General;

public class SearchTest {
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
	
	

	//@Test
	public void testSearch() {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		
		String firstname="jonh";
		String lastname="Smith";
		String userName="Sentjk4cked";
		String password="Passwo122323";
		General.login(driver,"admin","Password");
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		String id = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println(id);
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(userName);
		//sleep(1);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();
		sleep(1);
		driver.findElement(By.id("btnSave")).click();
		//sleep(5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='personal_optGender_1']")));
		driver.findElement(By.xpath(".//*[@id='personal_optGender_1']")).click();
		
		
		driver.findElement(By.id("personal_cmbMarital")).click();
		Select dropdown1 = new Select(driver.findElement(By.id("personal_cmbMarital")));
        dropdown1.selectByIndex(2);
        
		
       // sleep(2);
				
//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#empsearch_job_title option[value='2'][selected]")));
		
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.id("btnAddAttachment")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		sleep(1);
		driver.findElement(By.id("empsearch_id")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(id);
		sleep(1);
        driver.findElement(By.id("searchBtn")).click();
        sleep(3);

       String actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        sleep(2);
        String expectedR=driver.findElement(By.id("empsearch_id")).getAttribute("value"); 
        System.out.println( expectedR+ " " + actual);
        assertEquals(expectedR,actual );
        sleep(1);
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).click();


        String actualfirstname=driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr[1]/td[3]/a")).getText();
        assertEquals(firstname, actualfirstname);

        String actuallastname=driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr[1]/td[4]/a")).getText();
        assertEquals( lastname, actuallastname);
        
	}
		
	@Test
	public void testSearchJob() {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		
		String firstname="jonh";
		String lastname="Smith";
		String userName="Sdi57ae";
		String password="Password";
		General.login(driver,"admin","Password");
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		String id = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println(id);
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='sidenav']/li[6]/a"))).click();
	    
	    driver.findElement(By.id("btnSave")).click();
	    Select dropdown1 = new Select(driver.findElement(By.id("job_job_title")));
	    dropdown1.selectByValue("4");
	    Select dropdown = new Select(driver.findElement(By.id("job_emp_status")));
	    dropdown.selectByValue("1");
	    driver.findElement(By.id("btnSave")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".message.success")));
	    
	    
	    driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("empsearch_id"))).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(id);
		
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBtn"))).click();
       

        String actual=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[1]/td[2]"))).getText();
        
        String expectedR=driver.findElement(By.id("empsearch_id")).getAttribute("value"); 
        assertEquals(expectedR,actual );
        
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).click();


        String actualfirstname=driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr[1]/td[3]/a")).getText();
        assertEquals(firstname, actualfirstname);

        String actuallastname=driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr[1]/td[4]/a")).getText();
        assertEquals( lastname, actuallastname);
        
        String actualJobTitle=driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td[5]")).getText();
        assertEquals("Software Developer" , actualJobTitle);
        
        String actualEmpStatus=driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td[6]")).getText();
        assertEquals("Full-time", actualEmpStatus);

	}
	
	//@Test
	
public void searchByLastName() {
		
		General.login(driver,"admin","Password");
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		sleep(1);
		driver.findElement(By.id("empsearch_employee_name_empName")).click();
		
        
        
         sleep(1);
		
		Select dropdown=new Select(driver.findElement(By.id("empsearch_job_title")));	
        dropdown.selectByValue("2");
		sleep(1);
		driver.findElement(By.id("empsearch_job_title")).click();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("smith" + Keys.TAB);
		
        sleep(1);
        driver.findElement(By.id("searchBtn")).click();
        sleep(3);
        int rowCount=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
        System.out.println(rowCount);	
        for(int i=1;i<=rowCount;i++) {
        
        	String actual=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
        	String actual1=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText();

        	//System.out.println(actual);
        	assertEquals( "Smith", actual);
        	assertEquals( "QA Manager", actual1);
        }
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


