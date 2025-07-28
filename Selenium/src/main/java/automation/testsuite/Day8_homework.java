package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.CT_Page_Url;
import automation.common.commonBase;

public class Day8_homework extends commonBase {

    @Test
    //Id không cố định nên fail
    public void getElementById() {
        driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
        WebElement emailElement = driver.findElement(By.id("shub25"));
        System.out.println("User Email (by ID): " + emailElement);
    }

    @Test
    public void getElementByName() {
        driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
        WebElement passwordElement = driver.findElement(By.name("Password"));
        System.out.println("Password (by Name): " + passwordElement);
    }

    @Test
    public void getElementByClassName() {
        driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
        WebElement companyElement = driver.findElement(By.className("form-control"));
        System.out.println("Company (by Class Name): " + companyElement);
    }

    @Test
    public void getElementByTagName() {
        driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
        WebElement mobileElement = driver.findElements(By.tagName("input")).get(4);
        System.out.println("Mobile Number (by Tag Name): " + mobileElement);
    }

    @Test
    public void getElementByLinkText() {
        driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
        WebElement linkElement = driver.findElement(By.linkText("Find out how to automate these controls without XPath"));
        System.out.println("Link (by LinkText): " + linkElement);
    }

    @Test
    public void getElementByPartialLinkText() {
        driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
        WebElement partialLinkElement = driver.findElement(By.partialLinkText("A course with complex scenarios"));
        System.out.println("Link (by PartialLinkText): " + partialLinkElement);
    }
}
