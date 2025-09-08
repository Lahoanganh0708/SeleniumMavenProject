package automation.testsuite;
import static org.testng.Assert.assertTrue;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.commonBase;
public class Day18_Homework1 extends commonBase {
	@Parameters("browser")
    @BeforeMethod
    public void openBrowser(String browser) {
        driver = setupDriver(browser);
        driver.get("https://dienmaynhapkhaugiare.com.vn");
    }

    @Test
    public void checkZaloLink() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id='zalo-vr']//a")).click();
        Thread.sleep(2000);
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        assertTrue(driver.getCurrentUrl().contains("https://zalo.me/0965880198"));
    }
	//    @AfterMethod
	//    public void closeBrowser() {
	//        if (driver != null) {
	//            driver.quit();
	//        }
	//    }
}
