package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    public void authorizationSuccessTest(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@id=\"react-burger-menu-btn\"]"))).click();
        Assertions.assertEquals(webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id=\"logout_sidebar_link\"]")))
                .isDisplayed(),true);
    }


    @AfterAll
    void quitBrowser() {
        driver.quit();
    }
}
