package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alada_Login_LogoutPage_Factory {
	private WebDriver driver;
	// Gọi chú thích @FindBy để tạo liên kết giữa WebElement với Locator
	@FindBy(id = "txtLoginUsername")
	WebElement textEmail;
	@FindBy(id = "txtLoginPassword")
	WebElement textPass;
	@FindBy(xpath = "(//button[text()='ĐĂNG NHẬP'])[3]")
	WebElement buttonLogin;

	// Logout
	@FindBy(xpath = "//div[@class='avatar2']")
	WebElement imageAvatar;
	@FindBy(xpath = "(//a[text()='Thoát'])")
	WebElement btnThoat;

	public Alada_Login_LogoutPage_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginFunction(String email, String pass) {
		textEmail.sendKeys(email);
		textPass.sendKeys(pass);
		buttonLogin.click();
	}

	public void logoutFunction() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.alertIsPresent());
//	    driver.switchTo().alert().accept();
	    imageAvatar.click();
	    btnThoat.click();
	}
}
