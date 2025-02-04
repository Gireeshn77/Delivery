package com.Delivery.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Delivery.utilities.XLUtils;
import com.Delivey.pageObjects.LoginPage;

public class TC_LoginPageDDT_02 extends BaseClass
{

	@Test(dataProvider="Logindata")
	public void LoginDDT(String user , String pwd) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setusername(user);
		lp.setpassword(pwd);
		lp.signin();
		Thread.sleep(5000);
		
    }
	
	
	@DataProvider(name="Logindata")
	public String[][] getData() throws IOException
	{
		String path = "C:\\Users\\ngire\\git\\repository\\Delivery\\src\\test\\java\\com\\Delivery\\testData\\Testdata.xls";
		
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount ; i++)
		{
			for(int j=0;j<colcount ; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); // 1 , 0
			}
			
		}
		return logindata;
		
	}

}
