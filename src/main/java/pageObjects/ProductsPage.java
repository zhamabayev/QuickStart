package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends LoginPage{
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement backpackAddButton;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement bikeLightAddButton;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    private WebElement boltTShirtAddButton;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private WebElement bucketButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавление продуктов в корзину")
    public ProductsPage addProductsToBucket() {
        backpackAddButton.click();
        bikeLightAddButton.click();
        boltTShirtAddButton.click();
        bucketButton.click();

        return new ProductsPage(driver);
    }
}
