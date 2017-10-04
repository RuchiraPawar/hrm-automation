package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pages.EmployeeListPage;

public class EmployeeSortingPOMTestCase extends AdminLogin {

	protected EmployeeListPage employeeListPage;

	@Before
	public void setUp() throws Exception {
		employeeListPage = new EmployeeListPage(driver);
		login();

	}

	@Test
	public void test() {
		int columnNumberOfFirstName = 3;
		int columnNumberOfLastName = 4;

		employeeListPage.gotoPage();
		employeeListPage.clickFirstName();

		employeeListPage.sort(columnNumberOfFirstName);
		employeeListPage.clickLasttName();
		employeeListPage.sort(columnNumberOfLastName);
		// assertEquals(expected, actual);

	}

}
