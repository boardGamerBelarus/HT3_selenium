package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.PageHelper;
import helpers.RowOnStucturePage;

public class TableCreateStructurePage implements PageHelper{
	
	WebDriver driver;
	RowOnStucturePage rowOnStucturePage;
	private WebElement inputNameElement;
	private WebElement selectorTypeElement;
	private WebElement optionTypeElement;
	private WebElement inputValuesElement;
	private WebElement checkboxAIElement;
	JavascriptExecutor javascriptExecutor;
	
	public TableCreateStructurePage(WebDriver driver, RowOnStucturePage rowOnStucturePage) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		this.rowOnStucturePage = rowOnStucturePage;
		inputNameElement = driver.findElement(By.id(rowOnStucturePage.inputNameLocator));
		selectorTypeElement = driver.findElement(By.id(rowOnStucturePage.selectorTypeLocator));
		optionTypeElement = driver.findElement(By.xpath(rowOnStucturePage.optionTypeLocator));
		inputValuesElement = driver.findElement(By.id(rowOnStucturePage.inputValuesLocator));
		checkboxAIElement = driver.findElement(By.id(rowOnStucturePage.checkboxAILocator));
	}

	@FindBy(id = "index_edit_fields")
	private WebElement popUpAddIndex;
	
	
	@FindBy(xpath = "//button[span[contains(text(), 'Go')]]")
	private WebElement buttonSubmitPopUpAddIndex;
	
	@FindBy(xpath = "//select[@name=\"tbl_collation\"]")
	private WebElement selectorCollation;
	
	@FindBy(xpath = "//select[@name=\"tbl_collation\"]/optgroup/option[@value = \"utf8_general_ci\"]")
	private WebElement optionUtf8_general_ci;
	
	@FindBy(xpath = "//input[@name=\"do_save_data\"]")
	private WebElement inputSubmit;
	
	public void fillRows() {
		inputNameElement.sendKeys(rowOnStucturePage.inputNameValue);
		selectorTypeElement.click();
		optionTypeElement.click();
		inputValuesElement.sendKeys(rowOnStucturePage.inputValuesName);
		if(rowOnStucturePage.checkboxAIValue.equals("1")){
		checkboxAIElement.click();
		waitForElementPresentById(driver, "index_edit_fields");
		buttonSubmitPopUpAddIndex.click();
		}
		javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollTo(0,0);");
	}
	public void setEncodindAndSubmit(){
		javascriptExecutor.executeScript("window.scrollTo(0,250);");
		selectorCollation.click();
		optionUtf8_general_ci.click();
		inputSubmit.click();
		waitForElementPresentById(driver, "tablestructure");
		
	}
}
