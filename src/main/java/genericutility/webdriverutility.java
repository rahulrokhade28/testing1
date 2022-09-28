package genericutility;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webdriverutility

{
	public void waitTillelementvisible(long time,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	SoftAssert soft;
	Actions a;
	Select s;
	WebDriver driver; 
	/**
	 * this method is used for launch the browser
	 * @par browser
	 * return
	 */
	public WebDriver launchbrowser(String browser) {
		WebDriver driver=null;
		switch(browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			//if u want to launch any browser so we only we write this generic script to access any browser just by gvng name of the browser
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		}
		return driver;
	}
	/**
	 * this method is used to maximize the browser
	 * @param driver
	 */
	public void maxbrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this generic method is used to wait the application till the page load
	 * @param driver
	 * @param timeset
	 */
	public void waitImplicite(WebDriver driver,long timeset) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeset));
}
	/*
	 * this generic method is used to open the app using maxbrowser,waitimplicite and navigation in one single method
	 */
	public WebDriver opentheapp(String browser,String url,long timeouts) {
	     driver = launchbrowser(browser);
		maxbrowser(driver);
		waitImplicite(driver, timeouts);
		navigateapp(driver, url);
		return driver;
	}
	/**
	 * this generic method is used to launch the browser
	 * @param driver
	 * @param url
	 */
	public void navigateapp(WebDriver driver,String url) {
		driver.get(url);
	}
	/**
	 * this method is used to quit/close the browser
	 * @param driver
	 */
	public void closethebrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * this is generic method for all the common action for the browser
	 * @param browser
	 * @param url
	 * @param timeset
	 */
	public void commonOperation(String browser,String url,long timeset) {
		WebDriver driver =launchbrowser(browser);
		maxbrowser(driver);
		waitImplicite(driver, timeset);
		navigateapp(driver, url);
		closethebrowser(driver);
		
	}
	/**
	 * this is generic method is used to do mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mousehoveraction(WebDriver driver,WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}
	/**
	 * this method is used to mousehouver to a particular element
	 * whn horizonatal and vertial axis is specified
	 * @param element
	 * @param horizontalAxis
	 * @param vertial
	 */
 public void moushovrhorizontal (WebElement element,int horizontalAxis,int vertial) {
	a.moveToElement(element,horizontalAxis,vertial).perform();
}
	/**
	 * this is generic method is used to do double click action
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver,WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}
	/**
	 * this method is used to intialize action class
	 * @param driver
	 */
	public void actions(WebDriver driver) {
		a=new Actions(driver);		
	}
	/*
	 * this method is used to intialize alert function
	 */
	public void alertaction(WebDriver driver) {
		Alert a1=driver.switchTo().alert();
		a1.accept();
	}
	public void verifywebpageusingassert(WebElement element,long longtime,String expectedtext)
	{
		for(;;) 
		{
			try {
				Assert.assertEquals(element.getText(),expectedtext);
				break;
			}
			catch (Exception e) {
			waitTillelementvisible(longtime,element);
			}
		}
	}
	/*
	 * this method is used to verify using assertequals 
	 */
	public void toPerformVerifyByAssertequals(String actual, String expected) {
		Assert.assertEquals(actual,expected);
	}
	/*
	 * this method is used to verify using assert notequals
	 */
	public void toPerformVerifyByAssertfail(String actu,String expt) {
		Assert.assertNotEquals(actu, expt);
	}
	/*
	 *  this method is used to intialize softassert
	 */
	public void SoftAssertintialize() {
		 soft = new SoftAssert();
	}
	/*
	 * this method is used to compare using softasserequals
	 */
	public void comparebySoftAssert(String actul, String exp) {
		soft.assertEquals(actul,exp);
	}
	/*
	 * this method is used verify all using assertall
	 */
	public void softassertall() {
		soft.assertAll();
	}
	/*
	 * this method is used to take screenshot with data and save and copy the data in file
	 */
	public File Scrrenshot(javautility currentTime,WebDriver driver,String classname) {
		String ct=currentTime.currenttime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshotpic/"+classname+"_"+ct+".png");
		return dst.getAbsoluteFile();
//		try {
//			FileUtils.copyFile(src, dst);
//		}
//		catch (Exception e) {
//		e.printStackTrace();
	}
	
	public String screenshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path=ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
	
	/**
	 * this method is used to switchTo different Window
	 * @param driver
	 * @param partialtxt
	 */
	public void switchToWindow(WebDriver driver,String partialtxt) {
		 Set<String> windowId = driver.getWindowHandles();
		 for(String id:windowId) {
			 driver.switchTo().window(id);
			 if (driver.getCurrentUrl().contains(partialtxt)) {
				break;
			}
		 }
	}
	/**
	 * this is generic method is used to switch the windows
	 * @param driver
	 * @param element
	 */
	public void switchtonewwindow(WebDriver driver, String element) {
		driver.switchTo().window(element);
			
}	
}