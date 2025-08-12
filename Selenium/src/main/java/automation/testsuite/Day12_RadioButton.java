package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import automation.common.CT_Page_Url;
import automation.common.commonBase;

public class Day12_RadioButton extends commonBase {
	@Test
	public void choseMale() {
		driver = initChrome(CT_Page_Url.DEMO_QA);
		scrollToElement(By.id("userNumber"));
		WebElement radioMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		boolean rdoMale = radioMale.isSelected();
		// 1.Kiểm tra giá trị mặc định
		assertEquals(rdoMale, false);
		// 2.Click vào Male
		if (radioMale.isEnabled() == true) {
			radioMale.click();
			System.out.println("Radio male was clicked");
		}
	}
	@Test
	public void choseFemale() {
		driver = initChrome(CT_Page_Url.DEMO_QA);
		scrollToElement(By.id("userNumber"));
		WebElement radioFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		boolean rdoFamale = radioFemale.isSelected();
		// 1.Kiểm tra giá trị mặc định
		assertEquals(rdoFamale, false);
		// 2.Click vào Female
		if (radioFemale.isEnabled() == true) {
			radioFemale.click();
			System.out.println("Radio female was clicked");
		}
	}
	@Test
	public void choseOther() {
		driver = initChrome(CT_Page_Url.DEMO_QA);
		scrollToElement(By.id("userNumber"));
		WebElement radioOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
		boolean rdoOther = radioOther.isSelected();
		// 1.Kiểm tra giá trị mặc định
		assertEquals(rdoOther, false);
		// 2.Click vào Other
		if (radioOther.isEnabled() == true) {
			radioOther.click();
			System.out.println("Radio other was clicked");
		}
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
