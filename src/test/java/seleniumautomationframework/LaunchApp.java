package seleniumautomationframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LaunchApp {

	public static void main(String[] args) throws InterruptedException, AWTException {

		ChromeOptions co = new ChromeOptions();
//		co.addExtensions(new File(""));
//		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver(co);
//		Cookie c1 = new Cookie("rememberUn", "true");
//		Cookie c2 = new Cookie("login", "anVsMjIubWl0aHVuQHRhLmNvbQ==");

//		driver.get("https://login.salesforce.com/");
		driver.navigate().to("https://selenium-prd.firebaseapp.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.manage().addCookie(c1);
//		driver.manage().addCookie(c2);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.navigate().refresh();
//		Set<Cookie> sfdcCookies = driver.manage().getCookies();
//
//		for (Cookie c : sfdcCookies) {
//			System.out.println(c.getName() + " " + c.getValue());
//		}
//
//		driver.manage().deleteAllCookies();

		//WaitUtils.explicitlyWaitForInVisibility(driver, driver.findElement(By.id("email_field")));
		
		WebElement userName = driver.findElement(By.id("email_field"));
		js.executeScript("arguments[0].value='admin123@gmail.com';", userName);
//		userName.sendKeys("admin123@gmail.com");
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		
		password.sendKeys(Keys.ENTER);
		
//		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login to Account']"));
//		js.executeScript("arguments[0].click();", loginButton);
//		loginButton.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].setAttribute('id','fullname');", name);
		Thread.sleep(200000);
		js.executeScript("window.scrollBy(0,1000);");
		String url = js.executeScript("return document.domain;").toString();
		System.out.println(url);
		
		Thread.sleep(1000);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
//		WebElement radioButtonMale = driver.findElement(By.xpath("//input[@value='male']"));
//		WebElement radioButtonFeMale = driver.findElement(By.xpath("//input[@value='female']"));
//		radioButtonFeMale.click();
//		if(radioButtonFeMale.isSelected()) {
//			System.out.println("Female gender is selected");
//		} else {
//			System.out.println("Male gender is selected");
//		}

//		Thread.sleep(2000);
//		city.deselectByIndex(3);
//		ActionUtils.mouseHover(driver, driver.findElement(By.xpath("//button[contains(text(),'Widget')]")));
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='AutoComplete']")).click();
//		Thread.sleep(2000);
//		System.out.println("Test complete");

//		WebElement textbox = driver.findElement(By.cssSelector("#myInput"));
//		textbox.click();
//		textbox.sendKeys("Co");

//		List<WebElement> autoSugg = driver.findElements(By.className("autocomplete-items"));
//
//		for(WebElement w: autoSugg) {
////			System.out.println(w.getText());
//			String value = w.getText();
////			System.out.println(w.getRect());
//			if(value == ("Co\nsta Rica")) {
//				System.out.println("Inside if");
//				w.click();
//			} else {
//				
//			}
//		}

//		driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/a[1]/button")).click();
////		Thread.sleep(2000);
//		Set<String> windows = driver.getWindowHandles();
//		String firstWindow = driver.getWindowHandle();
//		String googleWindow = "";
//		for(String s: windows) {
//			googleWindow = s;
//		}
//		driver.switchTo().window(googleWindow);
//		WebElement search = driver.findElement(By.name("q"));
//		search.sendKeys("bhdjfbs");
////		Thread.sleep(2000);
//		search.submit();
////		Thread.sleep(2000);
//		driver.close();
//		driver.switchTo().window(firstWindow);
		Thread.sleep(2000);
		driver.close();

//		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div[1]"))).build().perform();
//		Thread.sleep(1000);
//		String actualToolTipText = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div[1]/span")).getText();
//		System.out.println(actualToolTipText);
//		WebElement tom = driver.findElement(By.id("drag1"));
//		WebElement boxLeft = driver.findElement(By.xpath("(//*[@id=\"div1\"])[1]"));
//		action.clickAndHold(tom).moveToElement(boxLeft).pause(Duration.ofSeconds(1)).release().build().perform();

//		WebElement dclick = driver.findElement(By.xpath("//button[text()='Double Click']"));
//		action.doubleClick(dclick).build().perform();
//		driver.findElement(By.xpath(""));
//		driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]")).click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().sendKeys("Hello");
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();

//		WebElement iframe = driver.findElement(By.id("contactInfoContentId"));
//		driver.switchTo().frame(iframe);
//		
//		driver.switchTo().parentFrame();
//		driver.switchTo().defaultContent();
//		
//		Thread.sleep(5000);
//		driver.close();
//		
//		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofMillis(2000));
//		
//		WebElement ele = fWait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.id(""));
//			}
//		});

	}
}