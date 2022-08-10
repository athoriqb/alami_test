package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static String productName;
    public static String productCart;

    @Before
    public void setUp() {
        // explicit wait condition
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("open elevania page")
    public void open_elevania_page() {
        driver.get("https://www.elevenia.co.id/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#mainPopBanner[style=\"display: none;\"]")));
        driver.findElement(By.cssSelector("input#AKCKwd")).sendKeys("komputer");
        driver.findElement(By.cssSelector("div[class='header-big'] button[class='btn-search']")).click();
    }

    @When("user choose produk terlaris")
    public void user_choose_produk_terlaris() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Produk terlaris']"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Produk terlaris' and @class=\"active\"]")));
    }

    @When("choose first product")
    public void choose_first_product() {
        productName = driver.findElement(By.xpath("//ul[@class='albumList revampList'][1]//li[@class='itemList'][1]//a[@class='pordLink notranslate']")).getText();
        System.out.println("Product Name : " + productName);
        driver.findElement(By.cssSelector("ul[class='albumList revampList']:first-of-type li[class='itemList']:first-of-type")).click();
    }

    @When("add {int} quantity of product to shopping cart")
    public void add_quantity_of_product_to_shopping_cart(Integer qty) {
        String eleIncQtyBtn = "div[class=\"productOrder optionArea\"] button[class=\"ico_btnType incre\"]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='notranslate' and text()=\""+productName+"\"]")));
        int n = 1;
        while (n < qty) {
            driver.findElement(By.cssSelector(eleIncQtyBtn)).click();
            n++;
        }
        driver.findElement(By.cssSelector("a[class=\"btnStyle btnFlat btnL btnOrangeW\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class=\"layPopWrap popCart1\"] a[class=\"btnStyle btnS btnRed\"]"))).click();
    }

    @When("choose shipping")
    public void choose_shipping() throws InterruptedException {
        productCart = "//table[contains(@class,'shoppingList')]//a[contains(text(),\""+productName+"\")]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productCart)));
        driver.findElement(By.xpath(productCart+"//following::a[@name='deliveryChangePopup']")).click();
        Thread.sleep(2000);
    }

    @When("click Batal")
    public void click_batal() {
        WebElement popUpCourierFrame = driver.findElement(By.cssSelector("iframe#ifrLayer"));
        driver.switchTo().frame(popUpCourierFrame);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section[class=\"openPopup smallPop kurirPop\"] a[class=\"btnStyle btnM btnWGray\"]"))).click();
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("section[class=\"openPopup smallPop kurirPop\"] a[class=\"btnStyle btnM btnWGray\"]")));
        driver.switchTo().defaultContent();
    }

    @When("choose Hapus")
    public void choose_hapus() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productCart+"//following::a[@class=\"btnStyle btnS btnWGray\" and text()='Hapus']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a#chkDelPopY"))).click();
    }

    @Then("product deleted in shopping cart")
    public void product_deleted_in_shopping_cart() {
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(productCart)));
    }
}
