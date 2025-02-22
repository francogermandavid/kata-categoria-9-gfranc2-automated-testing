package pages.mainpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
    private WebElement adminButton;

    @FindBy(xpath = "//button[@role='none']")
    private WebElement deployButton;

    private WebDriver driver;

    public DashBoardPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }

    public void deployOptions() {
        deployButton.click();
    }
    public void viewAdminOptions() {
        adminButton.click();
    }


}
