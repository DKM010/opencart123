package Pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpageobject extends Constructorclass {
public MyAccountpageobject(WebDriver driver) {
		super(driver);
}
//----generating elements----
@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myAccount;
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;

//----executing action----
public boolean my_account() {
	try {
	return myAccount.isDisplayed();
	}
	catch(Exception e) 
	{
	return false;
	}
}
public void logout() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",logout);
}



}
