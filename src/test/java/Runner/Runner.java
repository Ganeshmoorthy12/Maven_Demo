package Runner;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Baseclass.baseclass;
import pageobjectmodel.Pageobject;

public class Runner extends baseclass {

	public static void main(String[] args) throws IOException, Exception {

		Browserlaunch();
		geturl(excelread(0, 0));
		maximize();
		Pageobject obj = new Pageobject(driver);
		elementsendkey(obj.getLogin().getSearchbox(), excelread(1, 0));
		elementclick(obj.getLogin().getSearchbutton());
		elementclick(obj.getHomepage().getProduct());
		switchTowindow("Apple iPhone 14 Pro Max 128GB Space Black : Amazon.in");
		addcart(obj.getHomepage().getAddcart());
		Timeout();
		elementclick(obj.getHomepage().getGotocart());
		Timeout();
		int q=2;
		dropdown(obj.getHomepage().getQtyoption(), "index", String.valueOf(q));
		Threadsleepforsec(3);
		
		WebElement price = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
	    String text = price.getText().replaceAll("[^0-9]", "").replace(" ", "");
	    int Exp_price = Integer.parseInt(text)*q;
	    System.out.println(Exp_price);
	    
	    WebElement price1 = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]"));
	    String text1 = price1.getText().replaceAll("[^0-9]", "").replace(" ", "");
	    int Act_price = Integer.parseInt(text1);
	    System.out.println(Act_price);
	    
	    if (Exp_price==Act_price) {
			System.out.println("Pass");
			
		}else {
			System.out.println("Fail");
		}


	
	 
	    
	}
	


	
}