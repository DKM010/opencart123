package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Constructorclass {
public Homepage(WebDriver driver) {
		super(driver);
	}
//generating hompage elements


@FindBy(xpath="//i[@class='fa-solid fa-user']") WebElement myAccount;

@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;

@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']") WebElement login;

//methods
public void clickonaccount() {
myAccount.click();
}
public void clickonregister() {
register.click();
}
public void click_on_login() {
	login.click();
}
}
