package Generic_Component;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

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
		FileUtils.copyFile(screenshotAs, new File("D:\\selenium\\git\\TestAutomationJNJ\\TestAutomationJNJ\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+ str));
		String path="D:\\selenium\\git\\TestAutomationJNJ\\TestAutomationJNJ\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+ str;
		System.out.println("Path is"+path);
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
		//System.setProperty("webdriver.chrome.driver", "D:\\selenium\\git\\TestAutomationJNJ\\TestAutomationJNJ\\resources\\chromedriver.exe");
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		capabilities.setCapability(InternetExplorerDriver.
				  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		System.setProperty("webdriver.ie.driver", "D:\\selenium\\git\\TestAutomationJNJ\\TestAutomationJNJ\\resources\\IEDriverServer.exe");
		
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,false);
		//capabilities.setCapability("initialBrowserUrl", "http://192.168.106.125:8180/Aris/login");
		//driver=new ChromeDriver();
		
		driver=new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//String parentWindow= driver.getWindowHandle();
		//System.out.println("First Window"+parentWindow);
		//System.out.println(driver.switchTo().frame(1));
		/* 1 Set<String> handlesSet = driver.getWindowHandles();
		System.out.println(handlesSet);
        List<String> handlesList = new ArrayList<String>(handlesSet);
        for(String curWindow : handlesList){
           driver.switchTo().window(curWindow);
           System.out.println(curWindow);
        }
		
		Set<String> beforePopup = driver.getWindowHandles(); 
		System.out.println("Before"+beforePopup.size());
		//click which causes to open new window
		*/
		
		/* 2 // get all the window handles after the popup window appears 
		Set<String> afterPopup = driver.getWindowHandles(); 
		System.out.println("After"+afterPopup.size());
		
		
		// remove all the handles from before the popup window appears afterPopup.removeAll(beforePopup); 
		// there should be only one window handle left 
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		if(afterPopup.size() == 1) 
		{ 
		        driver.switchTo().window((String)afterPopup.toArray()[0]); 
		        driver.getTitle();
		        System.out.println("Inside If");
		        //driver.close();
		}
		*/
		
		//driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.partialLinkText("Forgot")));
         //driver.switchTo().window(parentWindow);
	   // System.out.println("Size is"+handlesList.size());
		//driver.switchTo().window(handlesList.get(1));
	    //driver.close();
	    //driver.switchTo().window(tabs2.get(1));
		//driver=new InternetExplorerDriver();
		//driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);
		
		//initiateEyes();
		//driver.get("http://192.168.106.125:8180/Aris/login");
		try {
			String url=Utility_class.Reading_properties("URL");
			driver.get(url);
			System.out.println("Url launch check1");
			/*4 driver=new InternetExplorerDriver(capabilities);
		 //Code for wait for new page
			
			// get all the window handles after the popup window appears 
			Set<String> afterPopup = driver.getWindowHandles(); 
			System.out.println("After"+afterPopup.size());
			
			
			// remove all the handles from before the popup window appears afterPopup.removeAll(beforePopup); 
			// there should be only one window handle left 
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
			if(afterPopup.size() == 1) 
			{ 
			        driver.switchTo().window((String)afterPopup.toArray()[0]); 
			        driver.getTitle();
			        System.out.println("Switching to new window");
			        
			        //driver.close();
			}
			
			
			//End of wait 
			
			*/
			
			
			//log.info("Passed as Actual Result is  "+"Actual_Result" + " Same as Expected Result "+"Exp_Result");
		   //Capture_Screenshot("1", "Order_Set");
		   //System.out.println("Captured  scrresnhot");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("URL is not available");
		}
		
		Set<String> afterPopup = driver.getWindowHandles(); 
		System.out.println("After"+afterPopup.size());
		
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
    	//to write or update test information to reporter
	
    	extentreport.flush();
    	//driver.quit();
    	//eyes.abortIfNotClosed();
    }	
	

}
