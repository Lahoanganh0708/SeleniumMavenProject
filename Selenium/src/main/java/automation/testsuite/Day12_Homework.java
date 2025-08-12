package automation.testsuite;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automation.common.commonBase;


public class Day12_Homework extends commonBase {


    @Test
    public void handleDropdownList() {
        driver = initChrome("http://globalsqa.com/demo-site/select-dropdown-menu/");
        WebElement dropCountry = driver.findElement(By.tagName("select"));
        Select countrySelect = new Select(dropCountry);
        countrySelect.selectByVisibleText("Viet Nam");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText = countrySelect.getFirstSelectedOption().getText();
        assertEquals(actualText, "Viet Nam");
    }
}
