package genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.zooObjectrepository.commonpage;
import org.zooObjectrepository.loginpage;

import genericutility.excelutility;
import genericutility.iconstantpath;
import genericutility.javautility;
import genericutility.propertyfile;
import genericutility.webdriverutility;

public class BaseTestclass {
	protected commonpage common;
private	loginpage login;
private String user;	
private String pass;
protected WebDriver driver;
protected int getRandomno ;
protected webdriverutility web;
protected excelutility excelutility;
protected propertyfile propertyfile;
public static WebDriver sdriver;

/*
 * intialize the all utility class
 * open the excel, propertyfile
 * read the common data
 * create the instance for the browser (launch the browser)
 * maximize implicit wait 
 * open the application
 * intiallize jsexecution , action ,webdriverwait
 * create the instacne for the common object repo
 * 
 */
@BeforeClass
public void opentheapplication() {
	//create instance for the generic utility
	excelutility=new excelutility();
	javautility javautility = new javautility();
	propertyfile=new propertyfile();
	web=new webdriverutility();
	excelutility.openexcelpage(iconstantpath.excelpath);
	//fetch the common data from property file which is used for every testcase ex:-url, which browser to launch ,and timeout of app to run
	String brow = propertyfile.getpropertyfiles(iconstantpath.propertyfiles, "browser");
	String url = propertyfile.getpropertyfiles(iconstantpath.propertyfiles, "url");
String longtimeout = propertyfile.getpropertyfiles(iconstantpath.propertyfiles,"timeout");
user=propertyfile.getpropertyfiles(iconstantpath.propertyfiles, "username");
pass=propertyfile.getpropertyfiles(iconstantpath.propertyfiles, "password");

long time = Long.parseLong(longtimeout);
getRandomno=javautility.getRandomno(9000);
//launching the browser and doing some browse setting ]
	  driver = web.opentheapp(brow, url, time);
	  sdriver = driver;
	  //create object for common pom 
	  login = new loginpage(driver);
	  common=new commonpage(driver);
	  //login  to the application
	  /*
	   * when ever we create the testscripts  class for module and test annotation methiod for testcase
	   * create the instance for browser launch the browser
	   * mmaximze,implicit wait 
	   * create the instance for common object repo(driver)
	   * login to the app
	   */
	  }
	@BeforeMethod(groups="BaseTestclass")
	  public void methodsetup()
	{
		login.loginaction(user, pass);
	}
	@AfterMethod
	 public void methodteardown() {
		common.adminclick();
		common.logoutclick();
	}
	@AfterClass
	public void classclose() {
		web.closethebrowser(driver);
	}
	 
	
}

