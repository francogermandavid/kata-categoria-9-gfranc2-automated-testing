package pages;

import constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    @FindBy(xpath = Locators.DashBoardPage.ADMIN_BUTTON_XPATH)
    private WebElement adminButton;

    @FindBy(xpath = Locators.DashBoardPage.DEPLOY_BUTTON_XPATH)
    private WebElement deployButton;

    private WebDriver driver;

    public DashBoardPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }

    public void viewAdminOptions() {
        adminButton.click();
    }


}
