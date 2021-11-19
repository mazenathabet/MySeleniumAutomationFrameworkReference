package nopCommerceTraining.PageObjects;

import base.DriverActions;
import nopCommerceTraining.PageLocators.ProductPageLocators;

public class ProductPage {
    DriverActions driverActions = new DriverActions();

    public boolean verifyProductIsCorrect(String product){
        return driverActions.getElementText(ProductPageLocators.SEARCHED_PRODUCT_LABEL.by()).equalsIgnoreCase(product);
    }
    public ProductPage setProductQuantity(String quantity){
        driverActions.sendKeysToElement(quantity,ProductPageLocators.PRODUCT_QTY_FIELD.by());
        return this;
    }
    public ProductPage addToCart(){
        driverActions.clickOn(ProductPageLocators.ADD_TO_CART_BUTTON.by());
        return this;
    }
    public ShoppingCartPage goToShoppingCart(){
        driverActions.clickOn(ProductPageLocators.SHOPPING_CART_LINK_IN_NOTIFICATION.by());
        return new ShoppingCartPage ();
    }
}
