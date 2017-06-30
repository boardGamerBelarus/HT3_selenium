package seleniumCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverContainer {

	public enum DriverType {
		Chrome
	}

	static DriverType driverType = DriverType.Chrome;
	static WebDriver driver = null;

	public void setDriverType(DriverType type) {
		driverType = type;
	}

	public static WebDriver getDriver() {
		if (driver == null) {

			switch (driverType) {
			case Chrome:
				System.setProperty("webdriver.chrome.driver", "C:\\JavaPrograms\\workspaceSEeclipse\\chromedriver.exe");
				return driver = new ChromeDriver();
			}
		}
		return driver;
	}

}
