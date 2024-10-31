package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.locators.HomeLocators;
import utils.WaitUtils;

public class HomeActions {
    HomeLocators homeLocators;
    WaitUtils waitUtils;

    public HomeActions(WebDriver driver) {
        this.homeLocators = new HomeLocators();
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this.homeLocators);
    }

    public void verifyHomePage() {
        assert homeLocators.homeDashboardView.isDisplayed() : "Home page is not displayed";
    }

    public void clickLeave(){
        waitUtils.waitForElementToBeClickable(homeLocators.leaveModuleHref,5).click();
    }
}
