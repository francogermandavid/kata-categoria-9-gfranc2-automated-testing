package pages.mainpages;

import constants.Locators;
import listeners.ExtentListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;

public class AddUserPage {

    @FindBy(xpath = Locators.AddUserPage.USER_ROLE_SELECTOR)
    private WebElement userRoleSelector;

    @FindBy(xpath = Locators.AddUserPage.ADMIN_ROLE_SELECTOR)
    private WebElement adminRoleSelector;

    @FindBy(xpath = Locators.AddUserPage.EMPLOYEE_NAME_TEXTBOX)
    private WebElement employeeNameTextBox;

    @FindBy(xpath = Locators.AddUserPage.FIRST_OPTION_NAME)
    private WebElement firstOptionName;

    @FindBy(xpath = Locators.AddUserPage.SELECT_STATUS)
    private WebElement selectStatus;

    @FindBy(xpath = Locators.AddUserPage.ENABLED_OPTION)
    private WebElement enabledOption;

    @FindBy(xpath = Locators.AddUserPage.USERNAME_TEXTBOX)
    private WebElement userNameTextBox;

    @FindBy(xpath = Locators.AddUserPage.PASSWORD_TEXTBOX)
    private WebElement passwordTextBox;

    @FindBy(xpath = Locators.AddUserPage.CONFIRM_PASSWORD_TEXTBOX)
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = Locators.AddUserPage.SAVE_USER_BUTTON)
    private WebElement saveUserButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public AddUserPage(WebDriver driverx) {
        this.driver = driverx;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void selectAdminRole() {
        userRoleSelector.click();
        adminRoleSelector.click();
    }

    public void setEmployeeName(String name) throws InterruptedException {
        employeeNameTextBox.sendKeys(name);
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(firstOptionName)).click();
    }

    public void setStatusEmployee() {
        selectStatus.click();
        enabledOption.click();
    }

    public void setUserName(String userName) {
        userNameTextBox.sendKeys(userName);
        ExtentListeners.logStep("El nombre ingresado es: " + userName);
    }

    public void setPassword(String password) {
        passwordTextBox.sendKeys(password);
        ExtentListeners.logStep("La contraseña ingresada es: " + password);
    }

    public void confirmPassword(String password) {
        confirmPasswordTextBox.sendKeys(password);
    }

    public void confirmSaveUser() {
        try {
            saveUserButton.click();
            WebElement confirmAddToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(Locators.AddUserPage.CONFIRM_ADD_TOAST)));
            Assert.assertTrue(confirmAddToast.getText().contains("Successfully Saved"));
            ExtentListeners.logStep("Se ha creado el usuario correctamente");
        } catch (Exception e) {
            ExtentListeners.logStep("No se ha podido crear el usuario");
            e.printStackTrace();
        }
    }
}
