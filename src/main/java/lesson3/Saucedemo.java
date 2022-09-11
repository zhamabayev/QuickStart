package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Saucedemo
{
    public static void main( String[] args ) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        //авторизация
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        //добавление в корзину
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")))
                .click();

        //отображение содержимого корзины
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();

        //удаление товара
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]")))
                .click();

        //оформление
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        //внесение данных о клиенте
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"first-name\"]")))
                .sendKeys("Test");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"last-name\"]")))
                .sendKeys("Test");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"postal-code\"]")))
                .sendKeys("1111/000000");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

        //подтверждение покупки
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();

        //возврат к списку продуктов
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();


    }
}
