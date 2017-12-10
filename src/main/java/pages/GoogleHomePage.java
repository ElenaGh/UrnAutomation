package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {

	private static String pageUrl = "https://www.google.com";

	public static String getUrl() {
		return pageUrl;
	}

	public static WebElement getSearchBox(WebDriver browser) {
		return browser.findElement(By.id("lst-ib"));
	}

}
