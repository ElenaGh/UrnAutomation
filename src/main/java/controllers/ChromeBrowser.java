package controllers;

import java.io.File;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Page;
import repository.Constants;

public class ChromeBrowser implements WebBrowser {
	private WebDriver driver;

	private Logger LOG = Logger.getLogger(WebBrowser.class.getName());

	public ChromeBrowser() {
		System.setProperty(Constants.chromeDriverProperty, new File(Constants.chromeDriverPath).getAbsolutePath());
	}

	@Override
	public void closeBrowser() {
		if (driver == null) {
			LOG.severe("startBrowser(url) method needs to be called before calling closeBrowser()!");
			System.exit(-1);
		} else {
			LOG.info("Browser is closing!");
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public Page openPage(Page page) {
		if (driver == null) {
			LOG.severe("startBrowser(url) method needs to be called before calling closeBrowser()!");
			System.exit(-1);
		} else {
			driver.get(page.getUrl());
		}
		return page;
	}

	@Override
	public WebDriver startBrowser() {
		LOG.info("Starting Chrome browser!");
		driver = new ChromeDriver();
		return driver;
	}

}
