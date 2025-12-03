package com.Delivery.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.Delivery.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getApplicationuURL();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	public static WebDriver driver;

	SimpleDateFormat sdf;
	Date date;
	String dateformat;
	String Repname;

//		@BeforeClass
//		public void setup()
//		{	 
//			driver = new ChromeDriver();	
//			driver.get(baseUrl);
//		}

	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome") String br) // Go page down to check why @optional("chrome") has added here
	{
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(baseUrl);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void takeScreenshot(String tname) throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		sdf = new SimpleDateFormat("dd-MM-YYYY,HH.mm.ss");
		date = new Date();
		dateformat = sdf.format(date);
		Repname = tname + dateformat + ".png";
		File dst = new File("C:\\Users\\ngire\\eclipse-workspace\\Delivery\\Screenshots" + Repname);
		FileUtils.copyFile(src, dst);

		System.out.println("Screenshot taken");
	}

	// --------Explanation for Optional added--------
	// @Optional is added so the test can run independently without needing values from the TestNG XML file.
	// Without @Optional, running a single test method directly (without testng.xml), would throw an error.
	// This allows flexibility to run tests either individually or through the testng.xml configuration.

}
