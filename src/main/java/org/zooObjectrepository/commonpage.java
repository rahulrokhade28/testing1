package org.zooObjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class commonpage {
//declaration
	/*
	 * in this all url of the element should be similar thn only we can wirte dynamic xpath for this element  if diff thn we shld create diff claas for tht element
	 */
	@FindBy(xpath = "//a[.='Animals Details']")private WebElement clickonanimal;
	@FindBy(xpath = "//a[contains(.,'Add Animals')]")private WebElement clickoaddnanimal;
	@FindBy(xpath = "//a[contains(.,'Manage Animals')]")private WebElement clickonmanage;
@FindBy(xpath = "//span[.='Normal Ticket']")private WebElement clickonnormal;
@FindBy(xpath = "//a[@href='add-normal-ticket.php']")private WebElement clickaddonnormal;

@FindBy(xpath = "//span[.='Foreigners Ticket']")private WebElement clickonforigne;
@FindBy(xpath = "//h4[.='Admin ']")private WebElement clickonadmin;
@FindBy(xpath = "//a[.='Log Out']")private WebElement clickonlogout;
/* 
 * for each and everry element we will use @findby annotation we will declare all the elements by using @findby annotation after
 * declaration we will intilaize the elements by using pagefactory.initElements(pagefactory is a class and initelemnts is static method 
 * and it act like constructor ,driver represents the browser address (this,represent the current project. after intialization we utilize all the 
 * elements from the pom class 
 */
public commonpage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
public void click() {
	clickonanimal.click();
}
public void clickonaddnormals() {
	clickaddonnormal.click();
}
public void addclick() {
	clickoaddnanimal.click();
	}
	public void manageclick() {
 clickonmanage.click();
 }
	public void normalclick() {
	clickonnormal.click();
	}
	public void forigneclick() {
	clickonforigne.click();
	}
	public void adminclick() {
		clickonadmin.click();
	}
	public void logoutclick() {
	clickonlogout.click();
}
}

