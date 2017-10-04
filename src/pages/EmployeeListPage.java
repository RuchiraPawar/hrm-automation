package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;

import java.util.Arrays;

public class EmployeeListPage extends BasePage {

	public EmployeeListPage(WebDriver driver) {
		super(driver);
		pageUrl = baseUrl + "/symfony/web/index.php/pim/viewEmployeeList";

	}

	public void clickFirstName() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultTable")));
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th[3]/a")).click();

	}

	public void sort(int columnNumber) {
		String secondName = "";
		int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
		System.out.println(rowCount);

		String pageNumber = driver.findElement(By.xpath(("//*[@id=\"frmList_ohrmListComponent\"]/div[5]/ul/li[1]")))
				.getText();
		System.out.println(pageNumber);
		String[] pageNumberTokens = pageNumber.split(" ");
		System.out.println(Arrays.toString(pageNumberTokens));
		int totalNumberOfRecords = Integer.valueOf(pageNumberTokens[2]);
		System.out.println(totalNumberOfRecords);
		double rowCountAsDouble = rowCount;
		for (int j = 1; j <= Math.ceil(totalNumberOfRecords / rowCountAsDouble); j++) {
			driver.findElement(By.linkText("" + j + "")).click();
			String firstRecord = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[" + columnNumber + "]/a"))).getText();
			int rowCount1 = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();

			System.out.println("Previous Page Last Record: " + secondName);
			System.out.println("Next Page" + j + " First Record: " + firstRecord);

			assertTrue(secondName.compareToIgnoreCase(firstRecord) <= 0);
			int i = 1;
			while (i < rowCount1) {
				String firstName = driver
						.findElement(
								By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + i + "]/td[" + columnNumber + "]/a"))
						.getText();
				secondName = driver
						.findElement(By
								.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + (i + 1) + "]/td[" + columnNumber + "]/a"))
						.getText();

				assertTrue(firstName.compareToIgnoreCase(secondName) <= 0);
				i++;
			}

		}
	}

	public void clickLasttName() {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultTable")));
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th[4]/a")).click();

	}

}
