package menues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseMenu {
	
	WebDriver driver;
	WebDriverWait wait;
    
	public BaseMenu(WebDriver driver) {
		this.driver=driver;
		
	}

}
