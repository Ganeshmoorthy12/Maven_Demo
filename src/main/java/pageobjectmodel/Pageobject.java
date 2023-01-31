package pageobjectmodel;

import org.openqa.selenium.WebDriver;

import Baseclass.baseclass;
import Locators.homepage;
import Locators.login;

public class Pageobject extends baseclass {
	
	
	public Pageobject(WebDriver xdriver) {
		this.driver=xdriver;
	} 
	
	private login login;

	public login getLogin() {
		if (login == null) {
			login=new login(driver);
		}
		return login;
	}

	private homepage homepage;

	public homepage getHomepage() {
		if (homepage == null) {
			homepage=new homepage(driver);
			
		}
		return homepage;
	}
	
	

}
