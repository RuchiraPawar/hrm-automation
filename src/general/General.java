
package general;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class General {
public static void login(WebDriver driver,String username,String password) {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		
		}

}
