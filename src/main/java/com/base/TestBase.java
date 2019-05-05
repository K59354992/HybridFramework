package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.testUtils.TestUtils;
import com.testUtils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties Prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() throws IOException

	{
		Prop = new Properties();
		FileInputStream FIS = new FileInputStream(
				"E:\\Workspace\\HybridFramework\\src\\main\\java\\com\\config\\config.properties");
		Prop.load(FIS);

	}

	public static void initialization() throws IOException {

		String BrowserName = Prop.getProperty("Browser");
		if (BrowserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (BrowserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();
		e_driver.register(eventListener);
		driver= e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(Prop.getProperty("URL"));
	}

}
