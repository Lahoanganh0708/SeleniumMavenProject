package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.CT_Page_Url;
import automation.common.commonBase;
public class Day8_homework2 extends commonBase{

	    @Test
	    public void getElementById() {
	    	driver = initChrome(CT_Page_Url.AUTOMATION_FC_FORM_URL);
	        WebElement emailField = driver.findElement(By.id("mail"));
	        System.out.println("Email field (by ID): " + emailField);
	    }

	    @Test
	    public void getElementByName() {
	    	driver = initChrome(CT_Page_Url.AUTOMATION_FC_FORM_URL);
	        WebElement passwordField = driver.findElement(By.name("password"));
	        System.out.println("Password field (by Name): " + passwordField);
	    }

	    @Test
	    public void getElementByTagName() {
	    	driver = initChrome(CT_Page_Url.AUTOMATION_FC_FORM_URL);
	        WebElement button = driver.findElement(By.tagName("button"));
	        System.out.println("Login Button (by Tag Name): " + button);
	    }

	    @Test
	    public void getElementByLinkText() {
	    	driver = initChrome(CT_Page_Url.AUTOMATION_FC_FORM_URL);
	        WebElement googleLink = driver.findElement(By.linkText("GOOGLE"));
	        System.out.println("Google Link (by Link Text): " + googleLink);
	    }

	    @Test
	    public void getElementByPartialLinkText() {
	    	driver = initChrome(CT_Page_Url.AUTOMATION_FC_FORM_URL);
	        WebElement facebookLink = driver.findElement(By.partialLinkText("FACE"));
	        System.out.println("Facebook Link (by Partial Link Text): " + facebookLink);
	    }

}
