package testAutomation;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Q1 extends WebElements {
	WebDriver driver;
	
	@BeforeTest
	public void setBaseURL() {
		//for ChromeDriver
				System.setProperty("webdriver.chrome.driver", "OZGUNCAN_ULUSOY\\selenium\\drivers\\chromedriver-win64\\chromedriver.exe");
				//Create a map to store  preferences 
				Map<String, Object> prefs = new HashMap<String, Object>();
				    
				//add key and value to map as follow to switch off browser notification
				//Pass the argument 1 to allow and 2 to block
				prefs.put("profile.default_content_setting_values.notifications", 2);
				    
				//Create an instance of ChromeOptions 
				ChromeOptions options = new ChromeOptions();
				    
				// set ExperimentalOption - prefs 
				options.setExperimentalOption("prefs", prefs);
				    
				//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
				driver = new ChromeDriver(options);

		//for GeckoDriver
			//	System.setProperty("webdriver.gecko.driver", "OZGUNCAN_ULUSOY\\selenium\\\\drivers\\geckodriver.exe");
			//	WebDriver driverGecko=new FirefoxDriver();

				driver.get("https://useinsider.com/");
		
		
	}
	
	@Test
	public void test() throws Exception {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions a =new Actions(driver);
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	assertionOfNavigation (driver);
	clickCompany(driver);
	clickCareer(driver);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	checkBanner(driver);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	js.executeScript("window.scrollBy(0,250)");
	checkTeamBlock(driver);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	js.executeScript("window.scrollBy(250,400)");
	checkLocationsBlock(driver);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	js.executeScript("window.scrollBy(400,550)");
	checkLifeBlock(driver);
	driver.get("https://useinsider.com/careers/quality-assurance/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	clickAllQAJobs(driver);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Thread.sleep(13000);
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	clickJobLocations(driver);
	Thread.sleep(5000);
	a.moveByOffset(280, 370).click().build().perform();
	Thread.sleep(5000);
	
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,550)");
	checkJobList(driver);
	
	Thread.sleep(5000);
	checkJobs(driver);
	
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	
	clickViewRoleButton(driver);
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    clickDismissRoleButton(driver);
	checkApplyJobFormButton(driver);
	
	}
	@AfterTest
	public void endSessions() throws IOException {
		
		driver.quit();
		
	}
}
