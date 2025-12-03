package com.Delivery.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Delivery.utilities.XLUtils;
import com.Delivey.pageObjects.LoginPage;

public class TC_LoginPageDDT_02 extends BaseClass {

	@Test(dataProvider = "Logindata")
	public void LoginDDT(String user, String pwd) throws Exception {
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setusername(user);
		lp.setpassword(pwd);
		lp.signin();
		Thread.sleep(5000);
	}

	@DataProvider(name = "Logindata")
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\ngire\\git\\repository\\Delivery\\src\\test\\java\\com\\Delivery\\testData\\Testdata.xls";

		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1 , 0
			}
		}
		return logindata;

	}

	@DataProvider(name = "loginData1")
	public String[][] getData1() throws Exception {
		
		File excelFile = new File("C:\\Users\\ngire\\git\\repository\\Delivery\\src\\test\\java\\com\\Delivery\\testData\\Testdata.xls");
		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noOfRows - 1][noOfColumns];

		DataFormatter df = new DataFormatter();

		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		workbook.close();
		fis.close();

		return data;
	}
	

	@DataProvider(name = "loginData2")
	public Object[][] getData2() {
		return new Object[][] {
			{ "user1@example.com", "Password123" }, 
			{ "user2@example.com", "Test@456" },
			{ "user3@example.com", "Admin@789" } 
			};
	}

}
