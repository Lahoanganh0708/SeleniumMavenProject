package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;

public class Day16_Homework2 extends commonBase {

    @BeforeMethod
    public void openBrowser() {
        driver = initChrome("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
    }

    @Test
    public void verifyAlertMessage() {
        click(By.xpath("//button[text()='Try it']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        assertEquals(actualText, "Welcome to Selenium WebDriver Tutorials");
        alert.accept();
    }
}
