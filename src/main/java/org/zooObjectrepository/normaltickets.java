package org.zooObjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class normaltickets {
@FindBy(id = "visitorname")private WebElement visitorfiled;
@FindBy(id = "noadult")private WebElement adultsfiled;
@FindBy(id = "nochildren")private WebElement childrenfiled;
@FindBy(xpath = "//button[text()='Submit']") private WebElement clickonsubmitofnormal;
@FindBy(xpath = "//a[@href='manage-normal-ticket.php']") private WebElement clickonmanageticket;
public normaltickets(WebDriver driver) {
	PageFactory.initElements(driver,this);		
	}
public void senddata(String vistornames,String adult, String nochildren) {
	
	visitorfiled.sendKeys(vistornames);
	adultsfiled.sendKeys(adult);
	childrenfiled.sendKeys(nochildren);
	clickonsubmitofnormal.click();
	clickonmanageticket.click();
}
}
