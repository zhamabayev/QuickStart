package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private SelenideElement userNameField = $(By.xpath("//*[@id=\"user-name\"]"));

    private SelenideElement passwordField = $(By.xpath("//*[@id=\"password\"]"));

    private SelenideElement loginButton = $(By.xpath("//*[@id=\"login-button\"]"));

    @Step("Логин")
    public LoginPage login(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return page(LoginPage.class);
    }
}
