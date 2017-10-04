package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import menues.MainMenu;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String pageUrl;
	protected String baseUrl;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		baseUrl = "http://hrm.seleniumminutes.com/";
	}

	public String getHeader(By locator) {
		return driver.findElement(locator).getText();
	}

	public void gotoPage() {
		driver.get(pageUrl);
	}

}
