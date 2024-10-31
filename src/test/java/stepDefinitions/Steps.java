package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.actions.HomeActions;
import pages.actions.LeaveActions;
import pages.actions.LoginActions;
import utils.DriverManager;

import java.time.Duration;

public class Steps {
    public static WebDriverWait wait;

    private WebDriver driver;
    private LoginActions loginActions;
    private HomeActions homeActions;
    private LeaveActions leaveActions;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        loginActions = new LoginActions(driver);
        homeActions = new HomeActions(driver);
        leaveActions = new LeaveActions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot"); // attach the screenshot to the report
        }
        driver.quit();
    }

    @Given("user login as admin")
    public void user_login_as_admin() {
        System.out.println("Step definition executed: user login as admin");
        loginActions.navigateToLogin();
        loginActions.inputCredentials("Admin","admin123");
        loginActions.clickLoginBtn();
        homeActions.verifyHomePage();
    }

    @When("user click leave")
    public void user_click_leave() {
        homeActions.clickLeave();
    }

    @When("click apply tab")
    public void click_apply_tab() {
        leaveActions.clickApplyTab();
    }

    @When("user request leave until balance {int}")
    public void user_request_leave_until_balance(Integer int1) {

    }
//
//    @When("user try applied leave")
//    public void user_try_applied_leave() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("verify error messahe")
//    public void verify_error_messahe() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
