package Scenario_Component;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Generic_Component.Base_Class;
import PageObject_Component.AER_Registration;
import PageObject_Component.CaseIntake;


public class LaunchUrl extends Base_Class {
	
	

	  
    @Test(priority=1)
	public void testLaunchUrl() throws IOException {
    	test=extentreport.createTest("LaunchUrlTest");	
		test.log(Status.PASS, "Executing the TestCase "+"1" + "Order set is "+"Order_Set");
		//extenttest.log(Status.PASS, extenttest.addScreencastFromPath(Capture_Screenshot("1", "Order_Set"));
		test.addScreenCaptureFromPath(Capture_Screenshot("1", "Order_Set"));
		//validateWindow();
				
	}
    
    @Test(priority=2,dataProvider="dp_Userlogin",dataProviderClass=DataProvider_Component.Testdataprovider.class)
    public void testLoginLogout(Map<String,String> Search) throws IOException, AWTException, InterruptedException
    {
    test=extentreport.createTest("UserLoginTest");	
    
    PageObject_Component.LoginLogout login=new PageObject_Component.LoginLogout(driver);
    String TC_ID = Search.get("TC_ID");
    String DB=Search.get("Database");
	String User_Name = Search.get("User_name");		
	String User_Password = Search.get("User_Password");
	
    login.selectDB(DB);
    login.login(User_Name,User_Password);
    
    test.addScreenCaptureFromPath(Capture_Screenshot("2", "Order_Set"));
   // validateWindow();
   /* WebElement element;  
    WebDriverWait wait = new WebDriverWait(driver, 100);
    element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='svg_31']"))); */
   
    
            // get all the window handles after the popup window appears 
    /*Set<String> afterPopup = driver.getWindowHandles(); 
 			System.out.println("After login"+afterPopup.size());
 			
    WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	System.out.println(afterPopup);
	
	if(afterPopup.size() == 2) 
	{ 
	        driver.switchTo().window((String)afterPopup.toArray()[1]); 
	        driver.getTitle();
	        System.out.println("Switching to HomePage");
	        
	        //driver.close();
	}
    
    login.logout();
	
	Robot robot=new Robot();
    robot.setAutoDelay(250);
    robot.keyPress(KeyEvent.VK_ALT);
    Thread.sleep(1000);
    robot.keyPress(KeyEvent.VK_SHIFT);
    Thread.sleep(1000);
    robot.keyPress(KeyEvent.VK_N);
   
    robot.keyRelease(KeyEvent.VK_N);
    robot.keyRelease(KeyEvent.VK_SHIFT);
    robot.keyRelease(KeyEvent.VK_ALT);*/
   
    Thread.sleep(2000);
    if (driver == null){
       System.out.println("Driver is null");
    }
    String currentWindow = driver.getWindowHandle();// get handle of current window
    System.out.println("Current Window is"+currentWindow);
    Set<String> handles = driver.getWindowHandles();// get handle of all windows
    Iterator<String> it = handles.iterator();
    while (it.hasNext()) {
    if (currentWindow == it.next()) {
    continue;
    }
    driver = driver.switchTo().window(it.next());// switch to new window
    System.out.println("Switched To New window");
    System.out.println(driver);
    //business action
    //xxxxxxx
    }
    driver.switchTo().window(currentWindow);//switch back to original window
    System.out.println("Switching Original ");
    System.out.println("After Swiching Current Window is"+currentWindow);
    
    
    
    /*driver.findElement(By.xpath("//img[@src=\"/Aris/images/top_menu_icons/new.png\"]")).click();
    Thread.sleep(2000);
    
    driver.switchTo().defaultContent();
    Thread.sleep(1000);
    driver.switchTo().frame("space");
    Thread.sleep(1000);
    driver.switchTo().frame("AerFrame1");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name=\"/I=101132/G=10101/D=C/\"]")).click();
    
    driver.findElement(By.xpath("//input[@name=\"/I=1011/\"]")).click();*/
    
    //((JavascriptExecutor)driver).executeScript("signOff();");
    //login.logout();
    
    //JavascriptExecutor js = (JavascriptExecutor)driver;
    //js.executeScript("document.getElementById('svg_30').click();");
   // driver.getCurrentUrl();
    
    test.log(Status.PASS, "Executing the TestCase "+TC_ID + "Order set is "+"Order_Set");
    test.addScreenCaptureFromPath(Capture_Screenshot("2", "Order_Set"));
   // validateWindow();
    }
    
  
    @Test(priority=3)
    public void testAerRegistration() throws IOException, InterruptedException {
        test = extentreport.createTest("AER Classification Type Selection Test");
        /*  Assert.assertTrue(true);
        String TC_ID = Search.get("TC_ID");
    	String Order_Set = Search.get("Order_Set");		
    	String Search_Item = Search.get("Search_Item");
        //Reporter.log(TC_ID+Order_Set+Search_Item);
        //System.out.println(TC_ID+Order_Set+Search_Item);*/
        Thread.sleep(1000);
        driver.switchTo().frame("navig");
        System.out.println("Navigated");
        AER_Registration aerR=new AER_Registration(driver);
        aerR.createNewCase();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.switchTo().frame("space");
        Thread.sleep(1000);
        driver.switchTo().frame("AerFrame1");
        Thread.sleep(1000);
        aerR.classificationType();
        
        aerR.confirmClassification();
        
        test.log(Status.PASS,"AER Classification Type Selection Test Pass");
        test.addScreenCaptureFromPath(Capture_Screenshot("3", "AER Classification"));
    }
    
    
    
    @Test(priority=4)
    public void testCaseIntake() throws AWTException, InterruptedException, IOException {
        test = extentreport.createTest("Case Intake Test");
        CaseIntake inTake=new CaseIntake(driver);
        inTake.NavigateToFullDateEntry();
        test.log(Status.PASS,"CaseIntake Test Pass");
        test.addScreenCaptureFromPath(Capture_Screenshot("4", "CaseIntake"));
    }
        
      
       
    @Test(priority=5)
    public void testFullDataEntry() throws IOException {
        test = extentreport.createTest("Full Data Entry Test");
        test.log(Status.PASS,"FullDataEntry Test Pass");
        test.addScreenCaptureFromPath(Capture_Screenshot("5", "FullDataEntry"));
    }
    
    
    /* 
    @Test
    public void testCase4() {
        test = extentreport.createTest("Test Case 4", "PASSED test case");
        Assert.assertTrue(false);
    }
     
    @Test
    public void testCase5() {
        test = extentreport.createTest("Test Case 5", "SKIPPED test case");
        throw new SkipException("Skipping this test with exception");
    }
    
    @Test(enabled=false)
	public void testCase6(){
			test = extentreport.createTest("Test Case 6", "I'm Not Ready, please don't execute me");
		}
   
     */

}
