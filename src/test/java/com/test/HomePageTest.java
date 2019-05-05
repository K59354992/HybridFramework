package com.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import com.base.TestBase;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApp(Prop.getProperty("Username"), Prop.getProperty("Password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String HomePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRM", "HomePage Title is Incorrect");
	}

	@Test(priority = 2)
	public void clickOnContactsLinkTest() throws InterruptedException, IOException {
		contactsPage = homePage.clickOnContacts();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
