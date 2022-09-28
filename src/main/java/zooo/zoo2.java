package zooo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class zoo2 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	
	driver.get("http://rmgtestingserver/domain/Zoo_Management_System/");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//a[@href='admin/index.php']")).click();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("Test@123");
	driver.findElement(By.id("form_submit")).click();
	driver.findElement(By.xpath("//span[text()='Normal Ticket']")).click();
	driver.findElement(By.xpath("//a[@href='add-normal-ticket.php']")).click();
	driver.findElement(By.id("visitorname")).sendKeys("vijay");
	driver.findElement(By.id("noadult")).sendKeys("29");
	driver.findElement(By.id("nochildren")).sendKeys("30");
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[text()='Normal Ticket']")).click();
	
	driver.findElement(By.xpath("//a[@href='manage-normal-ticket.php']")).click();
	
}
}
