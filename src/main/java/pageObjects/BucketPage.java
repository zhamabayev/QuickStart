package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BucketPage extends LoginPage {
    public BucketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    private WebElement secondProduct;

    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    private WebElement thirdProduct;

    @Step("Отображение продуктов в корзине")
    public BucketPage displayingProductiInBucket(){
        firstProduct.isDisplayed();
        secondProduct.isDisplayed();
        thirdProduct.isDisplayed();
    return new BucketPage(driver);
    }

}
