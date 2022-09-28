package zoomanagementtestng;

import org.testng.annotations.Test;
import org.zooObjectrepository.normaltickets;

import genericutility.BaseTestclass;
import genericutility.iconstantpath;


public class Zoonormaltestscript2Test extends BaseTestclass {
	@Test
	public void addDetails() {
		normaltickets normal=new normaltickets(driver);
		String name = propertyfile.getpropertyfiles(iconstantpath.propertyfileofnormal, "name");
		String adult = propertyfile.getpropertyfiles(iconstantpath.propertyfileofnormal, "NoOfAdult");
		String children = propertyfile.getpropertyfiles(iconstantpath.propertyfileofnormal, "NoOfChildren");
		common.normalclick();
		common.clickonaddnormals();
		normal.senddata(name, adult, children);
	}

}
