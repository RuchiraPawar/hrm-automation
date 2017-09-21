package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeePage extends BasePage {
	private final String empForm="#frmAddEmp";
	public AddEmployeePage(WebDriver driver) {
		super(driver);
        pageUrl=baseUrl+"symfony/web/index.php/pim/addEmployee";
	}

	public void enterFullName(String firstName, String middleName, String lastName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(empForm)));
		driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#middleName")).sendKeys(middleName);
        driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);

	}

	public String getEmployeeId() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(empForm)));
		return driver.findElement(By.id("employeeId")).getAttribute("value");
		 
	}

	public void save() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(empForm)));
	    driver.findElement(By.id("btnSave")).click();

	}

	
	}


