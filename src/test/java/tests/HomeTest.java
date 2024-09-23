package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import Constants.FileConstants;
import Pages.HomePage;
import Pages.LoginPage;
import listeners.listeners;
import utils.CommonUtils;
import utils.FileUtils;

@Listeners(listeners.class)
public class HomeTest extends BaseTest {

	@org.testng.annotations.Parameters ({"browserName" , "isHeadless"}) 
	@BeforeMethod
	public void preCondition(@Optional("chrome") String bName, @Optional("false") boolean isHeadless) throws IOException
	{
		BaseTest.setDriver(bName, isHeadless);
		logger.info("UserMenuDropdownTest : precondition : ");
		
		System.out.println("Before Test");
	}
	
	
    @Test
    
    public void selectUserMenu_TC05() throws IOException
    {
    	WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
    	HomePage hp = new HomePage(driver);
		hp.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(hp.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems verified successfully");
    }
	
	@Test
	
	public void selectMyProfile_TC06() throws IOException, InterruptedException
	{
		System.out.println("Test Methods");
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
	    HomePage hp = new HomePage(driver);
		hp.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(hp.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems are veified");
		Assert.assertTrue(hp.selectUserMenuOption(driver, "My Profile"),"UserMenu option should be selected");
		CommonUtils.waitForElement(driver,hp.myProfile );
		test.info("Waiting for My Profile page");
		Assert.assertTrue(hp.isMyProfilePageDisplayed(), "Failed to load My Profile page");
		test.info("My profile page is displayed successfully");
		hp.clickEditIcon(driver);
		Assert.assertTrue(hp.verifyEditContactIframe(driver), "Failed to load iFrame");
		test.info("Contact is edited successfully");
		Assert.assertTrue(hp.verifyLastnameChangeInAboutTab(driver,FileUtils.readUserMenuTestData("user.lastname")));
		test.info("Lastname changed successfully");
		Assert.assertTrue(hp.verifyCreatePost(driver,FileUtils.readUserMenuTestData("post.message")));
		test.info("New post created");
		Assert.assertTrue(hp.verifyFileUpload(driver, FileConstants.TEST_FILE_PATH));
		test.info("File is uploaded successfully");
		Assert.assertTrue(hp.verifyPhotoUpload(driver, FileConstants.PHOTO_FILE_PATH));
		test.info("VerifyPhotoUpload done successfully");
		
	}

	
  @Test
	
	public void selectMySettings_TC07() throws IOException, InterruptedException
	{
	  	WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		HomePage hp = new HomePage(driver);
		hp.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(hp.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems are verified");
		Assert.assertTrue(hp.selectUserMenuOption(driver, "My Settings"),"My Settings option is selected from UsermenuItems");
		CommonUtils.waitForElement(driver,hp.mySettings);
		test.info("Waiting for my settings page");
		Assert.assertTrue(hp.isMySettingsPageDisplayed(), "Failed to load My Settings Page");
		test.info("My Settings page is displayed successfully");
		hp.verifyLoginHistory(driver);
		test.info("Login history is downloaded");
		hp.verifyDisplayAndLayoutLink(driver);
		test.info("Reports tab is added to the main tab");
		Assert.assertTrue(hp.verifyEmailSetting(driver,FileUtils.readUserMenuTestData("email.name"),FileUtils.readUserMenuTestData("email.address")));
		test.info("Verification email is sent");
		Assert.assertTrue(hp.verifyCalendarandRemainder(driver), "Event pop up window not displayed");
		test.info("VerifyCalendarandRemainder done successfully");
	}
		
	
	@Test
	
	public void selectDeveloperConsole_TC08() throws IOException, InterruptedException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		HomePage hp = new HomePage(driver);
		hp.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(hp.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems verified successfully");
		Assert.assertTrue(hp.selectUserMenuOption(driver, "Developer Console"),"");
		test.info("Developer console option selected");
		Assert.assertTrue(hp.verifyDeveloperConsole(driver));
		test.info("Developer window functionality verified");
		
	}
	
	@Test
	
	public void selectLogout_TC09() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		hp.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(hp.verifyUserMenuItems(), "Failed to verify");
		test.info("Usermenu Items verified");
		Assert.assertTrue(hp.selectUserMenuOption(driver, "Logout"),"");
		test.info("Logout option selected");
		test.info("Logged out successfully");
		
	}
}