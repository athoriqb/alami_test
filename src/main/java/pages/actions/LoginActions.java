package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.LoginLocators;
import utils.ConfigReader;
import utils.DriverManager;
import utils.WaitUtils;

import java.time.Duration;

public class LoginActions {
    LoginLocators login;
    private final WaitUtils waitUtils;
    public LoginActions(WebDriver driver) {
        this.login = new LoginLocators();
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this.login);
    }

    public void navigateToLogin() {
        DriverManager.getDriver().get(ConfigReader.getProperty("base.url")+"/");
        waitUtils.waitForElementToBeVisible(login.loginForm,10);
    }

    public void inputCredentials(String username, String password) {
        System.out.println("Entering username: " + username);
        login.usernameInput.sendKeys(username);
        System.out.println("Entering password: " + password);
        login.passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        System.out.println("Clicking login button");
        login.loginButton.click();
    }
}
