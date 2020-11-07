package PageObject_Component;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Component.Base_Class;

public class LoginLogout extends Base_Class{
//private WebDriver driver;

@FindBy(name="userId")
private WebElement unTB;
@FindBy(name="password")
private WebElement pwTB;

@FindBy(linkText="Login")
private WebElement loginBTN;

@FindBy(xpath="//td[@class='pageTitle']")
private WebElement homePage;


@FindBy(xpath="//*[@id='svg_31']")
private WebElement logoutBTN;

@FindBy(xpath="//div/a/img[@title=\"New\"]")
private WebElement newBTN;

@FindBy(id="searchAER")
private WebElement searchAER;

@FindBy(xpath="//img")
private WebElement classificationType;

public LoginLogout(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	//this.driver=driver;
}
@FindBy(name="dbnames")
private WebElement dbName;

public void selectDB(String databaseName) {
	Select objSelect=new Select(dbName);
	objSelect.selectByVisibleText(databaseName);
}
public void login(String un,String pwd)
{
unTB.sendKeys(un);
pwTB.sendKeys(pwd);
loginBTN.click();
}

public void logout() {
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	homePage.click();
		
	//newBTN.click();
	//Explicit_wait(logoutBTN,30);
	//classificationType.click();
	
	logoutBTN.click();
}
}
