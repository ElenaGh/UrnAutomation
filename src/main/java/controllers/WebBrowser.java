package controllers;

import org.openqa.selenium.WebDriver;

public interface WebBrowser {

	public WebDriver startBrowser();

	public void openPage(String url);

	public void closeBrowser();
}
