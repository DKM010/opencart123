package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.Homepage;
import Pageobjects.Loginpageobjectclass;
import Pageobjects.MyAccountpageobject;
import Testbase.BaseClass;
import Utilities.Dataproviders;
public class Tc_003_login_dataprovider extends BaseClass
{
	
	@Test(dataProvider="logindata",groups="master",dataProviderClass=Dataproviders.class)
	public void login_dataprovider(String userid,String password,String exp_result) throws IOException, InterruptedException 
	{
		logger.info("*************Starting login using dataProvider*************");
		
		Homepage hp=new Homepage(driver);
		hp.clickonaccount();
		hp.click_on_login();
	     Loginpageobjectclass lp=new Loginpageobjectclass(driver);
	     lp.enter_mail_id(userid);
		lp.enter_password(password);
		lp.submit();
		
		MyAccountpageobject mo=new MyAccountpageobject(driver);
		boolean my_account=mo.my_account();
		
		if(exp_result.equalsIgnoreCase("valid"))
		{
			if(my_account==true) 
			{
				mo.logout();
			Assert.assertTrue(true);	
		    }
			else 
			{
				Assert.fail();	
			}
	     }
		if(exp_result.equalsIgnoreCase("invalid"))
		{
			if(my_account==true)
			{
				mo.logout();
				Assert.fail();
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		 logger.info("*************finished login using dataProvider*************");
	}			

} 
