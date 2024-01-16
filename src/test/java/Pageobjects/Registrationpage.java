package Pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Registrationpage extends Constructorclass  {

public Registrationpage(WebDriver driver) {
		super(driver);
	}
//generating elements
@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
@FindBy(xpath="//input[@id='input-email']") WebElement e_Mail;
@FindBy(xpath="//input[@id='input-password']") WebElement password;
@FindBy(xpath="//input[@name='agree']") WebElement check_box;

@FindBy(xpath="//button[text()='Continue']") WebElement submit_button;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Confirmationobject;

//performing actions
public void enterfirstname(String fname) {
	firstName.sendKeys(fname);
}
public void enterlastname(String lname) {
	lastName.sendKeys(lname);	
}
public void entere_mail(String email) {
	e_Mail.sendKeys(email);
}
public void enterpassword(String passwords) {
	password.sendKeys(passwords);
}
public void clickoncheckbox(){
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",check_box);
	//Thread.sleep(4000);
	 //check_box.click();
	//Actions ac=new Actions(driver);
	//ac.moveToElement(check_box).click().build().perform();
}
	public void clicksubmit() {
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",submit_button);
		//submit_button.sendKeys(Keys.RETURN);
		submit_button.submit();
	}
	public String confirmation() {
		return Confirmationobject.getText();
	}
	



}
