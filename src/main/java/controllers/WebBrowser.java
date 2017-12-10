package controllers;

import org.openqa.selenium.WebDriver;

import pages.Page;

public interface WebBrowser {

	public WebDriver startBrowser();

	public Page openPage(Page page);

	public void closeBrowser();
}
