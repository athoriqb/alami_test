package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLocators {

    @FindBy(css = "div[class*=orangehrm-dashboard-grid]")
    public WebElement homeDashboardView;
    @FindBy(css = "a[href*=LeaveModule]")
    public WebElement leaveModuleHref;
}
