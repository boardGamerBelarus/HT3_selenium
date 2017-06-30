package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.PageHelper;

public class DataEditPage implements PageHelper{

	 WebDriver driver;

	    public DataEditPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[1]/td[6]/span")
		   public WebElement textLoginOfFirstRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[2]/td[6]/span")
		   public WebElement textLoginOfSecondRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[1]/td[7]/span")
		   public WebElement textPasswordOfFirstRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[2]/td[7]/span")
		   public WebElement textPasswordOfSecondRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[1]/td[8]/span")
		   public WebElement textEmailOfFirstRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[2]/td[8]/span")
		   public WebElement textEmailOfSecondRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[1]/td[9]/span")
		   public WebElement textNameOfFirstRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[2]/td[9]/span")
		   public WebElement textNameOfSecondRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[1]/td[10]/span")
		   public WebElement textRememberOfFirstRecord;
		   
		   @FindBy(xpath = "//div[@id='page_content']/div/form/div[1]/table[2]/tbody/tr[2]/td[10]/span")
		   public WebElement textRememberOfSecondRecord;
	
}
