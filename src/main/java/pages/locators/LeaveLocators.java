package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeaveLocators {

    @FindBy(xpath = "//a[text()='Apply']")
    public WebElement applyTab;
}
