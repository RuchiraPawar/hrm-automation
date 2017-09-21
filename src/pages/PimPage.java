package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.BasePage;

public class PimPage extends BasePage {
	

	public PimPage(WebDriver driver) {
		super(driver);
		pageUrl="http://hrm.seleniumminutes.com/symfony/web/index.php/pim/viewEmployeeList/reset/1";
	
	}

	public void doAddEmployee() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();

	}

	public void searchById(String empId) {
		driver.findElement(By.cssSelector("#empsearch_id")).click();
		driver.findElement(By.cssSelector("#empsearch_id")).sendKeys(empId);
        driver.findElement(By.id("searchBtn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#empsearch_id[value='"+empId+"']")));
		
	}

	

}
