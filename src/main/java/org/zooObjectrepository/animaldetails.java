package org.zooObjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class animaldetails {

	@FindBy(xpath = "//input[contains(@name,'aname')]")private WebElement animaltxtfield;
	@FindBy(xpath = "//input[contains(@type,'file')]")private WebElement filetxtfield;
@FindBy(id = "cnum")private WebElement notxtfield;
@FindBy(id = "fnum")private WebElement cagetxtfield;
@FindBy(xpath = "//input[contains(@name,'breed')]")private WebElement breedtxtfield;
@FindBy(xpath = "//input[@id='desc']")private WebElement dtxtfield;
@FindBy(xpath = "//button[contains(.,'Submit')]")private WebElement clickonsubmit;
public animaldetails(WebDriver driver) {
	PageFactory.initElements(driver,this);		
	}
public void senddata(String animalname,String file, String no,String cage, String breed,String dtxt) {
	
	animaltxtfield.sendKeys(animalname);
	filetxtfield.sendKeys(file);
	notxtfield.sendKeys(no);
	cagetxtfield.sendKeys(cage);
	breedtxtfield.sendKeys(breed);
	dtxtfield.sendKeys(dtxt);
	clickonsubmit.click();
}
	
	
}
