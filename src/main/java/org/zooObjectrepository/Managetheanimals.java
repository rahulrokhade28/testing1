package org.zooObjectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managetheanimals {

	@FindBy(xpath = "//input[contains(@name,'aname')]")private WebElement animaltxtfield;
	@FindBy(xpath = "//input[contains(@type,'file')]")private WebElement filetxtfield;
	@FindBy(id = "cnum")private WebElement notxtfield;
	@FindBy(id = "fnum")private WebElement cagetxtfield;
	@FindBy(xpath = "//input[contains(@name,'breed')]")private WebElement breedtxtfield;
	@FindBy(xpath = "//input[@id='desc']")private WebElement dtxtfield;
	@FindBy(xpath = "//button[contains(.,'Submit')]")private WebElement clickonsubmit;
	@FindBy(xpath = "//th[.='Animal Name']/ancestor::table/tbody/tr/td[3]")
	private List<WebElement> verifyanimals;
	String dynamicxpath = "//table//tbody/tr/td[3][.='%s']/parent::tr/td[5]//a[.='Delete']";
	//String dynamiccountxpath="//div[@class='single-report']//h3[.='Total Animals']/following-sibling::p[.='%s']";
	@FindBy(xpath = "//i[@class='ti-dashboard']")private WebElement clockonDashboard;
    @FindBy(xpath="//h3[.='Total Animals']/parent::div/p") private WebElement animalCount;
	public Managetheanimals(WebDriver driver) {
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
	public List<WebElement> verify() {
		return verifyanimals;
	}

	public WebElement convertoElement(String replacedata,WebDriver driver)
	{
		String requiredpath = String.format(dynamicxpath, replacedata);	
		WebElement dynamicelement = driver.findElement(By.xpath(requiredpath));
		return dynamicelement;
	}

	public void deleteAnimal(WebElement ele)
	{
		ele.click();
	}
	public String animalCounts()
	{
		
	 return animalCount.getText();
	}
	public void clickOnDashboard()
	{
		clockonDashboard.click();
	}

}
