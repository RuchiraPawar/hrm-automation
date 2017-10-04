package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.EmployeeSearchPOMTestCase;
import tests.EmployeeSortingPOMTestCase;

@RunWith(Suite.class)
@SuiteClasses({ EmployeeSearchPOMTestCase.class, EmployeeSortingPOMTestCase.class })
public class AllTests {

}
