package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpageobjectclass extends Constructorclass {
	
	public Loginpageobjectclass(WebDriver driver){
		super(driver);
	}
	//generating loginpage elements
@FindBy(xpath="//input[@id='input-email']") WebElement MailAddress;
@FindBy(xpath="//input[@id='input-password']") WebElement Password;
@FindBy(xpath="//button[normalize-space()='Login']") WebElement submit;

@FindBy(xpath="//div[@id='alert']") WebElement login_failed_error_msg;

//executing action--
public void enter_mail_id(String mail_id) {
	MailAddress.sendKeys(mail_id);
}
	public void enter_password(String password) {
		Password.sendKeys(password);	
	}
	public void submit() {
		submit.click();
	}
	
	public boolean error_msg() {
		return login_failed_error_msg.isSelected();	
	}
	
	
	
	
}
