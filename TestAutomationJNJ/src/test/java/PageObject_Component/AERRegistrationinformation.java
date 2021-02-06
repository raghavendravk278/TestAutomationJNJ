package PageObject_Component;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_Class;
import Generic_Component.ExcelReadWrite;

public class AERRegistrationinformation extends Base_Class {
	private WebDriver driver;
	
	public AERRegistrationinformation(WebDriver driver) {
			
			PageFactory.initElements(driver,this);
			this.driver=driver;
	}
	@FindBy(xpath="//li[@id='formsMenu']")
	private WebElement fMenu1;
	
	@FindBy(xpath="//li[@id='3001']")
	private WebElement caseMenu;	

    @FindBy(xpath="//input[@name='/I=101002/G=10101/D=C/CA=U/']")
    private WebElement AerNo;

	

	public void navigateREGInfo() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Navigating to Registration Info");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navig");
		Thread.sleep(1000);
		fMenu1.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("space");
		Thread.sleep(1000);
		caseMenu.click();
	}
	public void getCaseNumber() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("space");
		Thread.sleep(2000);
	    driver.switchTo().frame("AerFrame1");
		String AERValue=AerNo.getAttribute("oldvalue");
		System.out.println("AER Number"+AERValue);
		ExcelReadWrite write =new ExcelReadWrite("TestData/AER_NUMBER.xls");
		//HSSFSheet wSheet=write.Setsheet("Aer_Sheet");
		//wSheet.get
		write.writecell(write.Setsheet("Aer_Sheet"),0,0,AERValue);
	}
}
