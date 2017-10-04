package menues;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainMenu extends BaseMenu {

	private By adminMenu = By.id("menu_admin_viewAdminModule");
	private By userManagement = By.id("menu_admin_UserManagement");
	private By adminConfiguration = By.id("menu_admin_Configuration");
	private By localization = By.id("menu_admin_localization");

	public MainMenu(WebDriver driver) {
		super(driver);

	}

	public void gotoLocalization() {
		Actions move = new Actions(driver);

		move.moveToElement(driver.findElement(adminMenu));
		move.pause(Duration.ofSeconds(2));
		move.moveToElement(driver.findElement(userManagement));
		move.moveToElement(driver.findElement(adminConfiguration)).perform();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(localization));
		
		move.click(driver.findElement(localization));
		move.perform();

	}
}
