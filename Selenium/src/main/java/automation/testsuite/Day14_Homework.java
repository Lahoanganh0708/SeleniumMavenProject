package automation.testsuite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.pageLocator.Homework_Day14_Factory;

public class Day14_Homework {
    WebDriver driver;
    String baseUrl = "https://alada.vn/";
    String email = "testauto" + System.currentTimeMillis() + "@gmail.com";
    String oldPass = "123456";
    String newPass = "654321";

    Homework_Day14_Factory alada;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);

        alada = new Homework_Day14_Factory(driver); 
    }

    @Test(priority=1)
    public void testRegister(){
        alada.register("Test User", email, oldPass, "0987654321");
        Assert.assertTrue(alada.isHomeDisplayed(), "❌ Register failed!");
    }

    @Test(priority=2, dependsOnMethods = "testRegister")
    public void testUpdatePassword(){
        alada.updatePassword(oldPass, newPass);
    }

    @Test(priority=3, dependsOnMethods = "testUpdatePassword")
    public void testLoginWithNewPassword(){
        driver.get(baseUrl); // load lại trang chủ để logout
        alada.login(email, newPass);
        Assert.assertTrue(alada.isHomeDisplayed(), "❌ Login failed with new password!");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
