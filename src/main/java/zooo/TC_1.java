package zooo;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericutility.BaseTestclass;

public class TC_1 extends BaseTestclass{
	@Test(groups="san")
	public void tc_1() {
		Reporter.log("Pass tc_1",true);	
		}

}
