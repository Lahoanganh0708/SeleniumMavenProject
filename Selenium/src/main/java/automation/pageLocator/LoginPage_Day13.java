package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Day13 {
    private WebDriver driver;

    // Constructor
    public LoginPage_Day13(WebDriver driver) {
        this.driver = driver;
    }

    // Action login
    public void LoginFunction(String email, String pass) {
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.clear();
            textEmail.sendKeys(email);
        }

        WebElement textPassword = driver.findElement(By.id("password"));
        if (textPassword.isDisplayed()) {
            textPassword.clear();
            textPassword.sendKeys(pass);
        }

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        if (button.isEnabled()) {
            button.click();
        }
    }
}
