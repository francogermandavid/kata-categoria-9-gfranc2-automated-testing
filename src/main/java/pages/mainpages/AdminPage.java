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

public class AdminPage {
    @FindBy(xpath = Locators.AdminPage.ADD_USER_BUTTON)
    private WebElement addUserButton;

    @FindBy(xpath = Locators.AdminPage.FIRST_EMPLOYEE_NAME)
    private WebElement firstOptionEmployeeName;

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger LOGGER = Logger.getLogger(AdminPage.class.getName());

    public AdminPage(WebDriver driverx) {
        this.driver = driverx;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickAddProfile() {
        addUserButton.click();
    }

    public String getFirstEmployeeName() {
        return firstOptionEmployeeName.getText();
    }

    public void editCreatedUser() {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(Locators.AdminPage.EDIT_BUTTON)));
        editButton.click();
    }

    public void deleteCreatedUser() {
        try {
            WebElement deleteUserButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath(Locators.AdminPage.DELETE_USER_BUTTON)));
            deleteUserButton.click();
            WebElement confirmDeleteButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(Locators.AdminPage.CONFIRM_DELETE_BUTTON)));
            confirmDeleteButton.click();
            WebElement deleteUserToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(Locators.AdminPage.DELETE_TOAST)));
            Assert.assertTrue(deleteUserToast.getText().contains("Successfully Deleted"));
            ExtentListeners.logStep("Se ha eliminado el usuario correctamente");
        } catch (Exception e) {
            ExtentListeners.logStep("No se ha podido eliminar el usuario");
            e.printStackTrace();
        }

    }

    public void validateUserRole(String expectedRole) {
            WebElement userRoleField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(Locators.AdminPage.USER_ROLE_FIELD)));
            ExtentListeners.logStep("El rol del usuario es: " + userRoleField.getText());
            Assert.assertEquals(userRoleField.getText(), expectedRole);
    }

    public void validateUserStatus(String expectedStatus) {
        WebElement userStatusField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(Locators.AdminPage.USER_STATUS_FIELD)));
        ExtentListeners.logStep("El estado del usuario es: " + userStatusField.getText());
        Assert.assertEquals(userStatusField.getText(), expectedStatus);
    }

    public void validateExistenceUser(String userNameSearched) {
        try {
            WebElement searchUserNameTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(Locators.AdminPage.USERNAME_TEXTBOX)));
            searchUserNameTextBox.sendKeys(userNameSearched);
            WebElement searchUserButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath(Locators.AdminPage.SEARCH_USER_BUTTON)));
            searchUserButton.click();
            WebElement notFoundToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(Locators.AdminPage.NOT_FOUND_TOAST)));
            Assert.assertTrue(notFoundToast.getText().contains("No Records Found"));
            ExtentListeners.logStep("No se encontró información del usuario validado");
        } catch (Exception e) {
            ExtentListeners.logStep("Se encontró información del usuario validado");
            e.printStackTrace();
        }
    }
}
