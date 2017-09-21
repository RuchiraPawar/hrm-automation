package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.AddEmployeePage;
import pages.LoginPage;
import pages.PimPage;

public class EmployeeSearchPOMTestCase extends AdminLogin {

	private PimPage pimPage;
	private AddEmployeePage addEmployeePage;

	@Before
	public void setUp() throws Exception {

		pimPage = new PimPage(driver);
		addEmployeePage = new AddEmployeePage(driver);
		login();
	}

	@Test
	public void test() throws InterruptedException {
		String fname = "jonh";
		String lname = "sinha";
		String mname = "";
		String empId;
		addEmployeePage.gotoPage();
		Thread.sleep(3000);
		addEmployeePage.enterFullName(fname, mname, lname);
		empId = addEmployeePage.getEmployeeId();
		addEmployeePage.save();
		Thread.sleep(3000);
		pimPage.gotoPage();
		pimPage.searchById(empId);

		assertEquals(empId, driver.findElement(By.xpath("//tbody//td[2]/a")).getText());
		assertEquals(fname, driver.findElement(By.xpath("//tbody//td[3]/a")).getText());
		assertEquals(lname, driver.findElement(By.xpath("//tbody//td[4]/a")).getText());

	}

}
