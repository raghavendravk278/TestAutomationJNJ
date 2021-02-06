package PageObject_Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Component.Base_Class;

public class FullDataEntry extends Base_Class {
	private WebDriver driver;
	public FullDataEntry(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	@FindBy(xpath="//input[@name='/I=101104/G=10101/D=TI/']")
	private WebElement lrDate;
	
	@FindBy(xpath="//select[@name='/I=101106/G=10101/D=C/']")
	private WebElement priSrcCountry;
	
	@FindBy(xpath="//a[@id='p1tab4']")
	private WebElement event;
	
	@FindBy(xpath="//a[@id='p1tab3']")
	private WebElement product;
	
	@FindBy(xpath="//input[@name='/I=106501/G=10602/D=C/CA=U/AUTOCODE=1/']")
	private WebElement reportedTerm;
	
	@FindBy(xpath="//input[@id='115103']")
	private WebElement productDescription ;
	
	@FindBy(xpath="//img[@src=\"/Aris/images/top_menu_icons/save.png\"]")
	private WebElement saveCase;
	
	@FindBy(xpath="//input[@value='Select All']")
	private WebElement selectAll;
	

	@FindBy(xpath="//input[@value='OK']")
	private WebElement selectOK;
	
	@FindBy(xpath="//input[@id='yes']")
	private WebElement submitCase;
	
	@FindBy(xpath="//input[@id='no']")
	private WebElement completeActivity;
	
	@FindBy(xpath="//input[@id='yes']")
	private WebElement closeAER;
	
	@FindBy(xpath="//*[@id='svg_31']")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//input[@id='AerNo']")
	private WebElement AerNo;
	
	@FindBy(xpath="//div[@id='caseInfo']")
	private WebElement AerNo1;
	
	@FindBy(xpath="//input[@name='/I=101002/G=10101/D=C/CA=U/']")
	private WebElement AerNo3;
	
	public void setLRDate() {
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
		
		String str=df.format(date);
		lrDate.sendKeys(str);
		
	}
	
	public void setPriSrcCountry(String Country) throws InterruptedException  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("space");
		Thread.sleep(1000);
		
		driver.switchTo().frame("AerFrame1");
		
		Thread.sleep(1000);
		
		Select objCountrySelect=new Select(priSrcCountry);
		//objCountrySelect.selectByIndex(1);
		objCountrySelect.selectByVisibleText(Country.toString());
	}

	
	public void setEvent(String caseEvent) throws InterruptedException {
		Thread.sleep(1000);
		event.click();
		Thread.sleep(1000);
		reportedTerm.sendKeys(caseEvent);
		
	}
	
	public void setProduct(String caseProduct) throws InterruptedException {
		
		String caseProductValue=caseProduct;
		product.click();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("space");
		Thread.sleep(1000);
		driver.switchTo().frame("AerFrame1");
		
		Thread.sleep(1000);
		productDescription.click();
		productDescription.sendKeys(caseProductValue);
		productDescription.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		   
		
		
		
	}
	public void selectIndications() throws InterruptedException {
		Thread.sleep(2000);
		String currentWindow = driver.getWindowHandle();// get handle of current window
	    System.out.println("Current Window of Product Secton is"+currentWindow);
	    
		Set<String> handles = driver.getWindowHandles();// get handle of all windows
		System.out.println(handles.size());
		System.out.println(handles);
		for(String window: handles) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains("Applicable Indications")) {
				System.out.println(driver.getTitle());
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("statusFrame2");
				Thread.sleep(2000);
				selectAll.click();
				selectOK.click();
				
				Thread.sleep(1000);
				driver.switchTo().window(currentWindow);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("navig");
				Thread.sleep(1000);
				saveCase.click();
				Thread.sleep(2000);
				
				
			}
		}
		
		
	}
	public void saveCase() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navig");
		Thread.sleep(1000);
		saveCase.click();
	}
	public void getAERNO() throws InterruptedException {
		Thread.sleep(2000);
	
		
	}
	public void submitCase() throws InterruptedException {
		Thread.sleep(3000);
		String currentWindow = driver.getWindowHandle();// get handle of current window
	    System.out.println("Current Window of Product Secton 2 is"+currentWindow);
	    
		Set<String> handles = driver.getWindowHandles();// get handle of all windows
		//System.out.println(handles.size());
		//System.out.println(handles);
		for(String window: handles) {
			driver.switchTo().window(window);
			
			if(driver.getTitle().equals("ARISg7")) {
				System.out.println(driver.getTitle());
				System.out.println("Found");			
				Thread.sleep(2000);
				submitCase.click();
				
			   }
		
	           }//end of for loop
		
		driver.switchTo().window(currentWindow);
               }

	public void completeActivity() throws InterruptedException {
		Thread.sleep(2000);
		String currentWindow = driver.getWindowHandle();// get handle of current window
	    System.out.println("Current Window of Product Secton 3 is"+currentWindow);
	    
		Set<String> handles = driver.getWindowHandles();// get handle of all windows
		//System.out.println(handles.size());
		//System.out.println(handles);
		for(String window: handles) {
			driver.switchTo().window(window);
			
			if(driver.getTitle().equals("ARISg7")) {
				System.out.println(driver.getTitle());
				System.out.println("Found");			
				Thread.sleep(2000);
				completeActivity.click();
				
			   }
		
	           }//end of for loop
		
		driver.switchTo().window(currentWindow);
               }
	
	public void closeAER() throws InterruptedException {
		Thread.sleep(2000);
		String currentWindow = driver.getWindowHandle();// get handle of current window
	    System.out.println("Current Window of Product Secton 3 is"+currentWindow);
	    
		Set<String> handles = driver.getWindowHandles();// get handle of all windows
		System.out.println(handles.size());
		System.out.println(handles);
		for(String window: handles) {
			driver.switchTo().window(window);
			
			if(driver.getTitle().equals("ARISg7")) {
				System.out.println(driver.getTitle());
				System.out.println("Found");			
				Thread.sleep(2000);
				closeAER.click();
				
			   }
		
	           }//end of for loop
		
		driver.switchTo().window(currentWindow);
               }
	
	
	public void logout()  {
		driver.switchTo().defaultContent();
	    driver.switchTo().frame("navig");
		logoutBTN.click();
	}

}
