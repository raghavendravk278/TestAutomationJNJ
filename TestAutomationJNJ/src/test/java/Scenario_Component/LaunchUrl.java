package Scenario_Component;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Generic_Component.Base_Class;
import PageObject_Component.AERRegistrationinformation;
import PageObject_Component.AER_Registration;
import PageObject_Component.CaseIntake;
import PageObject_Component.FullDataEntry;


public class LaunchUrl extends Base_Class {
		  
    @Test(priority=1)
	public void testLaunchUrl() throws IOException {
    	test=extentreport.createTest("LaunchUrlTest");	
		test.log(Status.PASS, "Executing the TestCase "+"1" + "Order set is "+"Order_Set");
		test.addScreenCaptureFromPath(Capture_Screenshot("1", "LaunchUrl"));
		//validateWindow();
				
	}
    
    @Test(priority=2,dependsOnMethods = { "testLaunchUrl" },dataProvider="dp_Userlogin",dataProviderClass=DataProvider_Component.Testdataprovider.class)
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
    
    test.addScreenCaptureFromPath(Capture_Screenshot("2", "LoginLogout"));
   
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
    
    }
    driver.switchTo().window(currentWindow);//switch back to original window
    System.out.println("Switching Original ");
    System.out.println("After Swiching Current Window is"+currentWindow);
      
    test.log(Status.PASS, "Executing the TestCase "+TC_ID + "Order set is "+"Order_Set");
    test.addScreenCaptureFromPath(Capture_Screenshot("2", "LoginLogout"));
   
    }
    
  
    @Test(priority=3,dependsOnMethods = { "testLoginLogout" })
    public void testAerRegistration() throws IOException, InterruptedException {
        test = extentreport.createTest("AER Classification Type Selection Test");
       
        Thread.sleep(2000);
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
    
    
    
    @Test(priority=4,dependsOnMethods = { "testAerRegistration" })
    public void testCaseIntake() throws AWTException, InterruptedException, IOException {
        test = extentreport.createTest("Case Intake Test");
        CaseIntake inTake=new CaseIntake(driver);
        inTake.NavigateToFullDateEntry();
        test.log(Status.PASS,"CaseIntake Test Pass");
        test.addScreenCaptureFromPath(Capture_Screenshot("4", "CaseIntake"));
    }
        
      
       
    @Test(priority=5,dependsOnMethods = { "testCaseIntake" },dataProvider="dp_Casecreation",dataProviderClass=DataProvider_Component.Testdataprovider.class)
    public void testFullDataEntry(Map<String,String> Case) throws IOException, InterruptedException {
        test = extentreport.createTest("Full Data Entry Test");
        FullDataEntry fde=new FullDataEntry(driver);
        String TC_ID = Case.get("TC_ID");
        String Primary_SrcCountry=Case.get("Primary_SrcCountry");
    	String Reported_term = Case.get("Reported_term");		
    	String Product_Description = Case.get("Product_Description");
        
    	System.out.println(TC_ID+Primary_SrcCountry+Reported_term+Product_Description);
    	fde.setPriSrcCountry(Primary_SrcCountry);
    	
        fde.setLRDate();
        test.addScreenCaptureFromPath(Capture_Screenshot("5", "FullDataEntry1"));
        fde.setEvent(Reported_term);
        test.addScreenCaptureFromPath(Capture_Screenshot("5", "FullDataEntry2"));
       fde.setProduct(Product_Description);
        test.addScreenCaptureFromPath(Capture_Screenshot("5", "FullDataEntry3"));
       //fde.selectIndications();
        //fde.getAERNO();
        fde.saveCase();
        fde.submitCase();
        Thread.sleep(2000);
        //((JavascriptExecutor)driver).executeScript("signOff();");
       // fde.logout();
        //fde.completeActivity();
        Thread.sleep(1000);
        //fde.closeAER();
      
        //fde.logout();
        //((JavascriptExecutor)driver).executeScript("signOff();");
        test.log(Status.PASS,"FullDataEntry Test"+TC_ID+ "Pass");
        test.addScreenCaptureFromPath(Capture_Screenshot("5", "FullDataEntry4"));
    }
    
    

    @Test(priority=6,dependsOnMethods = { "testFullDataEntry" })
    public void testAERRegistrationInformation() throws IOException, InterruptedException {
        test = extentreport.createTest("RegistrationInformation test case");
        AERRegistrationinformation AERinfo=new AERRegistrationinformation(driver);
        AERinfo.navigateREGInfo();
        AERinfo.getCaseNumber();
        test.addScreenCaptureFromPath(Capture_Screenshot("6", "RegistrationInformation1"));
        FullDataEntry fde=new FullDataEntry(driver);
        fde.logout();
        fde.completeActivity();
        Thread.sleep(1000);
        fde.closeAER();
        test.log(Status.PASS,"RegistrationInformation Test"+"Pass");
        test.addScreenCaptureFromPath(Capture_Screenshot("6", "RegistrationInformation2"));  
    }
   
}
