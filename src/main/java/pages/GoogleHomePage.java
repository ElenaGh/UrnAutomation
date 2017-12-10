package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends Page {

	public String getUrl() {
		return super.getUrl();
	}

	public void setUrl(String url) {
		super.setUrl(url);;
	}

	public GoogleHomePage(String url) {
		this.setUrl(url);
	}

	public WebElement getSearchBox(WebDriver browser) {
		return browser.findElement(By.id("lst-ib"));
	}
	
	public void searchFor(WebDriver browser, String searchString) {
		WebElement searchBox = browser.findElement(By.id("lst-ib")); 
		searchBox.sendKeys(searchString);
		searchBox.submit();
	}

}
