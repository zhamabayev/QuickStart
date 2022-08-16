package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SaucedemoTest {
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
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @Test
    @DisplayName("Проверка успешной авторизации")
    public void authorizationSuccessTest() {
        driver.get(SAUCE_DEMO_URL);
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id=\"react-burger-menu-btn\"]"))).click();
        Assertions.assertEquals(webDriverWait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@id=\"logout_sidebar_link\"]")))
                .isDisplayed(), true);
    }

    //добавление в корзину
    @Test
    @DisplayName("Проверка корректного отображения Бейджа с 3 добавленными продуктами")
    public void badgeOfThreeAddedProductTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id=\"react-burger-menu-btn\"]"))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")))
                .click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))
                .getAttribute("3"), true);
    }

    @Test
    //отображение содержимого корзины
    public void visibilityOfAddedProductsInBasketTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id=\"react-burger-menu-btn\"]"))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")))
                .click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
        //1st product
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).isDisplayed(), true);
        //2nd product
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).isDisplayed(), true);
        //3rd product
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).isDisplayed(), true);
    }

    @Test
    //проверить отображение ссылок на сойте geekbrains для группы ссылок раздела информации о компании
    @DisplayName("Положительная проверка группы ссылок для раздела информации О компании")
    public void displayOfGroupsUrlsForDivisionAbaoutCompany(){
        driver.get("https://gb.ru/");

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}