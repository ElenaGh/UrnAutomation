import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		GoogleHomePage page = new GoogleHomePage("https://www.google.com");
		WebDriver browser = chrome.startBrowser();
		chrome.openPage(page);
		assertTrue(page.getSearchBox(browser).isDisplayed());
		chrome.closeBrowser();
		} catch (Exception e) {
			LOG.severe(e.getMessage());
		}
	}
	
	@Test
	public void testGoogleSearch() {
		try {
		WebBrowser chrome = new ChromeBrowser();
		GoogleHomePage page = new GoogleHomePage("https://www.google.com");
		WebDriver browser = chrome.startBrowser();
		chrome.openPage(page);
		page.searchFor(browser, "PerfectMemorial");
		assertTrue(browser.findElement(By.partialLinkText("Cremation Urns")).isDisplayed());
		chrome.closeBrowser();
		} catch (Exception e) {
			LOG.severe(e.getMessage());
		}
	}
}
