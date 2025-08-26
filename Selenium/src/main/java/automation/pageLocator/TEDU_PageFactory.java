package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_PageFactory {
private WebDriver driver;
@FindBy(id="UserName") WebElement textEmail;
@FindBy(id="Password") WebElement textPass;
@FindBy(xpath="//button[text()='Đăng nhập']") WebElement buttonDN;
@FindBy(id="onesignal-slidedown-allow-button") WebElement buttonSubcribe;
@FindBy(id="my_account") WebElement buttonMyAccount;
@FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement buttonChangePass;
@FindBy(id="OldPassword") WebElement textOldPassword;
@FindBy(id="NewPassword") WebElement textNewPassword;
@FindBy(id="ConfirmNewPassword") WebElement textConfirmNewPassword;
@FindBy(xpath="//input[@value='Cập nhật']") WebElement btnCapNhat;
public TEDU_PageFactory(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public void loginFunction(String email, String pass) {
	textEmail.sendKeys(email);
	textPass.sendKeys(pass);
	buttonDN.click();
}
public void updatePassword(String oldPass, String newPass) throws InterruptedException {
	Thread.sleep(200);
	buttonSubcribe.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('my_account').click();");
	js.executeScript("arguments[0].click();", buttonChangePass);
//	buttonMyAccount.click();
//	buttonChangePass.click();
	Thread.sleep(200);
	textOldPassword.sendKeys(oldPass);
	textNewPassword.sendKeys(newPass);
	textConfirmNewPassword.sendKeys(newPass);
	btnCapNhat.click();
}
public void searchCourseJS(String keyword) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementsByName('keyword')[0].value='" + keyword + "';");
    js.executeScript("document.getElementsByName('keyword')[0].form.submit();");
    Thread.sleep(2000);
}

}
