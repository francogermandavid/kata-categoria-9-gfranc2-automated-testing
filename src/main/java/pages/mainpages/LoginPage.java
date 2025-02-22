package pages.mainpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[normalize-space()='Username : Admin']")
    private WebElement userNameFrame;

    @FindBy(xpath = "//p[normalize-space()='Password : admin123']")
    private WebElement passwordFrame;

    private WebDriver driver;
    private String userNameText;
    private String passwordText;
    private String userName;
    private String password;


    public LoginPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }

    public String getCorrectUserName() {
        userNameText = userNameFrame.getText();
        userName = userNameText.split(":")[1].trim();
        return userName;
    }

    public String getCorrectPassword() {
        passwordText = passwordFrame.getText();
        password = passwordText.split(":")[1].trim();
        return password;
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
}
