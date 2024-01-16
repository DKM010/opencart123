package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.Homepage;
import Pageobjects.Loginpageobjectclass;
import Pageobjects.MyAccountpageobject;
import Testbase.BaseClass;

public class Tc_002_login extends BaseClass{
@Test(groups={"sanity","regression","master"})
void loginaction() throws InterruptedException {
	logger.info("***testing testcase_2***");
	Homepage hp=new Homepage(driver);
	hp.clickonaccount();
	hp.click_on_login();
	
	Loginpageobjectclass lp=new Loginpageobjectclass(driver);
	lp.enter_mail_id(p.getProperty("Login_GMAIL"));
	lp.enter_password(p.getProperty("LOGIN_PASSWORD"));
	lp.submit();

MyAccountpageobject mo=new MyAccountpageobject(driver);
	Assert.assertTrue(mo.my_account());
	Thread.sleep(2000);
	mo.logout();
	logger.info("testing ended");
	
}
}
