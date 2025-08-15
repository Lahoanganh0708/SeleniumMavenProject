package automation.testsuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.pageLocator.LoginPage_Day13;

public class Day13_Homework extends commonBase {

    @BeforeMethod
    public void openBrowser() {
        driver = initFirefox("http://test-system.crmstar.vn/");
    }

    // 1. Login thành công
    @Test
    public void loginSuccess() {
    	LoginPage_Day13 login = new LoginPage_Day13(driver);
        login.LoginFunction("admin@gmail.com", "12345678");
        // Verify dashboard xuất hiện
        WebElement dashboardTitle = driver.findElement(By.xpath("//p[@class='text' and normalize-space()='Quản lý người dùng']"));
        Assert.assertTrue(dashboardTitle.isDisplayed(), "Không thấy Dashboard sau khi login!");
    }

    // 2. Sai email
    @Test
    public void loginFailWrongEmail() {
        LoginPage_Day13 login = new LoginPage_Day13(driver);
        login.LoginFunction("wrong@gmail.com", "12345678");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[normalize-space()='Email hoặc mật khẩu không đúng']"))
        );
        Assert.assertEquals(errorMsg.getText(), "Email hoặc mật khẩu không đúng");
    }

    // 3. Sai password
    @Test
    public void loginFailWrongPassword() {
        LoginPage_Day13 login = new LoginPage_Day13(driver);
        login.LoginFunction("admin@gmail.com", "wrongpass");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[normalize-space()='Email hoặc mật khẩu không đúng']"))
        );
        Assert.assertEquals(errorMsg.getText(), "Email hoặc mật khẩu không đúng");
    }

 // 4. Sai cả email và password
    @Test
    public void loginFailWrongBoth() {
        LoginPage_Day13 login = new LoginPage_Day13(driver);
        login.LoginFunction("wrong@gmail.com", "wrongpass");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[normalize-space()='Email hoặc mật khẩu không đúng']"))
        );
        Assert.assertEquals(errorMsg.getText(), "Email hoặc mật khẩu không đúng");
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
