package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CT_Page_Url;
import automation.common.commonBase;
import automation.pageLocator.TEDU_PageFactory;

public class TEDU_UpdatePass_Test extends commonBase {
	TEDU_PageFactory tedu;

	@BeforeMethod
	public void openBrowser() {
		driver = initChrome(CT_Page_Url.TEDU_URL);
		tedu = new TEDU_PageFactory(driver);
	}

	@Test
	public void loginSuccessfully() throws InterruptedException {
		tedu.loginFunction("lahoanganh2004@gmail.com", "1234567");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
	}

	@Test
	public void updatePassSuccessfully() throws InterruptedException {
		loginSuccessfully();
		tedu.updatePassword("1234567", "ssuqu102");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//div[@Class='alert alert-success']")).isDisplayed());
	}

	@Test
	public void searchCourseSuccessfully() throws InterruptedException {
		loginSuccessfully();
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
		tedu.search("Web API");
		Thread.sleep(5000);
		List<WebElement> titleSearchResults = driver.findElements(By.xpath("//div[@class='post-title']/h3/a"));
		List<WebElement> contentSearchResults = driver.findElements(By.xpath("//div[@class='post-content']/p"));
		for (WebElement titleElement : titleSearchResults) {
			String actualTitle = titleElement.getText();
			System.out.println("actualTitle is: " + actualTitle);
			if (actualTitle.contains("Web API")) {
				assertTrue(true);
			} else {
				for (WebElement contentElement : contentSearchResults) {
					String actualContent = contentElement.getText();
					System.out.println("actualContent is: " + actualContent);
					assertTrue(actualContent.contains("Web API"));
				}
			}
		}
	}
}
