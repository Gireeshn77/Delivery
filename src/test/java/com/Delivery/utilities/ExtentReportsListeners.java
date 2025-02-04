package com.Delivery.utilities;
 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//Listeners class used to generate extent reports
public class ExtentReportsListeners implements ITestListener
{
	 public  ExtentSparkReporter sparkreporter; //UI of the report
     public  ExtentReports extent; //populate common info on the report
     public ExtentTest test; // creating test entries in the report and update status of test methods
      
      
    public void onStart(ITestContext testContext) {
    	  System.out.println("on start >>>>>");
    	  
    	  String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	  String Repname ="Test-Report-"+timestamp+".html" ;
    	  
    	  sparkreporter=new ExtentSparkReporter ("C:\\Users\\ngire\\eclipse-workspace\\Delivery\\Reports\\"+Repname);
    	  sparkreporter.config ().setDocumentTitle("Automation Report"); // Title of report 
    	  sparkreporter.config().setReportName("Functional Testing"); // name of the report 
    	//  sparkreporter.config(). setTheme (Theme.DARK) ;
    	  
    	  extent=new ExtentReports();
    	  extent.attachReporter (sparkreporter);
    	  
    	  extent.setSystemInfo ("Computer Name","localhost");
    	  extent.setSystemInfo ("Environment", "QA") ;
    	  extent.setSystemInfo ("Tester Name", "Pavan");
    	  extent.setSystemInfo("Os", "Windows10");
    	  extent.setSystemInfo("Browser name", "Chrome");
    	  
     }
 
   
	public void onTestSuccess(ITestResult result) {
		 System.out.println("on Test success >>>>>");
		 
		 test = extent.createTest(result.getName()); // create a new enty in the report
    	 test.log (Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
    	 
		 
	}

    
	public void onTestFailure(ITestResult result) {
		 System.out.println("on test failure >>>>>");
		 
		 test = extent.createTest(result.getName());
		 test. log(Status.FAIL, "Test case FAILED is:" + result.getName()) ; 
		 test. log(Status.FAIL, "Test Case FAILED cause is:" + result.getThrowable());
		 
		    String tname=result.getName();
			String screenshotpath="C:\\Users\\ngire\\eclipse-workspace\\Delivery\\Screenshots"+tname+".png";
			File fe=new File(screenshotpath);
			if(fe.exists())
			{
				try
				{
				test.fail("screentshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			 
		 
	}

	
	public void onTestSkipped(ITestResult result) {
		 System.out.println("on test skipped >>>>>");
		 
		 test = extent.createTest(result.getName());
		 test. log(Status.SKIP, "Test case SKIPPED is:" + result.getName()) ; 
		 
	}

	 public void onFinish(ITestContext testContext) {
		 System.out.println("on Finish >>>>>");
		 extent.flush();
     }
 

	 public void onTestStart(ITestResult result) {
    	 System.out.println("on Teststart >>>>>");
    	 
    	
	}
    
	 
}
