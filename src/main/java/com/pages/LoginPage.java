package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email1")
	WebElement UserName;

	@FindBy(name = "password1")
	WebElement Password;

	@FindBy(xpath = "//div [@class='ui fluid large blue submit button' and contains(.,'Login')]")
	WebElement LoginButton;

	public String getTitle() {
		return driver.getTitle();
	}
	
	public HomePage loginToApp(String Username, String Pass) throws IOException
	{
		UserName.sendKeys(Username);
		Password.sendKeys(Pass);
		LoginButton.click();
		
		return new HomePage();
		
	}

}
