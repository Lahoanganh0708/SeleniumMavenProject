package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_Page_Url;
import automation.common.commonBase;
import automation.pageLocator.LoginPage;

public class LoginTest extends commonBase {
@BeforeMethod
public void openChromeBrowser() {
	driver = initChrome(CT_Page_Url.ALADA_URL);
}
//Case 1 Login thành công
@Test
public void loginSuccessfully(){
	LoginPage login = new LoginPage(driver);
	login.LoginFunction("lahoanganh2004@gmail.com","ssuqu102");
	WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
	assertTrue(khoaHocCuaToi.isDisplayed());
}
@Test
public void loginFailWithBlank(){
	LoginPage login = new LoginPage(driver);
	login.LoginFunction("","");
	WebElement textUsernameError = driver.findElement(By.xpath("//label [@for='txtLoginUsername']"));
    assertEquals(textUsernameError.getText(), "Vui lòng nhập email");
	WebElement textPasswordError = driver.findElement(By.xpath("//label [@for='txtLoginPassword']"));
	assertEquals(textPasswordError.getText(), "Vui lòng nhập mật khẩu");
}
@Test
public void loginFailWithUsernameFalse() {
    LoginPage login = new LoginPage(driver);
    login.LoginFunction("lahoanganh@gmail.com", "ssuqu102");
    WebElement textUsernameError = driver.findElement(By.xpath("//p[@class='cred']"));
    assertEquals(textUsernameError.getText(), "Email này chưa được đăng ký.");
}

@Test
public void loginFailWithPasswordFalse() {
    LoginPage login = new LoginPage(driver);
    login.LoginFunction("lahoanganh2004@gmail.com", "12345");
    WebElement textUsernameError = driver.findElement(By.xpath("//p[@class='cred']"));
    assertEquals(textUsernameError.getText(), "Mật khẩu sai.");
}


}
