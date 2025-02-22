package pages.mainpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EditUserPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")
    private WebElement userRoleSelector;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]")
    private WebElement essRoleSelector;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
    private WebElement selectStatus;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[3]")
    private WebElement disabledOption;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/label/span")
    private WebElement changePassCheckbox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
    private WebElement saveUserButton;

    private WebDriver driver;

    public EditUserPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }

    public void editUserRole() {
        userRoleSelector.click();
        essRoleSelector.click();
    }

    public void editUserStatus() {
        selectStatus.click();
        disabledOption.click();
    }

    public void editUserPassword(String pass) {
        changePassCheckbox.click();
        passwordTextBox.sendKeys("098" + pass + "12345");
        confirmPasswordTextBox.sendKeys("098" + pass + "12345");
        saveUserButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement confirmEditUserToast = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"oxd-toaster_1\"]/div")));
        System.out.println(confirmEditUserToast.getText());
        Assert.assertTrue(confirmEditUserToast.getText().contains("Successfully Updated"));
    }

}
