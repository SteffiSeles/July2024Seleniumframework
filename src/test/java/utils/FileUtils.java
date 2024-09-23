package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Constants.FileConstants;

public class FileUtils {
	public static String readLoginTestData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(FileConstants.LOGIN_TEST_DATA_FILE_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	public static String readUserMenuTestData(String key) throws IOException
	{
		FileInputStream f = new FileInputStream(FileConstants.USER_MENU_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}
	
	public static String readCreateAccountTestData(String key) throws IOException
	{
		FileInputStream f= new FileInputStream(FileConstants.ACCOUNT_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}
	
	public static String readCreateOpportunityTestData(String key) throws IOException
	{
		FileInputStream f = new FileInputStream(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}
	
	public static String readLeadTestData(String key) throws IOException
	{
		FileInputStream f = new FileInputStream(FileConstants.LEAD_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}
	
	public static String readContactsTestData(String key) throws IOException
	{
		FileInputStream f = new FileInputStream(FileConstants.CONTACTS_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}
	
	public static String readRandomScenarioTestData(String key) throws IOException
	{
		FileInputStream f = new FileInputStream(FileConstants.RANDOMSCENARIO_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}

}