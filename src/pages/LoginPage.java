package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{


	public LoginPage(WebDriver driver) {
		super(driver);
		pageUrl=baseUrl;
		
	}

	public void login(String userName, String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frmLogin")));
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
        
	}

}