package constants;

public class Locators {
    public static class AdminPage {
        public static final String ADD_USER_BUTTON = "//button[normalize-space()='Add']";
        public static final String FIRST_EMPLOYEE_NAME = "//div[@role='rowgroup']"
                + "//div[1]//div[1]//div[4]//div[1]";
        public static final String EDIT_BUTTON = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]";
        public static final String DELETE_USER_BUTTON = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[1]";
        public static final String CONFIRM_DELETE_BUTTON = "//*[@id='app']/div[3]/div/div/div/div[3]/button[2]";
        public static final String DELETE_TOAST = "//*[@id='oxd-toaster_1']/div[1]";
        public static final String USER_ROLE_FIELD = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]";
        public static final String USER_STATUS_FIELD = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[5]";
        public static final String USERNAME_TEXTBOX = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input";
        public static final String SEARCH_USER_BUTTON = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]";
        public static final String NOT_FOUND_TOAST = "//*[@id='oxd-toaster_1']/div[2]";
    }

    public static class AddUserPage {
        public static final String USER_ROLE_SELECTOR = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]";
        public static final String ADMIN_ROLE_SELECTOR = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]";
        public static final String EMPLOYEE_NAME_TEXTBOX = "//input[@placeholder='Type for hints...']";
        public static final String FIRST_OPTION_NAME = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div";
        public static final String SELECT_STATUS = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[2]";
        public static final String ENABLED_OPTION = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]";
        public static final String USERNAME_TEXTBOX = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input";
        public static final String PASSWORD_TEXTBOX = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input";
        public static final String CONFIRM_PASSWORD_TEXTBOX = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input";
        public static final String SAVE_USER_BUTTON = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]";
        public static final String CONFIRM_ADD_TOAST = "//*[@id='oxd-toaster_1']/div";
    }

    public static class DashBoardPage {
        public static final String ADMIN_BUTTON_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a";
        public static final String DEPLOY_BUTTON_XPATH = "//button[@role='none']";
    }

    public static class EditUserPage {
        public static final String USER_ROLE_SELECTOR_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i";
        public static final String ESS_ROLE_SELECTOR_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]";
        public static final String SELECT_STATUS_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i";
        public static final String DISABLED_OPTION_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[3]";
        public static final String CHANGE_PASS_CHECKBOX_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/label/span";
        public static final String PASSWORD_TEXTBOX_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input";
        public static final String CONFIRM_PASSWORD_TEXTBOX_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input";
        public static final String SAVE_USER_BUTTON_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]";
        public static final String CONFIRM_EDIT_TOAST_XPATH = "//*[@id=\"oxd-toaster_1\"]/div";
    }

    public static class LoginPage {
        public static final String USERNAME_TEXTBOX_XPATH = "//input[@placeholder='Username']";
        public static final String PASSWORD_TEXTBOX_XPATH = "//input[@placeholder='Password']";
        public static final String LOGIN_BUTTON_XPATH = "//button[@type='submit']";
        public static final String USERNAME_FRAME_XPATH = "//p[normalize-space()='Username : Admin']";
        public static final String PASSWORD_FRAME_XPATH = "//p[normalize-space()='Password : admin123']";
    }
}
