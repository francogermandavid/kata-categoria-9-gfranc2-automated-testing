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

public class AdminPage {
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addUserButton;

    @FindBy(xpath = "//div[@role='rowgroup']//div[1]//div[1]//div[4]//div[1]")
    private WebElement firstOptionEmployeeName;

    private WebDriver driver;
    private String firstEmployeeName;
    private WebDriverWait wait;
    private String editButtonLocator = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]";
    private String deleteUserButtonLocator = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[1]";
    private String confirmDeleteButtonLocator = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]";
    private String deleteUserToastLocator = "//*[@id=\"oxd-toaster_1\"]/div";
    private String userRoleFieldLocator = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]";
    private String userStatusFieldLocator = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[5]";
    private String userNameTextBoxLocator = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input";
    private String searchUserButtonLocator = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]";
    private String notFoundToastLocator = "//*[@id=\"oxd-toaster_1\"]/div";

    public AdminPage(WebDriver driverx) {
        this.driver = driverx;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickAddProfile() {
        addUserButton.click();
    }

    public String getFirstEmployeeName() {
        firstEmployeeName = firstOptionEmployeeName.getText();
        return firstEmployeeName;
    }

    public void editCreatedUser() {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(editButtonLocator)));
        editButton.click();
    }

    public void deleteCreatedUser() {
        WebElement deleteUserButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteUserButtonLocator)));
        deleteUserButton.click();
        WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmDeleteButtonLocator)));
        confirmDeleteButton.click();
        WebElement deleteUserToast = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteUserToastLocator)));
        System.out.println(deleteUserToast.getText());
        Assert.assertTrue(deleteUserToast.getText().contains("Successfully Deleted"));

    }

    public void validateUserRole(String expectedRole) {
        WebElement userRoleField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userRoleFieldLocator)));
        System.out.println(userRoleField.getText());
        Assert.assertEquals(userRoleField.getText(), expectedRole);
    }

    public void validateUserStatus(String expectedStatus) {
        WebElement userStatusField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userStatusFieldLocator)));
        System.out.println(userStatusField.getText());
        Assert.assertEquals(userStatusField.getText(), expectedStatus);
    }

    public void validateExistenceUser(String userNameSearched) throws InterruptedException {
        Thread.sleep(3000);
        WebElement searchUserNameTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userNameTextBoxLocator)));
        searchUserNameTextBox.sendKeys(userNameSearched);
        WebElement searchUserButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchUserButtonLocator)));
        searchUserButton.click();
        WebElement notFoundToast = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(notFoundToastLocator)));
        System.out.println(notFoundToast.getText());
        Assert.assertTrue(notFoundToast.getText().contains("No Records Found"));
    }
}
