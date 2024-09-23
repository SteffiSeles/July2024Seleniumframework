package Pages;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.CommonUtils;
import utils.FileUtils;

public class ContactsPage extends BasePage{
		
		public ContactsPage(WebDriver driver)
		{
			super(driver);
		}
		@FindBy(xpath="/html/body/div/div[1]/div[1]/div/nav/ul/li[6]/a")
		public WebElement alllink;
		
		@FindBy(xpath="//a[@class='listRelatedObject contactBlock title']")
		public WebElement contactsLink;
		
		@FindBy(xpath="//div[@class='content']/h2")
		public WebElement contactsHomePage;

		@FindBy(xpath="//input[@value=' New ']")
		public WebElement newButton;
		
		@FindBy(xpath="//div[@class='content']/h2")
		public WebElement newContactsHomePage;
		
		@FindBy(xpath="//input[@id='name_lastcon2']")
	    public WebElement lastNameField;
		
		@FindBy(xpath="//input[@id='con4']")
		public WebElement accountsNameField;
		
		@FindBy(xpath="//td[@id='topButtonRow']/input[1]")
		public WebElement saveButton;
		
		@FindBy(xpath="//div[@id='ep']/div/table/tbody/tr/td/h2")
		public WebElement contactsDisplayPage;
		
		@FindBy(xpath="//span[@class='fFooter']/a[2]")
		public WebElement createNewViewLink;
		
		@FindBy(xpath="//input[@id='fname']")
		public WebElement viewNameField;
		
		@FindBy(xpath="//input[@id='devname']")
		public WebElement uniqueViewNameField;
		
		@FindBy(xpath="//input[@value=' Save ']")
		public WebElement viewSaveButton;
		
		@FindBy(xpath="//select[@class='title']/option[@selected]")
		public WebElement dropdownSection;
		
		@FindBy(xpath="//select[@id='hotlist_mode']")
		public WebElement recentlyCreatedViewDropdown;
		
		@FindBy(xpath="//form[@id='hotlist']/table/tbody/tr/td/h3")
		public WebElement recentlyCreatedContactListPage;
		
		@FindBy(xpath="//select[@id='fcf']")
		public WebElement dropdownField;
		
		@FindBy(xpath="//input[@value='New Contact']")
		public WebElement mycontactsViewPage;
		
		@FindBy(xpath="//div[@class='pbBody']/table/tbody/tr[2]/th/a")
		public WebElement contactNameLink;
		
		@FindBy(xpath="//div[@class='textBlock']/h2")
		public WebElement contactDetailPage;
		
		@FindBy(xpath="//div[@class='requiredInput']/div[@class='errorMsg']")
		public WebElement errorMessage;
		
		@FindBy(xpath="//div[@class='pbHeader']/table/tbody/tr/td[2]/input[2]")
		public WebElement cancelButton;
		
		@FindBy(xpath="//td[@id='topButtonRow']/input[2]")
		public WebElement saveAndNewButton;
		
		@FindBy(xpath="//div[@class='content']/h2")
		public WebElement ContactEditNewContactPage;
		
		
		
		public boolean isContactHomePageOpened()
		{
			return contactsHomePage.isDisplayed();
		}
		
		public void clickAllLink(WebDriver driver)
		{
			if(alllink.isDisplayed())
			{
				alllink.click();
				System.out.println("All link is clicked");
			}
		}
		
		public void clickContactLink(WebDriver driver)
		{
			if(contactsLink.isDisplayed())
			{
				contactsLink.click();
				Assert.assertTrue(isContactHomePageOpened(),"Failed to display contact home page");
			}
		}
		
		public boolean verifyCreateNewContacts(WebDriver driver, String lastName, String accountsName)
		{
			logger.info("contactPage : create new contact : started");
			
			boolean isNewAccountCreated=false;
			//this.clickContactLink(driver);
			if(newButton.isDisplayed())
			{
				 newButton.click();
				 System.out.println("New Button is clicked");
			}
			 CommonUtils.waitForElement(driver, newContactsHomePage);
			 if(lastNameField.isDisplayed())
			 {
				 lastNameField.sendKeys(lastName);
				 accountsNameField.sendKeys(accountsName);
				 saveButton.click();
				 if(contactsDisplayPage.isDisplayed())
				 {
					 isNewAccountCreated=true;
				 }
			}
			 return isNewAccountCreated;
		}
		
		public boolean verifyCreateNewViewInContactPage(WebDriver driver,String newViewname) throws InterruptedException
		{
			logger.info("contactPage : create newView : started");
			boolean isNewViewCreated=false;
			if(createNewViewLink.isDisplayed())
			{
				createNewViewLink.click();
				System.out.println("Create new view link is clicked");
				if(viewNameField.isDisplayed())
				{
					viewNameField.sendKeys(newViewname);
					System.out.println("View name is entered");
					uniqueViewNameField.click();
					viewSaveButton.click();
					System.out.println("Save button is clicked");
					Thread.sleep(5000);
					if(dropdownSection.isDisplayed())
						System.out.println("Dropdown section is displayed");
					{
						Assert.assertEquals(dropdownSection.getText(), newViewname,"Failed to display created view in dropdown section" );
						isNewViewCreated=true;
					}
				}
			}
			return isNewViewCreated;
		}
		
		public boolean verifyRecentlyCreatedContact(WebDriver driver)
		{
			logger.info("contactPage : recently created contactView: started");
			
			boolean isRecentedCreatedContactDisplayed=false;
			if(recentlyCreatedViewDropdown.isDisplayed())
			{
				Select select = new Select(recentlyCreatedViewDropdown);
				select.selectByVisibleText("Recently Created");
				if(recentlyCreatedContactListPage.isDisplayed())
				{
					isRecentedCreatedContactDisplayed=true;
				}
			}
			return isRecentedCreatedContactDisplayed;
		}
		
		public boolean verifyMyContactViewInContactPage(WebDriver driver)
		{
			logger.info("contactPage : myContactView : started");
			
			boolean isMyContactViewDisplayed=false;
			if(dropdownField.isDisplayed())
			{
				Select select = new Select(dropdownField);
				select.selectByVisibleText("My Contacts");
				if(mycontactsViewPage.isDisplayed())
				{
					isMyContactViewDisplayed=true;
				}
			}
			return isMyContactViewDisplayed;
		}
		
		public boolean verifyViewAContact(WebDriver driver)
		{
			logger.info("contactPage : verify viewAccount : started");
			boolean isSelectedContactDisplayed=false;
			if(contactNameLink.isDisplayed())
			{
				contactNameLink.click();
				if(contactDetailPage.isDisplayed())
				{
					isSelectedContactDisplayed=true;
				}
			}
			return isSelectedContactDisplayed;
		}
		
		public boolean verifyErrorMessage(WebDriver driver, String uniqueName) throws IOException
		{
			logger.info("contactPage : verify errorMessage : started");
			boolean isErrorMsgDisplayed=false;
			if(createNewViewLink.isDisplayed())
			{
				createNewViewLink.click();
				System.out.println("Create New link is clicked");
				uniqueViewNameField.sendKeys(uniqueName);
				viewSaveButton.click();
				if(errorMessage.isDisplayed())
				{
					Assert.assertEquals(errorMessage.getText(),FileUtils.readContactsTestData("error.message"), "Failed to verify error message");
					isErrorMsgDisplayed=true;
				}
				
			}
			return isErrorMsgDisplayed;
		}
		
		public boolean verifyCancelButtonInCreateNewViewPage(WebDriver driver,String uniquename, String newViewname)
		{
			logger.info("contactPage : verify cancel button  : started");
			boolean isCancelButtonWorks=false;
			if(createNewViewLink.isDisplayed())
			{
				createNewViewLink.click();
				if(uniqueViewNameField.isDisplayed())
				{
					uniqueViewNameField.sendKeys(uniquename);
					viewNameField.sendKeys(newViewname);
				}
				cancelButton.click();
				if( contactsHomePage.isDisplayed())
				{
					isCancelButtonWorks=true;
				}
			}
				
			return isCancelButtonWorks;		
		}
		
		public boolean verifySaveAndNewButton(WebDriver driver,String lastName,String accountName)
		{
			logger.info("contactPage : verify save and New button : started");
			boolean isSaveAndNewButtonChecked=false;
			if(newButton.isDisplayed())
			{
				newButton.click();
				lastNameField.sendKeys(lastName);
				accountsNameField.sendKeys(accountName);
				saveAndNewButton.click();
				if(ContactEditNewContactPage.isDisplayed())
				{
					isSaveAndNewButtonChecked=true;
				}
				
			}
			return isSaveAndNewButtonChecked;
		}
	}