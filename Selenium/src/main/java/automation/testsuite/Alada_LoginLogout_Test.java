package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CT_Page_Url;
import automation.common.commonBase;
import automation.pageLocator.Alada_Login_LogoutPage_Factory;

public class Alada_LoginLogout_Test extends commonBase {
@BeforeMethod
@Parameters("browser")
public void openBrowser(@Optional("chrome") String browser) {
	driver = setupDriver(browser);
	driver.get(CT_Page_Url.ALADA_URL);
}

@Test
public void LoginSuccessfully() {
	Alada_Login_LogoutPage_Factory factory = new Alada_Login_LogoutPage_Factory(driver);
	factory.loginFunction("demo_email@gmail.com", "123456");
	WebElement KhoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
	assertTrue(KhoaHocCuaToi.isDisplayed());
}
@Test
public void LogoutSuccessfully() {
	LoginSuccessfully();
	Alada_Login_LogoutPage_Factory factory = new Alada_Login_LogoutPage_Factory(driver);
	factory.logoutFunction();
	assertTrue(driver.findElement(By.xpath("//div[@class='login']")).isDisplayed());
}
}
