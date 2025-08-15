package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
// tìm locator của từng element trên page, rồi thực hiện các steps 

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// 1 page là 1 đối tượng cần test cho hệ web
	public void LoginFunction(String email, String pass) {
		WebElement textEmail = driver.findElement(By.id("txtLoginUsername"));
		if (textEmail.isDisplayed()) {
			textEmail.sendKeys(email);
		}
		WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
		if (textPassword.isDisplayed()) {
			textPassword.sendKeys(pass);
		}
		WebElement button =driver.findElement(By.xpath("(//button[text()='ĐĂNG NHẬP'])[3]"));
		if (button.isEnabled()) {
			button.click();
		}

	}
}
