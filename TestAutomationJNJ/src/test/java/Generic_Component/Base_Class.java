package Generic_Component;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.applitools.eyes.selenium.Eyes;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Base_Class {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentreport;
	public static ExtentTest test;
	public WebDriver driver;
    protected static Eyes eyes;
	
	
	public String Capture_Screenshot(String TC_ID, String Order_Set) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String str=df.format(date)+".png";		
		
		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("Screenshot/"+TC_ID+"-"+Order_Set+"-"+ str));
		String path="Screenshot/"+TC_ID+"-"+Order_Set+"-"+ str;
		//System.out.println("Path is"+path);
		return path;
		
		
	}
	
		
	public void Explicit_wait(WebElement ele,long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
		
	}
	@AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
	
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() throws IOException{
						
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		capabilities.setCapability(InternetExplorerDriver.
				  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
		
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,false);
		
		driver=new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		try {
			String url=Utility_class.Reading_properties("URL");
			driver.get(url);
			System.out.println("Url launch check");
		
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("URL is not available");
		}
		
		Set<String> afterPopup = driver.getWindowHandles(); 
		//System.out.println("After"+afterPopup.size());
		
		System.out.println(driver.getTitle());
		System.out.println("Setup Complete");
		
	}
	
	
	private static void initiateEyes() {
		eyes=new Eyes();
		String api_key = null;
		try {
			api_key = Utility_class.Reading_properties("applitools.api.key");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eyes.setApiKey(api_key);
		
	}
	public void validateWindow() {
		eyes.open(driver, "Automation JNJ", Thread.currentThread().getStackTrace()[2].getMethodName());
		eyes.checkWindow();
        eyes.close();
	}


	@BeforeSuite
	public static void Extent_Report(){
	Date date =new Date();
	SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
	String format = df.format(date);
	// initialize the HtmlReporter
    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Report\\"+"QC_Project"+"-"+format+".html");
    
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setDocumentTitle("Extent Report");
    htmlReporter.config().setReportName("Test Report");
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    
    //initialize ExtentReports and attach the HtmlReporter
    extentreport = new ExtentReports();
    extentreport.attachReporter(htmlReporter);
    
	}
	
	@AfterSuite
    public void tearDown() {
    	
	
    	extentreport.flush();
    	//driver.quit();
    	//eyes.abortIfNotClosed();
    }	
	

}
