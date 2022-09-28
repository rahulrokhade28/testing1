package zooo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class zoo {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {

		FileInputStream	fil=new FileInputStream("./src/main/resources/zo.xlsx");
		Workbook wb=WorkbookFactory.create(fil);
		String ss= wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue().toString();
		String s1 = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String s2 = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		String s3= wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
		String s4 = wb.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();
		String s5 = wb.getSheet("Sheet1").getRow(5).getCell(1).getStringCellValue();
		String s6 = wb.getSheet("Sheet1").getRow(6).getCell(1).getStringCellValue();
		String s7 = wb.getSheet("Sheet1").getRow(7).getCell(1).getStringCellValue();
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("http://rmgtestingserver/domain/Zoo_Management_System/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='admin/index.php']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys(ss);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(s1);
		Thread.sleep(2000);
		driver.findElement(By.id("form_submit")).click();
			driver.findElement(By.xpath("//span[contains(.,'Animals Details')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add Animals')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'aname')]")).sendKeys(s2);
		driver.findElement(By.xpath("//input[contains(@type,'file')]")).sendKeys(s3);

		driver.findElement(By.id("cnum")).sendKeys(s4);
		driver.findElement(By.name("fnum")).sendKeys(s5);
		driver.findElement(By.xpath("//input[contains(@name,'breed')]")).sendKeys(s6);
		driver.findElement(By.xpath("//input[@id='desc']")).sendKeys(s7);
		driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
	/*	Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Alert a=driver.switchTo().alert();
		a.accept();
		Thread.sleep(2000);*/
		driver.findElement(By.xpath("//a[.='Animals Details']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'Manage Animals')]")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//h4[text()='Manage Animals']/following::div[@class='data-tables']/table/thead/tr/th[text()='Animal Name']/following::tbody//td[3]"));
		for(WebElement ele1:ele)
		{
			String animals = ele1.getText();
			System.out.println(animals);
			if(animals.equalsIgnoreCase("Giraffe(Reticulated giraffe)"))
			{
				driver.findElement(By.xpath("//table//tbody/tr/td[3][.='"+animals+"']/parent::tr/td[5]//a[.='Delete']")).click();
				Alert a1=driver.switchTo().alert();
				a1.accept();
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				break;
			}
		}
	}
}
