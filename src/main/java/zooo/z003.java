package zooo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class z003 {

	 public static void main(String[] args) throws IOException {
		FileInputStream f=new FileInputStream("./src/main/resources/zo.xlsx");
		   Workbook wb = WorkbookFactory.create(f);
		  String u = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		  String n = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		  String p = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		  WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://rmgtestingserver/domain/Zoo_Management_System/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("//a[text()='Admin'][1]")).click();
		 driver.findElement(By.id("username")).sendKeys(u);
		 driver.findElement(By.id("password")).sendKeys(n);
		 driver.findElement(By.id("form_submit")).click();
		 driver.findElement(By.xpath("//span[text()=\"Reports\"]")).click();
		 driver.findElement(By.xpath("//a[text()=\"Normal People Report\"]")).click();
		 driver.findElement(By.id("fromdate")).sendKeys("11-07-2021");
		 driver.findElement(By.id("todate")).sendKeys("11-08-2022");
		 driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
		 driver.findElement(By.xpath("//a[text()=\"View\"][1]")).click();
		 driver.findElement(By.xpath("//i[@class='fa fa-print fa-2x']")).click();
		 
	 
}
}
