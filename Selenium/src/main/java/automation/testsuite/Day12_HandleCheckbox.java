package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.CT_Page_Url;
import automation.common.commonBase;

public class Day12_HandleCheckbox extends commonBase {
    @Test
    public void chooseHobbies() {
        driver = initChrome(CT_Page_Url.DEMO_QA);
        scrollToElement(By.xpath("//label[text()='Sports']"));
        // Sports
        WebElement sportsCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        if (!sportsCheckbox.isSelected()) {
            driver.findElement(By.xpath("//label[text()='Sports']")).click();
            System.out.println("Checkbox Sports has been selected");
        }

        // Reading
        WebElement readingCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        if (!readingCheckbox.isSelected()) {
            driver.findElement(By.xpath("//label[text()='Reading']")).click();
            System.out.println("Checkbox Reading has been selected");
        }

        // Music
        WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
        if (!musicCheckbox.isSelected()) {
            driver.findElement(By.xpath("//label[text()='Music']")).click();
            System.out.println("Checkbox Music has been selected");
        }
    }
}
