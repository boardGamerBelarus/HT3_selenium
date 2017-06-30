package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.PageHelper;

public class TableEditStructurePage implements PageHelper {
	WebDriver driver;

	public TableEditStructurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[1]/th/label")
	   public WebElement textNameOfId;

	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[2]/th/label")
	   public WebElement textNameOfLogin;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[3]/th/label")
	   public WebElement textNameOfPassword;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[4]/th/label")
	   public WebElement textNameOfEmail;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[5]/th/label")
	   public WebElement textNameOfName;
	
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[6]/th/label")
	   public WebElement textNameOfRemember;
	
	//---------------------------------
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[1]/td[3]/bdo")
	   public WebElement textTypeOfId;

	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[2]/td[3]/bdo")
	   public WebElement textTypeOfLogin;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[3]/td[3]/bdo")
	   public WebElement textTypeOfPassword;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[4]/td[3]/bdo")
	   public WebElement textTypeOfEmail;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[5]/td[3]/bdo")
	   public WebElement textTypeOfName;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[6]/td[3]/bdo")
	   public WebElement textTypeOfRemember;
	   
//------------------------------
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[1]/td[6]")
	   public WebElement textNullOfId;

	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[2]/td[6]")
	   public WebElement textNullOfLogin;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[3]/td[6]")
	   public WebElement textNullOfPassword;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[4]/td[6]")
	   public WebElement textNullOfEmail;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[5]/td[6]")
	   public WebElement textNullOfName;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[6]/td[6]")
	   public WebElement textNullOfRemember;
	   
	   //--------------------
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[1]/td[9]")
	   public WebElement textAIOfId;
	   //--------------------

	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[2]/td[4]/dfn")
	   public WebElement textCollationOfLogin;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[3]/td[4]/dfn")
	   public WebElement textCollationOfPassword;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[4]/td[4]/dfn")
	   public WebElement textCollationOfEmail;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[5]/td[4]/dfn")
	   public WebElement textCollationOfName;
	   
	   @FindBy(xpath = "//*[@id='tablestructure']/tbody/tr[6]/td[4]/dfn")
	   public WebElement textCollationOfRemember;
	   
}
