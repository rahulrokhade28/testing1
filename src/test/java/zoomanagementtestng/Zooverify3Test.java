package zoomanagementtestng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zooObjectrepository.Managetheanimals;

import genericutility.BaseTestclass;

public class Zooverify3Test extends BaseTestclass {
	protected String animal;
	@Test
	public void verifyingtheanimals() throws AWTException{

		Managetheanimals manage=new Managetheanimals(driver);
		String count = manage.animalCounts();
		System.out.println(count);
		common.click();
		common.manageclick();
		List<WebElement> animallist = manage.verify();
		//System.out.println(animallist);
		for (WebElement ele1 : animallist) 
		{
			animal=ele1.getText();
			System.out.println(animal);
			if(animal.equalsIgnoreCase("44Bharu(44Breed)"))
			{
				WebElement deleteanimal = manage.convertoElement(animal, driver);
				manage.deleteAnimal(deleteanimal);
				web.alertaction(driver);
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				break;
			}
		}
		manage.clickOnDashboard();
		String afterdeletecount = manage.animalCounts();
		System.out.println(afterdeletecount);
		Assert.assertEquals(count, afterdeletecount);
	}
}
//for (WebElement ele1 :animallist)
//{
//	String animals = ele1.getText();
//	System.out.println(animals);
//	if(animals.equalsIgnoreCase("Giraffe(Reticulated giraffe)"))
//	{
//		driver.findElement(By.xpath("//table//tbody/tr/td[3][.='"+animals+"']/parent::tr/td[5]//a[.='Delete']")).click();
//		Alert a1=driver.switchTo().alert();
//		a1.accept();
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_ESCAPE);
//		r.keyRelease(KeyEvent.VK_ESCAPE);
//		break;
//	}

