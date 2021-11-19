package nopCommerceTraining.DemoTests.Search;

import base.FrameworkInitialize;
import nopCommerceTraining.PageObjects.LandingPage;
import nopCommerceTraining.PageObjects.SearchPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class searchForProduct extends FrameworkInitialize {
    String email = "sanjuanita.jacobson@hotmail.com";
    String password = "^#0@Ihp%k";
    String product = "Apple MacBook Pro 13-inch";
    @Test
    void searchExistingProduct(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .logInWithValidData(email,password)
                .searchForProduct(product);
        SearchPage sPage = new SearchPage();
        Assert.assertTrue(sPage.checkProductNameAndImageAreCorrect(product));
    }
    @Test
    void searchForProductAndGoProductPage(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .logInWithValidData(email,password)
                .searchForProduct(product);
        SearchPage sPage = new SearchPage();
        Assert.assertTrue(sPage.checkProductNameAndImageAreCorrect(product));
        sPage.goToProductPage();
    }
}
