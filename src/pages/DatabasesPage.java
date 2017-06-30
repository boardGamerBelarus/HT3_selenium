package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.PageHelper;

public class DatabasesPage implements PageHelper {
	WebDriver driver;

	public DatabasesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "text_create_db")
	private WebElement inputDBName;

	@FindBy(id = "buttonGo")
	private WebElement buttonCreate;

	@FindBy(css = "input[value=\"auth\"]")
	private WebElement checkboxAuth;

	@FindBy(xpath = "//button[@value='Drop']")
	private WebElement checkboxDrop;

	@FindBy(css = ".submitOK")
	private WebElement buttonOkOnConfirmPopUp;
	
	@FindBy(xpath = "//*[@id='tabledatabases']/tbody/tr/td/a[contains(text(), 'auth')]")
	private WebElement linkAuthDB;

	@FindBy(xpath = "//*[@id='topmenu']/li[2]/a")
	private WebElement linkStructure;
	
	
	public WebDriver createDB(String DbName) {
		inputDBName.sendKeys(DbName);
		buttonCreate.click();
		waitForElementPresentById(driver, "create_table_form_minimal");
		return driver;
	}

	public void dropAuthDB() {
		checkboxAuth.click();

		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", checkboxDrop);

		waitForElementIsClickable(driver, buttonOkOnConfirmPopUp);
		buttonOkOnConfirmPopUp.click();
	
		waitForElementPresentByCss(driver, "div.success");
	}
	public void chooseAuthDB(){
		linkAuthDB.click();
		waitForElementPresentById(driver, "tablesForm");
		
	}
	public void openStructure(){
		linkStructure.click();
		waitForElementPresentById(driver, "tablestructure");
	}
	
}


