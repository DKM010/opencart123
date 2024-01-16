package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Constructorclass {
 WebDriver driver;
public Constructorclass(WebDriver driver){
this.driver=driver;	
PageFactory.initElements(driver, this);
}
}
