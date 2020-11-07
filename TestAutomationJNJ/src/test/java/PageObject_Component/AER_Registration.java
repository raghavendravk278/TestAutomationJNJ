package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_Class;

public class AER_Registration extends Base_Class {

@FindBy(xpath="//img[@src=\"/Aris/images/top_menu_icons/new.png\"]")
private WebElement newCase;

@FindBy(xpath="//input[@name=\"/I=101132/G=10101/D=C/\"]")
private WebElement classificationType;

@FindBy(xpath="//input[@name=\"/I=1011/\"]")
private WebElement classificationConfirm;

public AER_Registration(WebDriver driver) {
	
	PageFactory.initElements(driver,this);
	
}

public void createNewCase() {
	newCase.click();
}
public void classificationType() {
	classificationType.click();
}

public void confirmClassification() {
	classificationConfirm.click();
}


}
