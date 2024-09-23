package Constants;

import utils.CommonUtils;

public class FileConstants {
	public static String ROOT_PATH = System.getProperty("user.dir");
	public static final String LOGIN_TEST_DATA_FILE_PATH = ROOT_PATH + "/src/test/java/testData/logintestdata.properties";
	
	public static final String USER_MENU_TESTDATA_FILE_PATH=ROOT_PATH+"/src/test/java/testData/UserMenuTestData.properties";

	public static final String TEST_FILE_PATH="C:\\Users\\elvis\\OneDrive\\Desktop\\Steffi\\New Batch\\Manual testing.png";
	
	public static final String PHOTO_FILE_PATH="C:\\Users\\elvis\\OneDrive\\Desktop\\Steffi\\New Batch\\Automation.png";
	
	public static final String ACCOUNT_TESTDATA_FILE_PATH=ROOT_PATH+"/src/test/java/testData/CreateAccountTestData.properties";
	
	public static final String OPPORTUNITY_TESTDATA_FILE_PATH=ROOT_PATH+"/src/test/java/testData/CreateOpportunityTestData.properties";

	public static final String LEAD_TESTDATA_FILE_PATH=ROOT_PATH+"/src/test/java/testData/CreateLeadTestData.properties";
	
	public static final String CONTACTS_TESTDATA_FILE_PATH=ROOT_PATH+"/src/test/java/testData/ContactTestData.properties";

	public static final String RANDOMSCENARIO_TESTDATA_FILE_PATH=ROOT_PATH+"/src/test/java/testData/RandomScenariosTestData.properties";
	
	public static final String SCREENSHOT_FOLDER_PATH=System.getProperty("user.dir")+"/src/test/resources/screenshots/"+CommonUtils.getDateAndTimeStamp()+".PNG";
	
	public static final String REPORT_FOLDER_PATH=System.getProperty("user.dir")+"/src/test/resources/reports/SFDC_"+CommonUtils.getDateAndTimeStamp()+".html";
	
}