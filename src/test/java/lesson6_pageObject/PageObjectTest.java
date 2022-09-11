package lesson6_pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson7.AdditionalLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BucketPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

import java.time.Duration;

@Story("Добавление в корзину")
public class PageObjectTest {
    WebDriverWait webDriverWait;
    WebDriver driver;
    Actions actions;
    private final static String SAUCE_DEMO_URL = "https://www.saucedemo.com/";

    @BeforeAll
    static void browserSetup() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupBrowser() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);

    }

    @Test
    @Feature("Корзина")
    @DisplayName("Добавление товара в корзину")
    public void checkingAddingProductToBucket() {
        driver.get(SAUCE_DEMO_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductsToBucket();

        BucketPage bucketPage = new BucketPage(driver);
        bucketPage.displayingProductiInBucket();
    }
    @AfterEach
    void killBrowser(){
        /*LogEntries logEntries= driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: logEntries){
            Allure.addAttachment( "Элемент лога браузера", log.getMessage());
        }*/
        driver.quit();
    }
}
