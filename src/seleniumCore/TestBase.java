package seleniumCore;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;
public static String BaseURL = "http://localhost/phpMyAdmin/";

    @BeforeClass
    public static void setup() {
        driver = DriverContainer.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BaseURL);
    }
    @AfterClass
    public static void tearDown(){
    	driver.quit();
    	
    	
    }
}
