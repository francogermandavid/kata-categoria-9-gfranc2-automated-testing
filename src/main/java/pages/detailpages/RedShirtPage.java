package pages.detailpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedShirtPage {
    @FindBy(xpath = "//button[@id='add-to-cart']")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backProductsBtn;
    private WebDriver driver;

    public RedShirtPage(WebDriver driverx) {
        this.driver = driverx;
        PageFactory.initElements(driver, this);
    }
    public void addRedShirtToCart() {
        addToCartBtn.click();
    }
    public void backToInventory() {
        backProductsBtn.click();
    }
}
