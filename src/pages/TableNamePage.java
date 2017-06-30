package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.PageHelper;


public class TableNamePage implements PageHelper {

	WebDriver driver;


	public TableNamePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(css = "input[name=\"table\"]")
	private WebElement inputTableName;

	@FindBy(css = "input[name=\"num_fields\"]")
	private WebElement inputNumberOfColumns;

	@FindBy(css = "input[value=\"Go\"]")
	private WebElement buttonCreate;

	@FindBy(xpath = "//img[@title='Insert']")
	private WebElement linkInsert;
	
	@FindBy(xpath = "//*[@id='row_tbl_1']/td[4]/a/span/img[@title='Structure']")
	private WebElement linkStructure;
	
	@FindBy(xpath = "//*[@id='row_tbl_1']/th/a")
	private WebElement linkFirstTableName;

	public WebDriver submitNewTableName(String tableName, String numberOfColumns) {
		inputTableName.sendKeys(tableName);
		inputNumberOfColumns.clear();
		inputNumberOfColumns.sendKeys(numberOfColumns);
		buttonCreate.click();
		waitForElementPresentById(driver, "table_columns");
		return driver;
	}
	public WebDriver chooseFirstInsertLink(){
		linkInsert.click();
		return driver;
	}

	public void openStructureOfFirstTable(){
		waitForElementIsClickable(driver, linkStructure);
		linkStructure.click();
		waitForElementPresentById(driver, "tablestructure");
	}
	public void openFirstTable(){
		linkFirstTableName.click();
		waitForElementPresentByCss(driver, "div.success");
	}
}
