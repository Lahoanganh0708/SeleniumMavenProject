package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_Page_Url;
import automation.common.commonBase;

public class Day16_AlertPractive2 extends commonBase{
	@BeforeMethod
	public void openBrowser() {
		driver = initChrome(CT_Page_Url.ALERT_URL_2);
	}
	@Test 	
	public void DeleleCustomer() {
		type(By.name("cusid"), "123");
		click(By.name("submit"));
		String actual1 = driver.switchTo().alert().getText();
		assertEquals(actual1, "Do you really want to delete this Customer?");
		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		String actual2 = driver.switchTo().alert().getText();
		assertEquals(actual2, "Customer Successfully Delete!");
		driver.switchTo().alert().accept();
	}
	@AfterMethod
	public void endProcess() {
		driver.quit();
	}
}
