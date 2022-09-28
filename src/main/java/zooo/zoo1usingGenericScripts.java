package zooo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import genericutility.excelutility;
import genericutility.iconstantpath;
import genericutility.propertyfile;
import genericutility.webdriverutility;

public class zoo1usingGenericScripts {
public static void main(String[] args) {
	webdriverutility wd = new webdriverutility();
	excelutility excel = new excelutility();
propertyfile prop = new propertyfile();
String brow = prop.getpropertyfiles(iconstantpath.propertyfiles, "browser");
String url = prop.getpropertyfiles(iconstantpath.propertyfiles, "url");
 WebDriver driver = wd.launchbrowser(brow);
String un = excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",0,1);
String pw=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",1,1) ;
String ani=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",2,1) ;	
String brw=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",3,1) ;	
String cage=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",4,1) ;
String no=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",5,1) ;
String breed=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",6,1) ;
String abt=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",7,1) ;
driver.get(url);
driver.findElement(By.xpath("//a[@href='admin/index.php']")).click();
driver.findElement(By.id("username")).sendKeys(un);
driver.findElement(By.id("password")).sendKeys(pw);
driver.findElement(By.id("form_submit")).click();
driver.findElement(By.xpath("//span[contains(.,'Animals Details')]")).click();
driver.findElement(By.xpath("//a[contains(.,'Add Animals')]")).click();
driver.findElement(By.xpath("//input[contains(@name,'aname')]")).sendKeys(ani);
driver.findElement(By.xpath("//input[contains(@type,'file')]")).sendKeys(brw);
driver.findElement(By.id("cnum")).sendKeys(cage);
driver.findElement(By.name("fnum")).sendKeys(no);
driver.findElement(By.xpath("//input[contains(@name,'breed')]")).sendKeys(breed);
driver.findElement(By.xpath("//input[@id='desc']")).sendKeys(abt);
driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();

}
	
}
