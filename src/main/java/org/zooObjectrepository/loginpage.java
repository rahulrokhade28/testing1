package org.zooObjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	//declaration
	@FindBy(xpath = "//a[@href='admin/index.php']") private WebElement clickbutton;
	@FindBy(id = "username") private WebElement usernameTextField;
	@FindBy(id = "password") private WebElement passwordTextField;
	@FindBy(id = "form_submit") private WebElement submitbutton;
//intializating all element variable
	public loginpage(WebDriver driver) {
	PageFactory.initElements(driver,this);
		
	}
	public void loginaction(String uname,String pwd)
	{
		clickbutton.click();
			usernameTextField.sendKeys(uname);
		passwordTextField.sendKeys(pwd);
		submitbutton.click();
	}
	
}
