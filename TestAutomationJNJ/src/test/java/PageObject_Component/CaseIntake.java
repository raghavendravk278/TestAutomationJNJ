package PageObject_Component;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_Class;

public class CaseIntake extends Base_Class {

	private WebDriver driver;
	
	@FindBy(xpath="//li[@id='formsMenu']")
	private WebElement fMenu;
	
	@FindBy(xpath="//li[@id='1427']")
	private WebElement generalMenu;
	
	public CaseIntake(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public void NavigateToFullDateEntry() throws AWTException, InterruptedException {
		  
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navig");
		Thread.sleep(1000);
		fMenu.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("space");
		Thread.sleep(1000);
		generalMenu.click();
		
		/*
		Actions action=new Actions(driver);
		action.moveToElement(fMenu).click().perform();
		
		Robot robot=new Robot();
	    robot.setAutoDelay(250);
	    robot.keyPress(KeyEvent.VK_ALT);
	    Thread.sleep(1000);
	    robot.keyPress(KeyEvent.VK_F);
	    Thread.sleep(1000);
	    
	    robot.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_ALT);
	    Thread.sleep(1000);
	      
	  
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    Thread.sleep(1000);
	    robot.keyPress(KeyEvent.VK_SHIFT);
	    Thread.sleep(1000);
	    
	    robot.keyPress(KeyEvent.VK_G);
	    Thread.sleep(1000);
	    
	    
	    
	    robot.keyRelease(KeyEvent.VK_G);
	    robot.keyRelease(KeyEvent.VK_SHIFT);
	    robot.keyRelease(KeyEvent.VK_CONTROL);*/
	}
}
