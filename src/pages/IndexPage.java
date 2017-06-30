package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.PageHelper;

public class IndexPage implements PageHelper {

	 WebDriver driver;

	    public IndexPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath = "//a[img[@title='Databases']]")
	    private WebElement linkDatabases;
	    
	    public void openDatabases(){
	    	linkDatabases.click();
	    	waitForElementPresentById(driver, "create_database_form");
	    	
	    }
	
}
