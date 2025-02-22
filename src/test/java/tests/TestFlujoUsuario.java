package tests;

import listeners.ExtentListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.mainpages.*;
import utils.DriverFactory;

import java.time.Duration;

public class TestFlujoUsuario extends ExtentListeners {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoardPage dashboardPage;
    private AddUserPage addUserPage;
    private AdminPage adminPage;
    private EditUserPage editUserPage;
    private String correctUserName;
    private String correctPassword;
    private String validEmployeeName;
    static final String MYNAME = "German";

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage = new LoginPage(driver);
        dashboardPage = new DashBoardPage(driver);
        adminPage = new AdminPage(driver);
        addUserPage = new AddUserPage(driver);
        editUserPage = new EditUserPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        correctUserName = loginPage.getCorrectUserName();
        correctPassword = loginPage.getCorrectPassword();
    }

    public void login(String user, String pass) {
        loginPage.sendUserName(user);
        loginPage.sendPassword(pass);
        loginPage.clickLogin();
    }

    @Test(priority = 0)
    public void LoginWithCorrectCredentials() {
        login(correctUserName, correctPassword);
        dashboardPage.viewAdminOptions();
    }

    @Test(priority = 1, dependsOnMethods = "LoginWithCorrectCredentials")
    public void createUser() throws InterruptedException {
        validEmployeeName = adminPage.getFirstEmployeeName();
        adminPage.clickAddProfile();
        addUserPage.selectAdminRole();
        addUserPage.setEmployeeName(validEmployeeName);
        addUserPage.setStatusEmployee();
        addUserPage.setUserName(MYNAME);
        addUserPage.setPassword(MYNAME);
        addUserPage.confirmPassword(MYNAME);
        addUserPage.confirmSaveUser();
    }

    @Test(priority = 2, dependsOnMethods = "createUser")
    public void editUser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        adminPage.editCreatedUser();
        editUserPage.editUserRole();
        editUserPage.editUserStatus();
        editUserPage.editUserPassword(MYNAME);
        adminPage.validateUserRole("ESS");
        adminPage.validateUserStatus("Disabled");
    }

    @Test(priority = 3, dependsOnMethods = "editUser")
    public void deleteUser() {
        adminPage.deleteCreatedUser();
    }

    @AfterClass
    public void tearDown() {
        adminPage.validateExistenceUser("1"+ MYNAME +"1234");
        driver.quit();
    }
}
