package Generic_Component;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;





public class Base_Class {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentreport;
	public static ExtentTest extenttest;
	public WebDriver driver;
	public String Capture_Screenshot(String TC_ID, String Order_Set) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String str=df.format(date)+".png";		
		
		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("C:\\Selenium\\2020\\TestAutomationJNJ\\Screenshot"+TC_ID+"-"+Order_Set+"-"+ str));
		String path="C:\\Selenium\\2020\\TestAutomationJNJ\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+ str;
		return path;
		
		
	}
	
		
	public void Explicit_wait(WebElement ele,long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
		
	}
	
	@BeforeSuite
	public static void Extent_Report(){
	Date date =new Date();
	SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
	String format = df.format(date);
	//extentreport=new ExtentReports("C:\\Selenium\\2020\\TestAutomationJNJ\\Report\\"+"BB_Project"+"-"+format+".html",false);
	// initialize the HtmlReporter
    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Report\\"+"BB_Project"+"-"+format+".html");
    
    //initialize ExtentReports and attach the HtmlReporter
    extentreport = new ExtentReports();
    extentreport.attachReporter(htmlReporter);
	}
	
	@AfterSuite
    public void tearDown() {
    	//to write or update test information to reporter
    	extentreport.flush();
    }	
	

}
