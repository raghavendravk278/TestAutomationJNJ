package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Generic_Component.Base_Class;


public class LaunchUrl extends Base_Class {
	
	

		  
    @Test
	public void testLogin() throws IOException {
    	test=extentreport.createTest("LoginTest");	
		test.log(Status.PASS, "Executing the TestCase "+"1" + "Order set is "+"Order_Set");
		//extenttest.log(Status.PASS, extenttest.addScreencastFromPath(Capture_Screenshot("1", "Order_Set"));
		test.addScreenCaptureFromPath(Capture_Screenshot("1", "Order_Set"));
		validateWindow();		
		
	}
    
    @Test(dataProvider="dp_Validsearch",dataProviderClass=DataProvider_Component.Testdataprovider.class)
    
	public void testCase1(Map<String,String> Search) {
        test = extentreport.createTest("Test Case 1", "PASSED test case");
        Assert.assertTrue(true);
        String TC_ID = Search.get("TC_ID");
    	String Order_Set = Search.get("Order_Set");		
    	String Search_Item = Search.get("Search_Item");
        //Reporter.log(TC_ID+Order_Set+Search_Item);
        //System.out.println(TC_ID+Order_Set+Search_Item);
        test.log(Status.PASS,"Excel"+ TC_ID+Order_Set+Search_Item);
    }
    /*
    @Test
    public void testCase2() {
        test = extentreport.createTest("Test Case 2", "PASSED test case");
        Assert.assertTrue(true);
    }
    
    @Test
    public void testCase3() {
        test = extentreport.createTest("Test Case 3", "PASSED test case");
        Assert.assertTrue(true);
    }
     
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
