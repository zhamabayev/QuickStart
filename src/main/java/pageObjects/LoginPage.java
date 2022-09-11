package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
        WebDriver driver;
        WebDriverWait webDriverWait;
        Actions actions;

    public LoginPage(WebDriver driver) {
            this.driver = driver;
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            actions = new Actions(driver);
            PageFactory.initElements(driver, this);
        }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;



    @Step("Логин")
    public LoginPage login(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new LoginPage(driver);
    }
}
