package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.PageHelper;

public class DataInsertPage implements PageHelper {

	WebDriver driver;

	public DataInsertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "field_2_3")
	private WebElement inputLoginLocator;
	
	@FindBy(id = "field_3_3")
	private WebElement inputPasswordLocator;
	
	@FindBy(id = "field_4_3")
	private WebElement inputEmailLocator;
	
	@FindBy(id = "field_5_3")
	private WebElement inputNameLocator;
	
	@FindBy(xpath = "//*[@id='insertForm']/table[1]/tfoot/tr/th/input")
	private WebElement buttonGo;
	
	public void fillForm(String login, String password, String email, String name){
		inputLoginLocator.sendKeys(login);
		inputPasswordLocator.sendKeys(password);
		inputEmailLocator.sendKeys(email);
		inputNameLocator.sendKeys(name);
		buttonGo.click();
		waitForElementPresentByCss(driver, "div.success");
	}
}
