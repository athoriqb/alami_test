package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ApplyLeaveLocators {

    @FindBy(css = "div.oxd-select-wrapper")
    public WebElement leaveTypeDropdown;
    @FindBy(xpath = "//div[@role=\"listbox\"]//span[text()='CAN - FMLA']")
    public WebElement FMLAOption;
    @FindBy(css = "p.orangehrm-leave-balance-text")
    public WebElement leaveBalanceText;
    @FindBy(xpath = "//input[contains(@class,'oxd-input--active') and ./ancestor::div[contains(@class,'oxd-grid-item--gutters')]//div[contains(@class,'input-group')]//label[contains(text(),'From Date') and contains(@class,'oxd-input-field-required')]]")
    public WebElement fromDateInput;
    @FindBy(xpath = "//input[contains(@class,'oxd-input--active') and ./ancestor::div[contains(@class,'oxd-grid-item--gutters')]//div[contains(@class,'input-group')]//label[contains(text(),'To Date') and contains(@class,'oxd-input-field-required')]]")
    public WebElement toDateInput;
    @FindBy(xpath = "//div[contains(@class,'oxd-select-text-input') and ./ancestor::div[@class='oxd-form-row']//label[text()='Duration']]")
    public WebElement durationText;
    @FindBy(css = "button[type=submit]")
    public WebElement applyButton;
    @FindBy(css = ".oxd-calendar-date-wrapper")
    public List<WebElement> dateElements;
    @FindBy(css = ".bi-chevron-right")
    public WebElement nextMonthButton;
    @FindBy(css = ".oxd-calendar-selector-month .oxd-text")
    public WebElement displayedMonth;
    @FindBy(css = ".oxd-calendar-selector-year .oxd-text")
    public WebElement displayedYear;
    @FindBy(css = ".oxd-icon.bi-chevron-left")
    public WebElement prevMonthButton;
    @FindBy(css = "div.oxd-calendar-date")
    public WebElement displayedDay;
}
