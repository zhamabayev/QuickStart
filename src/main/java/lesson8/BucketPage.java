package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BucketPage {

    private SelenideElement firstProduct = $(By.xpath("//*[@id=\"item_4_title_link\"]/div"));

    private SelenideElement secondProduct = $(By.xpath("//*[@id=\"item_0_title_link\"]/div"));

    private SelenideElement thirdProduct = $(By.xpath("//*[@id=\"item_1_title_link\"]/div"));



    @Step("Отображение продуктов в корзине")
    public BucketPage displayingProductiInBucket(){
        firstProduct.isDisplayed();
        secondProduct.isDisplayed();
        thirdProduct.isDisplayed();
    return page(BucketPage.class);
    }

}
