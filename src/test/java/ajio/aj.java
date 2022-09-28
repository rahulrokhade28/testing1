package ajio;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aj {
	public static void main(String[] args) {
		WebDriver driver ;
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions op=new FirefoxOptions();
		op.addArguments("..disable notification");
		driver=new FirefoxDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement vlu = driver.findElement(By.xpath("//div[text()='Fashion'])"));
		Actions nw = new Actions(driver);
		nw.moveToElement(vlu).perform();
		
		
		
		
		
		
		
	}

}
