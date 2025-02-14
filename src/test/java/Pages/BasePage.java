package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	static Logger logger = LogManager.getLogger();
	protected BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
