import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.BucketPage;
import lesson8.LoginPage;
import lesson8.ProductsPage;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("Открыта главная страница")
    public void открытаГлавнаяСтраница() {
        open("https://www.saucedemo.com/");
    }

    @When("Логин")
    public void логин() {
        new LoginPage().login("standard_user", "secret_sauce");
    }

    @And("Добавить продукты в корзину")
    public void добавитьПродуктыВКорзину() {
        new ProductsPage().addProductsToBucket();
    }

    @Then("Проверить отображение добавленных продуктов в корзине")
    public void проверитьОтображениеДобавленныхПродуктовВКорзине() {
        new BucketPage().displayingProductiInBucket();
    }
}
