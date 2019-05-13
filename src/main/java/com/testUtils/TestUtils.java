package com.testUtils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;

public class TestUtils extends TestBase {

	public TestUtils() throws IOException {

	}

	public static long PAGE_LOAD_TIMEOUT = 120;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "E:\\Workspace\\HybridFramework\\src\\main\\java\\com\\testData\\CRMTestData.xlsx";

	static XSSFWorkbook Excelbook;
	static XSSFSheet workSheet;

	public static Object[][] getTestData(String SheetName) throws IOException {

		FileInputStream FIS = new FileInputStream(TESTDATA_SHEET_PATH);
		Excelbook = new XSSFWorkbook(FIS);
		workSheet = Excelbook.getSheet(SheetName);
		System.out.println("Success");

		System.out.println("Row Count" + workSheet.getLastRowNum());
		System.out.println("Column Count" + workSheet.getRow(0).getLastCellNum());

		Object[][] data = new Object[workSheet.getLastRowNum()][workSheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < workSheet.getLastRowNum(); i++) {
			for (int k = 0; k < workSheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = workSheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir +"//Screenshots//" + System.currentTimeMillis() + ".png"));
	}

}
