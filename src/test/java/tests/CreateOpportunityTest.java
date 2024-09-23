package tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import Pages.CreateOpportunityPage;
import Pages.LoginPage;
import utils.FileUtils;

public class CreateOpportunityTest extends BaseTest {
	

	
	@BeforeMethod
	public void preCondition(@Optional("chrome") String bName, @Optional("false") boolean isHeadless) throws IOException
	{
		BaseTest.setDriver("chrome",false);
		System.out.println("CreateOpportunityTestPage : precondition : ");
		System.out.println("Before Test");
	}
	
	@AfterMethod
	public void closeDriver()
	{
		WebDriver driver = BaseTest.getDriver();
		driver.close();
	}
	
	@Test
	
	public void selectOpportunityDropdown_TC15() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.clickall();
		cop.clickOpportunity();
		System.out.println("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		System.out.println("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyOpportunityDropdownItems(),"Failed to verify dropdown items");
		System.out.println("Verified opportunities dropdown items");
		
	}

	@Test
	
	public void verifyCreateNewOpportunity_TC16() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.clickall();
		cop.clickOpportunity();
		System.out.println("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		System.out.println("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyCreateNewOpportunity(driver,FileUtils.readCreateOpportunityTestData("opportunity.name"),FileUtils.readCreateOpportunityTestData("opportunity.accountName")));
		System.out.println("Create new opportunity verified");
	}
	
	@Test
	
	public void verifyOpportunityPipelineReport_TC17() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.clickall();
		cop.clickOpportunity();
		System.out.println("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		System.out.println("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyOpportunityPipeline(driver),"Failed to display opportunity pipeline page");
		System.out.println("Opportunity pipeline verified");
	}

	@Test
	
	public void verifyStuckOpportunityReport_TC18() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.clickall();
		cop.clickOpportunity();
		System.out.println("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		System.out.println("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyStuckOpportunityReport(driver),"Failed to display opportunity pipeline page");
		System.out.println("Verified stuck opportunity report");
	}
	
    @Test
	
	public void verifyQuarterlySummaryReport_TC19() throws IOException
	{
    	WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.clickall();
		cop.clickOpportunity();
		System.out.println("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		System.out.println("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyQuarterlySummaryReport(driver),"Failed to display opportunity pipeline page");
		System.out.println("Quarterly summary report verified");
	}

	
}