package pages.mainpages;

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

import static constants.Locators.EditUserPage.CHANGE_PASS_CHECKBOX_XPATH;
import static constants.Locators.EditUserPage.CONFIRM_EDIT_TOAST_XPATH;
import static constants.Locators.EditUserPage.CONFIRM_PASSWORD_TEXTBOX_XPATH;
import static constants.Locators.EditUserPage.DISABLED_OPTION_XPATH;
import static constants.Locators.EditUserPage.ESS_ROLE_SELECTOR_XPATH;
import static constants.Locators.EditUserPage.PASSWORD_TEXTBOX_XPATH;
import static constants.Locators.EditUserPage.SAVE_USER_BUTTON_XPATH;
import static constants.Locators.EditUserPage.SELECT_STATUS_XPATH;
import static constants.Locators.EditUserPage.USER_ROLE_SELECTOR_XPATH;

public class EditUserPage {

    @FindBy(xpath = USER_ROLE_SELECTOR_XPATH)
    private WebElement userRoleSelector;

    @FindBy(xpath = ESS_ROLE_SELECTOR_XPATH)
    private WebElement essRoleSelector;

    @FindBy(xpath = SELECT_STATUS_XPATH)
    private WebElement selectStatus;

    @FindBy(xpath = DISABLED_OPTION_XPATH)
    private WebElement disabledOption;

    @FindBy(xpath = CHANGE_PASS_CHECKBOX_XPATH)
    private WebElement changePassCheckbox;

    @FindBy(xpath = PASSWORD_TEXTBOX_XPATH)
    private WebElement passwordTextBox;

    @FindBy(xpath = CONFIRM_PASSWORD_TEXTBOX_XPATH)
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = SAVE_USER_BUTTON_XPATH)
    private WebElement saveUserButton;

    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(EditUserPage.class.getName());

    public EditUserPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }

    public void editUserRole() {
        try {
            userRoleSelector.click();
            essRoleSelector.click();
            ExtentListeners.logStep("Rol del usuario modificado correctamente");
        } catch (Exception e) {
            ExtentListeners.logStep("Error al modificar el rol del usuario");
        }
    }

    public void editUserStatus() {
        try {
            selectStatus.click();
            disabledOption.click();
            ExtentListeners.logStep("Estado del usuario modificado correctamente");
        } catch (Exception e) {
            ExtentListeners.logStep("Error al modificar el estado del usuario");
        }
    }

    public void editUserPassword(String pass) {
        try {
            changePassCheckbox.click();
            passwordTextBox.sendKeys(pass);
            confirmPasswordTextBox.sendKeys(pass);
            saveUserButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement confirmEditToast = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath(CONFIRM_EDIT_TOAST_XPATH)));
            Assert.assertTrue(confirmEditToast.getText().contains("Successfully Updated"));
            ExtentListeners.logStep("Contraseña del usuario modificada correctamente,"
                    + "la nueva contraseña es: " + pass);
        } catch (Exception e) {
            ExtentListeners.logStep("Error al modificar la contraseña del usuario");
        }

    }
}

