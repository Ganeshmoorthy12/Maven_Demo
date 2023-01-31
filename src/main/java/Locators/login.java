package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.baseclass;

public class login extends baseclass {

	public login(WebDriver xdriver) {
		this.driver = xdriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchbox;

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchbutton;
	
	
	@FindBy()
	private WebElement click;

	public WebElement getClick() {
		return click;
	}
	
	

}
