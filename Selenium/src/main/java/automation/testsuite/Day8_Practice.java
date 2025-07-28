package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CT_Page_Url;
import automation.common.commonBase;

public class Day8_Practice extends commonBase {
	@Test
	public void getElementById() {
		driver = initChrome(CT_Page_Url.ALADA_URL);
		WebElement emailElement = driver.findElement(By.id("txtLoginUsername"));
		System.out.println("emailElement:" + emailElement);

	}

	@Test
	public void getElementByName() {
		driver = initChrome(CT_Page_Url.ALADA_URL);
		WebElement passElement = driver.findElement(By.name("txtLoginPassword"));
		System.out.println("passElement:" + passElement);
		
	}
	@Test
	public void getElementByLinkText() {
		driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
		WebElement textFindOut = driver.findElement(By.linkText("Find out how to automate these controls without XPath"));
		System.out.println("textFindOut:" + textFindOut);
		
	}
	@Test
	public void getElementByPartialLinkText() {
		driver = initChrome(CT_Page_Url.SELECTOR_HUB_URL);
		WebElement textCourse = driver.findElement(By.partialLinkText("A course with complex scenarios"));
		System.out.println("textCourse:" + textCourse);
		
	}
}