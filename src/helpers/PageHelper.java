package helpers;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface PageHelper {

	default public void waitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}

	default public void waitForElementPresentById(WebDriver driver, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(selector)));
	}

	default public void waitForElementPresentByCss(WebDriver driver, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
	}

	default public void waitForElementIsClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	// -----------

	public static void assertElementNotPresentByCss(WebDriver driver, String selector) {
		try {
			driver.navigate().refresh();
			driver.findElement(By.cssSelector(selector));
			fail("Element with selector <" + selector + "> is present");
		} catch (NoSuchElementException ex) {

		}
	}
}
