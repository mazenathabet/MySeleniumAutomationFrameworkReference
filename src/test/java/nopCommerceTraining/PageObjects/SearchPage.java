package nopCommerceTraining.PageObjects;

import base.DriverActions;
import nopCommerceTraining.PageLocators.SearchPageLocators;

public class SearchPage {

    DriverActions driverActions = new DriverActions();

    public Boolean checkProductNameAndImageAreCorrect(String productName){
        Boolean ImageIsDisplayed = driverActions.isElementDisplayed(SearchPageLocators.SEARCHED_PRODUCT_IMAGE.by());
        Boolean NameIsCorrect = driverActions.getElementText(SearchPageLocators.SEARCHED_PRODUCT_LABEL.by()).contains(productName);
        return  ImageIsDisplayed && NameIsCorrect;
    }
    public ProductPage goToProductPage(){
        driverActions.clickOn(SearchPageLocators.ADD_TO_CART_BUTTON.by());
        return new ProductPage();
    }
}
