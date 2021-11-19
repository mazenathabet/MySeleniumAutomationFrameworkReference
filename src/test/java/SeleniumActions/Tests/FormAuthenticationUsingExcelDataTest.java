package SeleniumActions.Tests;

import SeleniumActions.Pages.AuthenticationPage;
import SeleniumActions.Pages.HomePage;
import base.FrameworkInitialize;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelReader;

import java.io.IOException;

public class FormAuthenticationUsingExcelDataTest extends FrameworkInitialize {
    /*
    Data provider annotation to import the Data from an outsource Excel file
    to apply the Data Driven Testing
     */
    @DataProvider(name = "ExcelData")
    public Object[][] LoginData() throws IOException {
        //get data from excel reader class
        ExcelReader ER = new ExcelReader();
        return ER.getExcelData();
    }
    @Test(priority = 1, dataProvider = "ExcelData")//Takes the Test Data from the " ExcelData " Data provider method
    public void Login(String username, String password) {
        /*
        Page Navigation - Clicking on AuthenticationLink will return us the Login Page
        instead of
        HomePage homePageObject = new HomePage();
        homePageObject.AuthenticationLink();
        AuthenticationPage authenticationPageObject = new AuthenticationPage();
        authenticationPageObject.Login(username,passwordTxt);
         */
        HomePage homePageObject = new HomePage();
        AuthenticationPage authenticationPageObject = homePageObject.AuthenticationLink();
        authenticationPageObject.Login(username, password);

    }
}
