package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.baseclass;

public class homepage extends baseclass {
	
	
	public homepage(WebDriver xdriver) {
	     this.driver=xdriver;
	     PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Apple iPhone 14 Pro Max 128GB Space Black']")
	private WebElement product;
	
	public WebElement getProduct() {
		return product;
	}
	
	@FindBy(name="submit.add-to-cart")
	private WebElement addcart;
	public WebElement getAddcart() {
		return addcart;
	}

	
	@FindBy(xpath="//span[@class='a-button a-button-base attach-button-large attach-cart-button']")
	private WebElement gotocart;

	

	
	public WebElement getGotocart() {
		return gotocart;
	}
	
	@FindBy(name="quantity")
	private WebElement qtyoption;

	public WebElement getQtyoption() {
		return qtyoption;
	}
	
	@FindBy(id="sc-subtotal-amount-activecart")
	private WebElement totalamount;

	public WebElement getTotalamount() {
		return totalamount;
	}
	
}
