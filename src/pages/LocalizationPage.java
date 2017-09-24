package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LocalizationPage extends BasePage {

	public LocalizationPage(WebDriver driver) {
		super(driver);
		pageUrl=baseUrl+"/symfony/web/index.php/admin/localization";
	}


	public void edit() {
		save();
	}

	public void changeLocale(String locale) {
		driver.findElement(By.id("localization_dafault_language")).click();
		Select dropdown = new Select(driver.findElement(By.id("localization_dafault_language")));
        dropdown.selectByValue(locale);
		
	}

	
	public void save() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
		
		}

	
	public String getSuccessMessage() {
		String msg=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success.message"))).getText();
        System.out.println("getSuccess "+msg);
		String jsCode="return document.querySelector('.success.message').firstChild.textContent;";
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return (String) js.executeScript(jsCode);
		 
	}


	public void changeLocale1(String locale) {
		edit();
		changeLocale(locale);
		save();
		
	}
    
	
	

}
