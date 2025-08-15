package automation.common;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class commonBase {
	public static WebDriver driver;
	private int initWaitTime = 15;

	public WebDriver initChrome(String Url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(Url);
		return driver;
	}
	public WebDriver initFirefox(String Url) {
	    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	    driver.get(Url);
	    return driver;
	}
	

	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElementPresentDOM(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	public void closeDriver() {
		if (driver != null)
			driver.close();
	}
}
