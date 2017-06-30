package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.PageHelper;

public class LoginPage implements PageHelper {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
    @FindBy(id = "input_username")
    private WebElement inputUsername;

    @FindBy(id = "input_password")
    private WebElement inputPassword;

    @FindBy(id = "input_go")
    private WebElement buttonSignIn;
    
    @FindBy(css = "option[value=\"en\"]")
    private WebElement optionEn;
    
    @FindBy(id = "sel-lang")
    private WebElement selectorLanguage;
    
    public void login(String login, String password) {
    	inputUsername.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSignIn.click();  
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("localhost | phpMyAdmin"));
        
    }
    public void chooseEnglishLanguage() {
    	selectorLanguage.click();
    	optionEn.click(); 
    }
}
