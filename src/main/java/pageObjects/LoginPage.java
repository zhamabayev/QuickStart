package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    public void login(String username, String password) {
        webDriverWait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }



    public void loginButtonClick() {
        loginButton.click();
    }

}
