package automation.common;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

	public WebDriver initEdgeDriver(String Url) {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(Url);
		return driver;
	}

	private WebDriver initEdgeDriver() {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initFirefox() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initChrome() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
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

	// Wrap phuong thuc isDisplay
	public boolean isElementDisplay(By locator) {
		try {
			WebElement element = getElementPresentDOM(locator);
			return element.isDisplayed();
		} catch (NoSuchElementException ex1) {
			return false;
		} catch (TimeoutException ex2) {
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	// Wrap phuong thuc click bang isElementTobeClickAble
	public void click(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = getElementPresentDOM(locator);
		element.click();
	}

	// Wrap phuong thuc type
	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void closeDriver() {
		if (driver != null)
			driver.close();
	}

	public void clickByJS(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].click();", element);
	}

	public WebDriver setupDriver(String browserName) {
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			System.out.println("Running with Chrome Driver");
			driver = initChrome();
			break;
		case "firefox":
			System.out.println("Running with FireFox Driver");
			driver = initFirefox();
			break;
		case "edge":
			System.out.println("Running with Edge Driver");
			driver = initEdgeDriver();
			break;
		default:
			System.out.println("Browser: " + browserName + " is invalid. Launching Chrome as default browser...");
			driver = initChrome();
		}
		return driver;
	}
}
