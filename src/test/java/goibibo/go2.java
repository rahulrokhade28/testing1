package goibibo;

import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class go2 {
	 public static void main(String[] args) throws Throwable {
	
	WebDriverManager.firefoxdriver().setup();
	FirefoxDriver driver = new FirefoxDriver();
	String fromcity="AUH";
	String tocoty="BOM";

	driver.navigate().to("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//span[text()='From']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromcity);
	driver.findElement(By.xpath("//div[text()='"+fromcity+"']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(tocoty);
	driver.findElement(By.xpath("//div[text()='"+tocoty+"']")).click();
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	driver.close();
	
	
	
	
	 }

}
