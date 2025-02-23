package tests;

import listeners.ExtentListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.mainpages.AddUserPage;
import pages.mainpages.AdminPage;
import pages.mainpages.DashBoardPage;
import pages.mainpages.EditUserPage;
import pages.mainpages.LoginPage;
import utils.DriverFactory;

import java.time.Duration;

import static utils.Config.BASE_URL;
import static utils.Config.IMPLICIT_WAIT;
import static utils.TestData.NEW_PASSWORD;
import static utils.TestData.PASSWORD;
import static utils.TestData.USER_NAME;

public class TestManageUser extends ExtentListeners {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoardPage dashboardPage;
    private AddUserPage addUserPage;
    private AdminPage adminPage;
    private EditUserPage editUserPage;
    private String correctUserName;
    private String correctPassword;
    private String validEmployeeName;


    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        loginPage = new LoginPage(driver);
        dashboardPage = new DashBoardPage(driver);
        adminPage = new AdminPage(driver);
        addUserPage = new AddUserPage(driver);
        editUserPage = new EditUserPage(driver);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        correctUserName = loginPage.getCorrectUserName();
        correctPassword = loginPage.getCorrectPassword();
    }

    @Test(priority = 0)
    public void enterAdminOptions() {
        loginPage.login(correctUserName, correctPassword);
        dashboardPage.viewAdminOptions();
    }

    @Test(priority = 1, dependsOnMethods = "enterAdminOptions")
    public void createUser() throws InterruptedException {
        validEmployeeName = adminPage.getFirstEmployeeName();
        adminPage.clickAddProfile();
        addUserPage.selectAdminRole();
        addUserPage.setEmployeeName(validEmployeeName);
        addUserPage.setStatusEmployee();
        addUserPage.setUserName(USER_NAME);
        addUserPage.setPassword(PASSWORD);
        addUserPage.confirmPassword(PASSWORD);
        addUserPage.confirmSaveUser();
    }

    @Test(priority = 2, dependsOnMethods = "createUser")
    public void editUser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        adminPage.editCreatedUser();
        editUserPage.editUserRole();
        editUserPage.editUserStatus();
        editUserPage.editUserPassword(NEW_PASSWORD);
        adminPage.validateUserRole("ESS");
        adminPage.validateUserStatus("Disabled");
    }

    @Test(priority = 3, dependsOnMethods = "editUser")
    public void deleteUser() {
        adminPage.deleteCreatedUser();
        adminPage.validateExistenceUser(USER_NAME);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
