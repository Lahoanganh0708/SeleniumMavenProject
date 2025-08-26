package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

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
	    tedu.searchCourseJS("ASP Net");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement result = wait.until(ExpectedConditions
	        .visibilityOfElementLocated(By.xpath("//h4[@class='title']/a[contains(text(),'ASP.NET')]")));

	    assertTrue(result.isDisplayed());
	}


}
