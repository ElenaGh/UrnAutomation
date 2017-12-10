import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controllers.ChromeBrowser;
import controllers.WebBrowser;
import net.bytebuddy.asm.Advice.This;
import pages.GoogleHomePage;
import pages.HomePage;
import pages.ProductPage;

public class GoogleTests {
	private Logger LOG = Logger.getLogger(This.class.getName());
	private WebBrowser chrome;

	@Test
	public void testGooglePage() {
		try {
		chrome = new ChromeBrowser();
		WebDriver browser = chrome.startBrowser();
		chrome.openPage(GoogleHomePage.getUrl());
		assertTrue(GoogleHomePage.getSearchBox(browser).isDisplayed());
		} catch (Exception e) {
			LOG.severe(e.getMessage());
			fail();
		} finally {
			chrome.closeBrowser();
		}
	}
	
	@Test
	public void testGoogleSearch() {
		try {
		chrome = new ChromeBrowser();
		WebDriver browser = chrome.startBrowser();
		chrome.openPage(GoogleHomePage.getUrl());
		WebElement searchBox = GoogleHomePage.getSearchBox(browser);
		searchBox.sendKeys("Perfect Memorials");
		searchBox.submit();
		assertTrue(browser.findElement(By.partialLinkText("Cremation Urns")).isDisplayed());
		} catch (Exception e) {
			LOG.severe(e.getMessage());
			fail();
		} finally {
			chrome.closeBrowser();
		}	
	}
	
	@Test
	public void testProductPage() {
		try {
		chrome = new ChromeBrowser();
		WebDriver browser = chrome.startBrowser();
		chrome.openPage(HomePage.getUrl());
		HomePage.clickProduct(browser, "Long Hair Cat");
		assertTrue(ProductPage.checkProductName(browser, "Long Hair Cat Figurine Cremation Urn - Engravable"));
		} catch (Exception e) {
			LOG.severe(e.getMessage());
			fail();
		} finally {
			chrome.closeBrowser();
		}
	}
}
