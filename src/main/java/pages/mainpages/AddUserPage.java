package pages.mainpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddUserPage {

    @FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
    private WebElement userRoleSelector;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")
    private WebElement adminRoleSelector;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement EmployeeNameTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div")
    private WebElement FirstOptionName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[2]")
    private WebElement selectStatus;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]")
    private WebElement enabledOption;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
    private WebElement saveUserButton;

    private WebDriver driver;

    public AddUserPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }

    public void selectAdminRole() {
        userRoleSelector.click();
        adminRoleSelector.click();
    }

    public void setEmployeeName(String name) throws InterruptedException {
        EmployeeNameTextBox.sendKeys(name);
        Thread.sleep(2000);
        FirstOptionName.click();
    }

    public void setStatusEmployee() {
        selectStatus.click();
        enabledOption.click();
    }

    public void setUserName(String userName) {
        userNameTextBox.sendKeys("1" + userName + "1234");
    }

    public void setPassword(String password) {
        passwordTextBox.sendKeys(password + "123");
    }

    public void confirmPassword(String password) {
        confirmPasswordTextBox.sendKeys(password + "123");
    }

    public void confirmSaveUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        saveUserButton.click();
        WebElement confirmAddUserToast = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"oxd-toaster_1\"]/div")));
        System.out.println(confirmAddUserToast.getText());
        Assert.assertTrue(confirmAddUserToast.getText().contains("Successfully Saved"));
    }

}
