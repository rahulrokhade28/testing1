package goibibo;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class go {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver ;
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		Thread.sleep(2000);
		driver.navigate().to("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//p[text()='Bangkok, Thailand']")).click();
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div/descendant::div[@aria-label='Sat Aug 27 2022']")).click();
	
	}

}
