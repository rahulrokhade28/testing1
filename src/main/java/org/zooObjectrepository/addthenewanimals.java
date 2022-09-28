package org.zooObjectrepository;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;

import genericutility.excelutility;
import genericutility.iconstantpath;
import genericutility.propertyfile;
import genericutility.webdriverutility;

public class addthenewanimals {
public static void main(String[] args) {
	//create instance for the generic utility
	webdriverutility wd = new webdriverutility();
	excelutility excel = new excelutility();
propertyfile prop = new propertyfile();
//propertyfile.getpropertyfiles(iconstantpath,);
// ftch the data from property file
String brow = prop.getpropertyfiles(iconstantpath.propertyfiles, "browser");
String url = prop.getpropertyfiles(iconstantpath.propertyfiles, "url");
 WebDriver driver = wd.launchbrowser(brow);
 // ftch the data from excel file
 String un = excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",0,1);
 String pw=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",1,1) ;
 String ani=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",2,1) ;	
 String brw=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",3,1) ;	
 String cage=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",4,1) ;
 String no=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",5,1) ;
 String breed=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",6,1) ;
 String abt=excel.getDatafromExcel(iconstantpath.excelpath,"Sheet1",7,1) ;
 driver.get(url);
 //intallize all the browser and some browser setting
 
 loginpage login=new loginpage(driver);
 commonpage common=new commonpage(driver);
 animaldetails details=new animaldetails(driver);

 // scripts -test steps
 login.loginaction(un, pw);
common.click();
common.addclick();
details.senddata(ani, brw, no, cage, breed, abt);
common.manageclick();

}
}
