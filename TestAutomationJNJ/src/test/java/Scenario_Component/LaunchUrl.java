package Scenario_Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Generic_Component.Base_Class;
import Generic_Component.Utility_class;

public class LaunchUrl extends Base_Class {
	
	
	//public static Logger log=Logger.getLogger(LaunchUrl.class);
		  
    @Test
	public void testLogin() throws IOException {
    	SoftAssert sAssert= new SoftAssert();
    	extenttest=extentreport.createTest("1");	
		extenttest.log(Status.PASS, "Executing the TestCase "+"1" + "Order set is "+"Order_Set");
		//extenttest.log(Status.PASS, extenttest.addScreencastFromPath(Capture_Screenshot("1", "Order_Set"));
		extenttest.addScreenCaptureFromPath(Capture_Screenshot("1", "Order_Set"));
		//System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		
		
	}
    
    
    
   

}
