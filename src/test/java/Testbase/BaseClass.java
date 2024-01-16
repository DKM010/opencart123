package Testbase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public Logger logger;
	
	public Properties p;
	
     public static WebDriver driver;
     
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"browser","os"})
	public void setup(String browser,String os) throws IOException {
		//adding property file data into base method-
		FileReader file=new FileReader(".\\src\\test\\resources\\commondata.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		//validating both OS and browser parameters through remote environment---
		if(p.getProperty("Execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
                  cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) 
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("unix"))
			{
			cap.setPlatform(Platform.UNIX);	
			}
			else 
			{
			System.out.println("os not matched");
			return;
			}
		
			switch(browser.toLowerCase())
			{
				case "chrome":cap.setBrowserName("chrome"); break;
				case "firefox":cap.setBrowserName("firefox");break;
				case "edge":cap.setBrowserName("microsoftedge");break;
				default:System.out.println("browser not matched");
				return;	
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
		}
		
		//validating browser parameters through local environment---------
		if(p.getProperty("Execution_env").equalsIgnoreCase("local")) 
    {
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver(); 
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("browser mismatched and test failed");
			return;
		}
	}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("APPURL"));
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void exit() {
		driver.quit();
	}

public String randomAlphabet1() {
	String randomalphabet=RandomStringUtils.randomAlphabetic(5);
	return randomalphabet;
}
public String randomAlphabet2() {
	String randomalphabet=RandomStringUtils.randomAlphabetic(8);
	return randomalphabet;
}

public String randomnumber() {
	String randomnumber=RandomStringUtils.randomNumeric(10);
	return randomnumber;
}
public String randomalphanumeric() {
	String alphabetic=RandomStringUtils.randomAlphabetic(7).toLowerCase();
	String numeric=RandomStringUtils.randomNumeric(6);
	return(alphabetic+"@"+numeric);
}

 public String captureScreen() throws IOException {
	 TakesScreenshot sshot=(TakesScreenshot)driver;
	String base64_file=sshot.getScreenshotAs(OutputType.BASE64);
	return base64_file;
}
	
 
}

