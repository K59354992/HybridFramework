package com.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.testUtils.TestUtils;

public class ContactsPageTest extends TestBase {

	public ContactsPageTest() throws IOException {
		super();

	}

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String SheetNumber = "Contacts";
	TestUtils utils;

	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApp(Prop.getProperty("Username"), Prop.getProperty("Password"));
		contactsPage = homePage.clickOnContacts();

	}

	@DataProvider
	public Object[][] getCRMTestData() throws Exception {
		Object data[][] = TestUtils.getTestData(SheetNumber);
		return data;
	}

	@Test(dataProvider = "getCRMTestData")
	public void createContactsTest(String FirstName, String MiddleName, String LastName) throws InterruptedException {
		contactsPage.clickOnNewContact();
		contactsPage.createContact(FirstName, MiddleName, LastName);
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
