package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
		pageUrl="http://hrm.seleniumminutes.com/symfony/web/index.php/dashboard";
	}

	public String getGreeting() {
		return driver.findElement(By.id("welcome")).getText();

	}

	public void launch(String quickLaunch) {
		String locator = "//span[@class='quickLinkText' and contains(text(),'" + quickLaunch + "')]";
		driver.findElement(By.xpath(locator));
	}

}
