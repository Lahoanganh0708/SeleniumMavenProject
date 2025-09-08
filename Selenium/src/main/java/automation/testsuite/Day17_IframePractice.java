package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import automation.common.CT_Page_Url;
import automation.common.commonBase;

public class Day17_IframePractice extends commonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser) {
    	driver = setupDriver(browser);
    	driver.get(CT_Page_Url.CODESTAR2_URL);
    }
    @Test
    public void handleIframe() {
        By locator = By.xpath("//h2[text()='Đội ngũ giảng viên']");
        scrollToElement(locator);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
       type(By.id("email"), "lahoanganh2004@gmail.com");
       clickByJS(By.xpath("//button[normalize-space()='Gửi ngay']"));
       assertTrue(isElementDisplay(By.id("email")));
    }
    
}
