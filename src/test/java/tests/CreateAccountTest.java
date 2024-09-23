package tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import Pages.CreateAccountPage;
import Pages.LoginPage;
import listeners.listeners;
import utils.CommonUtils;
import utils.FileUtils;


	@Listeners(listeners.class)
	public class CreateAccountTest extends BaseTest{
		

		
		@BeforeMethod
		public void preCondition(@Optional("chrome") String bName, @Optional("false") boolean isHeadless) throws IOException
		{
			BaseTest.setDriver(bName, isHeadless);
			logger.info("CreateAccountTest : precondition : ");
			System.out.println("Before Test");
		}
		
		@AfterMethod
		public void closeDriver()
		{
			WebDriver driver = BaseTest.getDriver();
			driver.close();
		}
		
		@Test(priority=1)
		
		public void createAccount_TC10() throws IOException
		{
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			lp.loginPage(driver);
			CreateAccountPage cp = new CreateAccountPage(driver);
			cp.clickallLink(driver);
			cp.clickAccountsLink(driver);
			Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
			test.info("My Accounts page is displayed");
			Assert.assertTrue(cp.verifyAccountsPage(driver,FileUtils.readCreateAccountTestData("account.name")));
			test.info("Accounts page is verified");
		}
		
		@Test(priority=2)
		
		public void createNewView_TC11() throws IOException
		{
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			lp.loginPage(driver);
			CreateAccountPage cp = new CreateAccountPage(driver);
			cp.clickallLink(driver);
			cp.clickAccountsLink(driver);
			Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
			test.info("My Accounts page is displayed");
			Assert.assertTrue(cp.verifyCreateViewPage(driver,FileUtils.readCreateAccountTestData("view.name")));
			test.info("Create view page verified");
		}
		
		@Test(priority=3)
		
		public void editView_TC12() throws IOException, InterruptedException
		{
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			lp.loginPage(driver);
			CreateAccountPage cp = new CreateAccountPage(driver);
			cp.clickallLink(driver);
			cp.clickAccountsLink(driver);
			Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
			test.info("My Accounts page is displayed");
			cp.verifyEditViewPage(driver,FileUtils.readCreateAccountTestData("view.name"),FileUtils.readCreateAccountTestData("newView.name"),FileUtils.readCreateAccountTestData("value"));
			test.info("Edit view page verified");
		}
		
		@Test(priority=4)
		
		public void mergeAccount_TC13() throws IOException
		{
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			lp.loginPage(driver);
			CreateAccountPage cp = new CreateAccountPage(driver);
			cp.clickallLink(driver);
			cp.clickAccountsLink(driver);
			Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
			test.info("My Accounts page is displayed");
			Assert.assertTrue(cp.verifyMergeAccountPage(driver, FileUtils.readCreateAccountTestData("search.name")),"Failed to verify merged account");
			test.info("Merge account page verified");
		}
		
		@Test(priority=5)
		
		public void createAccountReport_TC14() throws IOException, InterruptedException
		{
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			lp.loginPage(driver);
			CreateAccountPage cp = new CreateAccountPage(driver);
			cp.clickallLink(driver);
			cp.clickAccountsLink(driver);
			Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
			test.info("My Accounts page is displayed");
			Assert.assertTrue(cp.verifyCreateAccountReport(driver,FileUtils.readCreateAccountTestData("report.name")));
			test.info("Create account report verified");
		}
	}
