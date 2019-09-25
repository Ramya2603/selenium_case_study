package testMeApp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Drivers {
 
	public static WebDriver gerDriver(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_B6b.01.16\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Training_B6b.01.16\\Desktop\\Browser Drivers\\geckodriver-v0.25.0-win64 (1)\\geckodriver.exe");
			return new FirefoxDriver();
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Training_B6b.01.16\\Desktop\\Browser Drivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}else {
		  
		  return null;
		}
		  
	  }
}
