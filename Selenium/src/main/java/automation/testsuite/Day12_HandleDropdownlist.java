package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automation.common.CT_Page_Url;
import automation.common.commonBase;

public class Day12_HandleDropdownlist extends commonBase {
@Test
public void handleDropdownList() {
	driver = initChrome(CT_Page_Url.CODESTAR_URL);
	WebElement dropCatg = driver.findElement(By.id("product_categories_filter"));
	Select catgSelect = new Select(dropCatg);
	//0.Kiểm tra số lượng option 
	int size = catgSelect.getOptions().size();
	assertEquals(size, 5);
	//1.chọn aws bằng hằm selectByVisibleText()
	catgSelect.selectByVisibleText("AWS");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	String actualText1 = catgSelect.getFirstSelectedOption().getText();
	assertEquals(actualText1, "AWS");
	//2.chọn lập trình web bằng hàm selectByVisibleText()
	catgSelect.selectByValue("https://codestar.vn/product-category/lap-trinh-web/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	String actualText2 = catgSelect.getFirstSelectedOption().getText();
	assertEquals(actualText2, "Lập trình web");
	//3.chọn programming course bằng hàm index
	catgSelect.selectByIndex(4);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	String actualText3 = catgSelect.getFirstSelectedOption().getText();
	assertEquals(actualText3, "Programming courses");
}

}
