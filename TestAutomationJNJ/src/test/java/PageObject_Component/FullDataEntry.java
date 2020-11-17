package PageObject_Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		objCountrySelect.selectByVisibleText(Country);
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
		
		
		/*driver.switchTo().frame("AerFrame1");
		
		Thread.sleep(1000);
		productDescription.click();
		productDescription.sendKeys(caseProduct);
		Thread.sleep(1000);*/
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('115103').click;");
		js.executeScript("document.getElementById('115103').value='"+caseProductValue+"'");
		js.executeScript("document.getElementById('115103').click;");
		
		  Actions act = new Actions(driver);
		   
		   act.sendKeys(Keys.TAB).build().perform();
		   act.sendKeys(Keys.TAB).build().perform();
		   act.sendKeys(Keys.TAB).build().perform();
		   act.sendKeys(Keys.RETURN).build().perform();
		   
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navig");
		Thread.sleep(1000);
		saveCase.click();
		
	}
	public void selectIndications() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("statusFrame2");
		Thread.sleep(1000);
		selectAll.click();
		selectOK.click();
	}
}
