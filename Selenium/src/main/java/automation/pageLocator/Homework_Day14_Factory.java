package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework_Day14_Factory {
    WebDriver driver;
    WebDriverWait wait;
    public Homework_Day14_Factory(WebDriver driver) { 
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//a[@class='btn-anis-effect' and text()='Đăng Ký']")
    WebElement btnOpenRegister;
    @FindBy(id="txtFirstname") WebElement txtFirstname;
    @FindBy(id="txtEmail") WebElement txtEmail;
    @FindBy(id="txtCEmail") WebElement txtCEmail;
    @FindBy(id="txtPassword") WebElement txtPassword;
    @FindBy(id="txtCPassword") WebElement txtCPassword;
    @FindBy(id="txtPhone") WebElement txtPhone;
    @FindBy(xpath="//button[@type='submit' and contains(@class,'btn_pink_sm')]") 
    WebElement btnRegister;
    
    public void register(String name, String email, String pass, String phone){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnOpenRegister)).click();
            wait.until(ExpectedConditions.visibilityOf(txtFirstname)).sendKeys(name);
            txtEmail.sendKeys(email);
            txtCEmail.sendKeys(email);
            txtPassword.sendKeys(pass);
            txtCPassword.sendKeys(pass);
            txtPhone.sendKeys(phone);
            wait.until(ExpectedConditions.elementToBeClickable(btnRegister)).click();
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi đăng ký: " + e.getMessage());
        }
    }

    @FindBy(xpath="//a[contains(text(),'Chỉnh sửa thông tin')]") WebElement btnEditInfo;
    @FindBy(id="txtpassword") WebElement txtPasswordAcc;
    @FindBy(id="txtnewpass") WebElement txtNewPass;
    @FindBy(id="txtrenewpass") WebElement txtReNewPass;
    @FindBy(xpath="//button[normalize-space()='Lưu mật khẩu mới']") WebElement btnSave;

    public void updatePassword(String oldPass, String newPass){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnEditInfo)).click();
            wait.until(ExpectedConditions.visibilityOf(txtPasswordAcc)).clear();
            txtPasswordAcc.sendKeys(oldPass);
            txtNewPass.clear();
            txtNewPass.sendKeys(newPass);
            txtReNewPass.clear();
            txtReNewPass.sendKeys(newPass);
            wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("✅ Alert text: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi đổi mật khẩu: " + e.getMessage());
        }
    }

    @FindBy(id="txtLoginUsername") WebElement txtLoginEmail;
    @FindBy(id="txtLoginPassword") WebElement txtLoginPassword;
    @FindBy(xpath="//button[contains(text(),'ĐĂNG NHẬP')]") WebElement btnLogin;

    public void login(String username, String password) {
        try {
            WebElement txtUsername = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("txtLoginUsername"))
            );
            txtUsername.clear();
            txtUsername.sendKeys(username);

            WebElement txtPassword = driver.findElement(By.id("txtLoginPassword"));
            txtPassword.clear();
            txtPassword.sendKeys(password);

            WebElement btnLogin = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@type='submit' and normalize-space()='ĐĂNG NHẬP']")
                    )
            );
            btnLogin.click();
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi đăng nhập: " + e.getMessage());
        }
    }

    @FindBy(xpath="//a[contains(text(),'Khóa học của tôi')]")
    WebElement myCoursesLink;

    public boolean isHomeDisplayed(){
        try {
            return wait.until(ExpectedConditions.visibilityOf(myCoursesLink)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Không tìm thấy trang Home: " + e.getMessage());
            return false;
        }
    }
}
