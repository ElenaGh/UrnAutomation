package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private static String pageUrl = "http://www.theperfecturn.com";
	
	public static String getUrl() {
		return pageUrl;
	}
	
	public static ProductPage clickProduct(WebDriver browser, String productDesc) {
		browser.findElement(By.partialLinkText(productDesc)).click();
		return new ProductPage();
	}
}
