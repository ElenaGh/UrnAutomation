package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	public static boolean checkProductName(WebDriver browser, String productDesc) {
		return browser.findElement(By.id("ProductName")).getText().contains(productDesc);	
	}
	
	

}
