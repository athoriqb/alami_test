package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.locators.LeaveLocators;
import utils.WaitUtils;

public class LeaveActions {
    LeaveLocators leaveLocators;
    WaitUtils waitUtils;

    public LeaveActions(WebDriver driver) {
        this.waitUtils = new WaitUtils(driver);
        this.leaveLocators = new LeaveLocators();
        PageFactory.initElements(driver, this.leaveLocators);
    }

    public void clickApplyTab(){
        waitUtils.waitForElementToBeClickable(leaveLocators.applyTab, 10).click();
    }
}
