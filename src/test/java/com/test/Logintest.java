package com.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class Logintest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public Logintest() throws IOException {
		super();

	}

	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void validateTitle() {
		String title = loginPage.getTitle();
		Assert.assertEquals(title, "CRM");
	}

	@Test(priority=2)
	public void validateLogin() throws IOException, InterruptedException {
		homePage = loginPage.loginToApp(Prop.getProperty("Username"), Prop.getProperty("Password"));
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "CRM");
		Thread.sleep(5000);
		System.out.println("Test Passed");
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
