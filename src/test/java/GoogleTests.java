import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controllers.ChromeBrowser;
import controllers.WebBrowser;
import net.bytebuddy.asm.Advice.This;
import pages.GoogleHomePage;

public class GoogleTests {
	private Logger LOG = Logger.getLogger(This.class.getName());

	@Test
	public void testGooglePage() {
		try {
		WebBrowser chrome = new ChromeBrowser();
		WebDriver browser = chrome.startBrowser();
		chrome.openPage(GoogleHomePage.getUrl());
		assertTrue(GoogleHomePage.getSearchBox(browser).isDisplayed());
		chrome.closeBrowser();
		} catch (Exception e) {
			LOG.severe(e.getMessage());
		}
	}
	
	@Test
	public void testGoogleSearch() {
		try {
		WebBrowser chrome = new ChromeBrowser();
		WebDriver browser = chrome.startBrowser();
		chrome.openPage(GoogleHomePage.getUrl());
		WebElement searchBox = GoogleHomePage.getSearchBox(browser);
		searchBox.sendKeys("Perfect Memorials");
		searchBox.submit();
		assertTrue(browser.findElement(By.partialLinkText("Cremation Urns")).isDisplayed());
		chrome.closeBrowser();
		} catch (Exception e) {
			LOG.severe(e.getMessage());
		}
	}
}
