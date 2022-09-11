package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductsPage extends LoginPage {
    private SelenideElement backpackAddButton = $(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));

    private SelenideElement bikeLightAddButton = $(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));

    private SelenideElement boltTShirtAddButton = $(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));

    private SelenideElement bucketButton = $(By.xpath("//*[@id=\"shopping_cart_container\"]"));

    @Step("Добавление продуктов в корзину")
    public ProductsPage addProductsToBucket() {
        backpackAddButton.click();
        bikeLightAddButton.click();
        boltTShirtAddButton.click();
        bucketButton.click();

        return page(ProductsPage.class);
    }
}
