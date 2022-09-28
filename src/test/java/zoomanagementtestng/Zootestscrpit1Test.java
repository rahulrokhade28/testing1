package zoomanagementtestng;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.zooObjectrepository.animaldetails;

import genericutility.BaseTestclass;

public class Zootestscrpit1Test extends BaseTestclass
{
	@Test
	public void updatetheanimals(){
	//ferch the data from the excel
		Map<String, String> data = excelutility.getdatafromexcelusingmap("Sheet1");
		animaldetails animaldetails=new animaldetails(driver);
		common.click();
		common.addclick();
		animaldetails.senddata(data.get("m"),data.get("j"),data.get("l") ,data.get("lo") ,data.get("pp"),data.get("u"));
		driver.switchTo().alert().accept();
		Assert.assertEquals(0, 0);
	}

}
