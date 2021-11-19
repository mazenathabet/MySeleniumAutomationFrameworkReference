package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;

public enum ProductPageLocators implements Locator {

    SEARCHED_PRODUCT_LABEL(By.cssSelector("div[class='product-name'] h1")),
    ADD_TO_CART_BUTTON(By.xpath("//button[@class='button-1 add-to-cart-button']")),
    PRODUCT_QTY_FIELD(By.cssSelector("#product_enteredQuantity_4")),
    SHOPPING_CART_LINK_IN_NOTIFICATION(By.cssSelector("p[class='content'] a")),
    ;


    private By locator;




    ProductPageLocators(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }



}
