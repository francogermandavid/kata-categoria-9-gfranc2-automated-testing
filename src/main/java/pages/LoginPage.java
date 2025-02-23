package pages;

import listeners.ExtentListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Locators.LoginPage.LOGIN_BUTTON_XPATH;
import static constants.Locators.LoginPage.PASSWORD_FRAME_XPATH;
import static constants.Locators.LoginPage.PASSWORD_TEXTBOX_XPATH;
import static constants.Locators.LoginPage.USERNAME_FRAME_XPATH;
import static constants.Locators.LoginPage.USERNAME_TEXTBOX_XPATH;

public class LoginPage {

    @FindBy(xpath = USERNAME_TEXTBOX_XPATH)
    private WebElement userNameTextBox;

    @FindBy(xpath = PASSWORD_TEXTBOX_XPATH)
    private WebElement passwordTextBox;

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;

    @FindBy(xpath = USERNAME_FRAME_XPATH)
    private WebElement userNameFrame;

    @FindBy(xpath = PASSWORD_FRAME_XPATH)
    private WebElement passwordFrame;

    private WebDriver driver;

    public LoginPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }

    public String getCorrectUserName() {
        return userNameFrame.getText().split(":")[1].trim();
    }

    public String getCorrectPassword() {
        return passwordFrame.getText().split(":")[1].trim();
    }

    public void sendUserName(String username) {
        userNameTextBox.sendKeys(username);
    }

    public void sendPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String user, String pass) {
        try {
            sendUserName(user);
            sendPassword(pass);
            clickLogin();
            ExtentListeners.logStep("Se realizó el login correctamente");
        } catch (Exception e) {
            ExtentListeners.logStep("Hubo un error al realizar el login");
            e.printStackTrace();
        }
    }
}

