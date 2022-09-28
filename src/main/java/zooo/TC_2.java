package zooo;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericutility.BaseTestclass;

public class TC_2 extends BaseTestclass {
	@Test(groups="reg")
	public void tc_1() {
		Reporter.log("Pass tc_2",true);	
		}

}
