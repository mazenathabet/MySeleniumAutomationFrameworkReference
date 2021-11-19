package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public enum SearchPageLocators implements Locator {

    SEARCHED_PRODUCT_LABEL(By.xpath("//a[normalize-space()='Apple MacBook Pro 13-inch']")),
    SEARCHED_PRODUCT_IMAGE(RelativeLocator.with(By.tagName("img")).above(SEARCHED_PRODUCT_LABEL.by())),
    SEARCHED_PRODUCT_PRICE(RelativeLocator.with(By.tagName("span")).below(SEARCHED_PRODUCT_LABEL.by())),
    ADD_TO_CART_BUTTON(By.xpath("//button[normalize-space()='Add to cart']")),
    ;


    private By locator;




    SearchPageLocators(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }



}
