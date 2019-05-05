package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button [contains(.,'New')]")
	WebElement NewButton;

	@FindBy(xpath = "//input [@name='first_name']")
	WebElement FirstName;

	@FindBy(xpath = "//input [@name='middle_name']")
	WebElement MiddleName;

	@FindBy(xpath = "//input [@name='last_name']")
	WebElement LastName;

	@FindBy(xpath = "//button [contains(.,'Save')]")
	WebElement SaveButton;

	public void clickOnNewContact() {
		NewButton.click();
	}

	public void createContact(String FName, String MName, String LName) {
		FirstName.sendKeys(FName);
		MiddleName.sendKeys(MName);
		LastName.sendKeys(LName);
		SaveButton.click();
	}

}
