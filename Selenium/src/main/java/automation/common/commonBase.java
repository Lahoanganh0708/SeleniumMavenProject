package automation.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class commonBase {
	public static WebDriver driver;
	public WebDriver initChrome(String Url) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}
}
