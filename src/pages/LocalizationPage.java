package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LocalizationPage extends BasePage {

	public LocalizationPage(WebDriver driver) {
		super(driver);
		
	}

	public void adminClick() throws InterruptedException {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Configuration")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_Configuration")));
		driver.findElement(By.id("menu_admin_localization")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("localization_dafault_language")).click();
		Select dropdown = new Select(driver.findElement(By.id("localization_dafault_language")));
        dropdown.selectByValue("zh_CN");
		driver.findElement(By.id("btnSave")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("localization_dafault_language")).click();
		Select dropdown1 = new Select(driver.findElement(By.id("localization_dafault_language")));
        dropdown1.selectByValue("en_US");
		driver.findElement(By.id("btnSave")).click();
        
		
	}
    
	
	

}
