package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.locators.ApplyLeaveLocators;
import utils.DateUtils;
import utils.WaitUtils;

import java.util.Map;

public class ApplyLeaveActions {
    ApplyLeaveLocators applyLeaveLocators;
    WaitUtils waitUtils;
    public ApplyLeaveActions(WebDriver driver) {
        this.applyLeaveLocators = new ApplyLeaveLocators();
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this.applyLeaveLocators);
    }

    public String selectNextAvailableDate(String month, String year) {
        selectMonthAndYear(month, year);

        for (WebElement dateElement : applyLeaveLocators.dateElements) {
            String dayText = applyLeaveLocators.displayedDay.getText();

            // Skip non-working and holiday dates
            if (!dateElement.getAttribute("class").contains("--non-working-day") &&
                    !dateElement.getAttribute("class").contains("--holiday-full")) {

                dateElement.click(); // Select the date
                return formatDate(year, month, dayText); // Return the date in yyyy-MM-dd format
            }
        }

        // Move to the next month if no valid date is found
        applyLeaveLocators.nextMonthButton.click();
        return selectNextAvailableDate(month, year); // Recursively call to find the next available date
    }

    // Helper method to format the selected date into yyyy-MM-dd
    private String formatDate(String year, String month, String day) {
        // Ensure day is two digits
        if (day.length() == 1) {
            day = "0" + day;
        }
        // Convert month name to a two-digit number using DateUtils
        String monthNumber = DateUtils.getMonthNumber(month);

        return year + "-" + monthNumber + "-" + day;
    }


    public void selectMonthAndYear(String targetMonth, String targetYear) {
        // Target month and year as integers
        int targetMonthOrder = DateUtils.getMonthOrder(targetMonth);
        int targetYearInt = Integer.parseInt(targetYear);

        while (true) {
            // Get the currently displayed month and year in the date picker
            String displayedMonth = applyLeaveLocators.displayedMonth.getText();
            String displayedYear = applyLeaveLocators.displayedYear.getText();

            // Convert the displayed month and year to integers for comparison
            int displayedMonthOrder = DateUtils.getMonthOrder(displayedMonth);
            int displayedYearInt = Integer.parseInt(displayedYear);

            // Check if the displayed month and year match the target
            if (displayedMonthOrder == targetMonthOrder && displayedYearInt == targetYearInt) {
                break; // Exit the loop if the correct month and year are displayed
            }

            // Determine whether to navigate forward or backward
            if (displayedYearInt > targetYearInt ||
                    (displayedYearInt == targetYearInt && displayedMonthOrder > targetMonthOrder)) {
                applyLeaveLocators.prevMonthButton.click(); // Navigate to previous month
            } else {
                applyLeaveLocators.nextMonthButton.click(); // Navigate to next month
            }

            // Wait for the calendar to update after each navigation
            waitUtils.waitForElementToBeVisible(applyLeaveLocators.displayedMonth, 2);
        }
    }

    public void applyLeaveWithLoop(int balance) {

    }
}
