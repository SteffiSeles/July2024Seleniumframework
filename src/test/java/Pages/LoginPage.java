package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.CommonUtils;
import utils.FileUtils;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(name="Login")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id="error")
	public WebElement errorMessage;
	
	@FindBy(partialLinkText="Forgot")
	public WebElement forgotPassword;
	
	@FindBy(id="idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id="un")
	public WebElement forgotUsername;
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement usermenu;
	
	@FindBy(linkText="Logout")
	public WebElement logout;
	
	@FindBy(id="continue")
	public WebElement continueButton;
	

	
	public void enterUsername(String emailID)
	{
		logger.info("LoginPage : enterUsername : started");
		if(username.isDisplayed())
		{
			username.sendKeys(emailID);
		}
		else
		{
		logger.error("LoginPage : enterUsername : username not displayed");	
		}
	}
	
	public void enterPassword(String pass)
	{
		logger.info("LoginPage : enterPassword : started");
		if(password.isDisplayed())
		{
			password.sendKeys(pass);
		}
		else
		{
			logger.error("LoginPage : enterPassword : password not displayed");
		}
	}

	public void clickLoginButton()
	{
		logger.error("LoginPage : loginButton : loginButton click");
		if(loginButton.isDisplayed())
		{
			loginButton.click();
		}
		else
		{
			logger.error("LoginPage : loginButton : loginButton element not displayed");
		}
	}
	
	public void selectrememberMeCheckBox()
	{
		logger.error("LoginPage : checkbox: select checkbox");
		if(!rememberMe.isSelected())
		{
			rememberMe.click();
		}
		else
		{
			logger.info("LoginPage : checkbox: checkbox already selected");
		}
	}
	
	public String isLoginPageOpened(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public String isHomePageOpened(WebDriver driver)
	{
		return driver.getTitle();
	}
	public String isForgotPasswordPageOpened(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public String isPasswordResetMessagePageOpened(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public String getLoginErrorText()
	{
		logger.error("LoginPage : error message : login error text");
		if(errorMessage.isDisplayed())
		{
			return errorMessage.getText();
		}
		else
		{
			return null;
		}
	}
	
	
	public String getUsername()
	{
		return username.getAttribute("value");
	}
	public String getPassword()
	{
		return password.getText();
	}
	
	public void clickUserMenu()
	{
		if(usermenu.isDisplayed())
				{
			usermenu.click();
			
		}
		else
		{
			logger.error("HomePage : usermenu : usermenu element not found");
		}
	}
	public void clickLogout()
	{
		if(logout.isDisplayed())
		{
			logout.click();
		}
		else
		{
			logger.error("HomePage : logout : logout element not found");
		}
	}
	
	public void clickForgotPassword()
	{
		if(forgotPassword.isDisplayed())
		{
			forgotPassword.click();
		}
		else
		{
			logger.error("LoginPage : forgotPassword : forgotPassword element not found");
		}
	}
	
	public void enterUsernameToResetPassword(String userReset)
	{
		logger.info("ForgotPasswordPage : username : started");
		if(forgotUsername.isDisplayed())
		{
			forgotUsername.sendKeys(userReset);
		}
		else
		{
			logger.error("ForgotPasswordPage : forgotUsername : forgotUsername element not found");
		}
	}
	public void clickContinue()
	{
		logger.info("ForgotPasswordPage : continueButton: started");
		
		if(continueButton.isDisplayed())
		{
			continueButton.click();
		}
		else
		{
			logger.error("ForgotPasswordPage : continueButton : element not found");
		}
	}
	
	public void loginPage(WebDriver driver) throws IOException
	{
		driver.get(FileUtils.readLoginTestData("prod.url"));
		driver.manage().window().maximize();
		Assert.assertEquals(this.isLoginPageOpened(driver),FileUtils.readLoginTestData("loginPage.title"));
		if(CommonUtils.waitForElement(driver, username))
		{
			username.sendKeys(FileUtils.readLoginTestData("valid.username"));
			password.sendKeys(FileUtils.readLoginTestData("valid.password"));
			loginButton.click();
			CommonUtils.waitForElement(driver, usermenu);
			Assert.assertEquals(this.isHomePageOpened(driver),FileUtils.readLoginTestData("homePage.title"));
		}
		else
		{
			logger.error("LoginPage : login: failed");
		}
		
	}
	public HomePage loginToApp(WebDriver driver) throws IOException {
		this.enterUsername(FileUtils.readLoginTestData("valid.username"));
		this.enterPassword(FileUtils.readLoginTestData("valid.password"));
		this.clickLoginButton();
		return new HomePage(driver);
	}
	
	public void logoutPage(WebDriver driver)
	{
		usermenu.click();
		logout.click();
		
	}
}