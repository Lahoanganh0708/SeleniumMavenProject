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

import automation.common.commonBase;



public class Day17_Homework extends commonBase {
	@BeforeMethod
    public void openBrowser() {
        driver = initChrome("https://mediamart.vn");
    }

	@Test
	public void HandleZaloChat() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement iconIframe = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//iframe[contains(@src,'page.widget.zalo.me') and @width='60']")));
	    driver.switchTo().frame(iconIframe);
	    click(By.xpath("//html/body"));
	    driver.switchTo().defaultContent();
	    wait.until(driver -> driver.findElements(By.xpath("//iframe[contains(@src,'page.widget.zalo.me')]")).size() > 1);
	    List<WebElement> zaloIframes = driver.findElements(By.xpath("//iframe[contains(@src,'page.widget.zalo.me')]"));
	    System.out.println("Found zalo iframes: " + zaloIframes.size());
	    driver.switchTo().frame(zaloIframes.get(1));
	    assertTrue(isElementDisplay(By.xpath("//body")), "Màn hình chat Zalo chưa hiển thị!");
	    driver.switchTo().defaultContent();
	}
}
