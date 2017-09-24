package tests;

import pages.LoginPage;

public class AdminLogin extends BaseTest{
	private LoginPage loginPage;
	
	public void login() {
		loginPage=new LoginPage(driver);
		loginPage.gotoPage();
		loginPage.login("admin", "Password");
		
		
		
	}
	

}
