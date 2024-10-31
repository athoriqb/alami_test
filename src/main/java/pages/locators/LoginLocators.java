package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {

    @FindBy(css = "div.orangehrm-login-form")
    public WebElement loginForm;
    @FindBy(css = "input[name=username]")
    public WebElement usernameInput;
    @FindBy(css = "input[name=password]")
    public WebElement passwordInput;
    @FindBy(css = "button[class*=login-button]")
    public WebElement loginButton;
}
