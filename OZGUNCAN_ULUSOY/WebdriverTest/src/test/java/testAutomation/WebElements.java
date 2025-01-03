package testAutomation;


import org.testng.AssertJUnit;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;




public class WebElements  {
	
	
	
	public Integer i;
	public By title = By.xpath("//*[@id=\"navigation\"]/div[2]/a[1]");
	public By allow = By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]");
	public By company=By.xpath("/html/body/nav/div[2]/div/ul[1]/li[6]/a");
	public By career=By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]/div/div[2]/a[2]");
	public By banner=By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/h1");
	public By teamsBlock=By.xpath("/html/body/div[2]/div[2]");
	public By locationsBlock=By.xpath("/html/body/div[2]/section[3]");
	public By lifeBlock=By.xpath("/html/body/div[2]/section[4]");
	public By allQAJobs= By.xpath("/html/body/div[2]/section[1]/div/div/div/div[1]/div/section/div/div/div[1]/div/div/a");
	public By jobLocations=By.xpath("/html/body/section[2]/div/div/div[2]/div/form/div[1]/span/span[1]/span/span[2]/b");
	public By jobList=By.xpath("/html/body/section[3]/div/div/div[2]");
	public By jobCount=By.xpath("//*[@id=\"deneme\"]");
	public By jobNames = By.xpath("/html/body/section[3]/div/div/div[2]/div["+i+"]/div/p");
	public By jobDepartments = By.xpath("//*[@id=\"jobs-list\"]/div["+i+"]/div/span");
	public By jobLocationss = By.xpath("/html/body/section[3]/div/div/div[2]/div["+i+"]/div/div");
	public By viewRoleButton = By.xpath("//*[@id=\"jobs-list\"]/div[1]/div/a");
	public By dismissButton = By.xpath("/html/body/div[1]/div/div/div[2]/button");
	public By applyJobFormButton = By.xpath("/html/body/div[3]/div/div[1]/div/div[2]/a");
	
	
	public void assertionOfNavigation (WebDriver driver) {
		driver.findElement(title);
		driver.findElement(allow).click();
		
		AssertJUnit.assertTrue(driver.findElement(title).isDisplayed());
		
	}
	
	public void clickCompany(WebDriver driver) {
		
		driver.findElement(company).click();
	}
	
	public void clickCareer(WebDriver driver) {
		
		driver.findElement(career).click();
	}
	
	
	public void checkBanner(WebDriver driver) {
		
	AssertJUnit.assertTrue(driver.findElement(banner).isDisplayed());
	}
	
	
	public void checkTeamBlock(WebDriver driver) {
		AssertJUnit.assertTrue(driver.findElement(teamsBlock).isDisplayed());
	}
	
	public void checkLocationsBlock(WebDriver driver) {
		AssertJUnit.assertTrue(driver.findElement(locationsBlock).isDisplayed());
	}
	
	public void checkLifeBlock(WebDriver driver) {
		AssertJUnit.assertTrue(driver.findElement(lifeBlock).isDisplayed());
	}
	
	public void clickAllQAJobs(WebDriver driver) {
		
		driver.findElement(allQAJobs).click();
	}
	
	public void clickJobLocations(WebDriver driver) {
		
		driver.findElement(jobLocations).click();
	}
	
	public void checkJobList(WebDriver driver) {
		AssertJUnit.assertTrue(driver.findElement(jobList).isDisplayed());
	}
	
	public void checkJobs(WebDriver driver) {
		int job=Integer.parseInt(driver.findElement(jobCount).getText().toString());
		for(int i=1;i<=job;i++) 
		{	
		jobNames = By.xpath("/html/body/section[3]/div/div/div[2]/div["+i+"]/div/p");
		jobDepartments = By.xpath("//*[@id=\"jobs-list\"]/div["+i+"]/div/span");
		jobLocationss = By.xpath("/html/body/section[3]/div/div/div[2]/div["+i+"]/div/div");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		String jobName= driver.findElement( jobNames).getText();
		String jobDepartment=driver.findElement( jobDepartments).getText();
		String jobLocation=driver.findElement( jobLocationss).getText();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		System.out.println(jobName.toString());
		System.out.println(jobDepartment.toString());
		System.out.println(jobLocation.toString());
		if(jobName.contains("Quality Assurance")||jobName.contains("QA")) {
			System.out.println("Job Number "+i +"'s name is CORRECT!");
		}
		else {
			System.out.println("Job Number "+i +"'s name is WRONG!");
		}
		if(jobDepartment.contains("Quality Assurance")) {
			System.out.println("Job Number "+i +"'s department is CORRECT!");
		}
		else {
			System.out.println("Job Number "+i +"'s department is WRONG!");
		}
		if(jobLocation.contains("Istanbul, Turkey")) {
			System.out.println("Job Number "+i +"'s location is CORRECT!");
		}
		else {
			System.out.println("Job Number "+i +"'s location is WRONG!");
		}
		}
	}
		
	public void clickViewRoleButton(WebDriver driver) {
		
			driver.findElement(viewRoleButton).click();
		}
	
	public void clickDismissRoleButton(WebDriver driver) {
		
		driver.findElement(dismissButton).click();
	}
	
	public void checkApplyJobFormButton(WebDriver driver) {
		AssertJUnit.assertTrue(driver.findElement(applyJobFormButton).isDisplayed());
	}
}
