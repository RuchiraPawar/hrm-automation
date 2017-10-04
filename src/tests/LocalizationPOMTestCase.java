package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.LocalizationPage;

public class LocalizationPOMTestCase extends AdminLogin {
	 private LocalizationPage localizationPage;

	@Before
	public void setUp() throws Exception {
		localizationPage=new LocalizationPage(driver);
		login();
	}

	@Test
	public void test() {
		
		//localizationPage.gotoPage();
		mainMenu.gotoLocalization();
		By locator = By.id("localizationHeading");
		localizationPage.edit();
		localizationPage.changeLocale("zh_CN");
		localizationPage.save();
		String actual = localizationPage.getHeader(locator);
		assertTrue(actual.matches("\\W+"));
        String message=localizationPage.getSuccessMessage();
        System.out.println(message);

		assertTrue(message.matches("\\W+"));
	
		localizationPage.changeLocale1("en_US");
		String actual1 = localizationPage.getHeader(locator);
		assertTrue(actual1.matches("[A-Za-z]+"));
        String message1=localizationPage.getSuccessMessage();
        System.out.println(message);
		assertTrue(message1.matches("[A-Za-z\\s]+"));
	}

}
