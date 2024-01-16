package Testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import Pageobjects.Homepage;
import Pageobjects.Registrationpage;
import Testbase.BaseClass;

public class Tc_001_registeration extends BaseClass {
@Test(groups={"sanity","master"})

void testmethod(){
	
	logger.info("*****starting testcase no1*****");
	logger.debug("***Starting testcase_no_1***");
Homepage hp=new Homepage(driver);
try {
hp.clickonaccount();
logger.info("clicked on account completed");

hp.clickonregister();
logger.info("clicked on register completed");

logger.info("Entering customers details");
Registrationpage rp=new Registrationpage(driver);

rp.enterfirstname(randomAlphabet1().toLowerCase());
rp.enterlastname(randomAlphabet2().toLowerCase());
rp.entere_mail(randomAlphabet2().toLowerCase()+"@gmail.com");
rp.enterpassword(randomalphanumeric());
rp.clickoncheckbox();
logger.info("clicked on checkbox completed");

rp.clicksubmit();
logger.info("clicked on submit completed");

if(rp.confirmation().equals("Your Account Has Been Created")) 
{
	Assert.assertTrue(true);
	logger.info("Test passed");
}
else
{
	logger.info("Test failed due to act_result and exp_result mismatch");
	Assert.fail();	
}
}
catch(Exception e) 
{
	Assert.fail();
	logger.info("test failed due to exception");
}
logger.info("******Test case_1_Registaration_completed******");
logger.debug("debug completed");
}
}
 







