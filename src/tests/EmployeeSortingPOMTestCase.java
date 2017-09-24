package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pages.EmployeeListPage;

public class EmployeeSortingPOMTestCase extends AdminLogin {
	
	protected EmployeeListPage employeeListPage;

	@Before
	public void setUp() throws Exception {
		employeeListPage=new EmployeeListPage(driver);
		login();
		
	}

	@Test
	public void test() {
		
		employeeListPage.gotoPage();
		employeeListPage.clickFirstName();
		employeeListPage.sort();
		
		//assertEquals(expected, actual);
		
	}

}
