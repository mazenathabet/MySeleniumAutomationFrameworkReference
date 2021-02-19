package Tests;

import Pages.DropdownPage;
import Pages.HomePage;
import base.FrameworkInitialize;
import org.testng.annotations.Test;

public class DropdownTest extends FrameworkInitialize {


    @Test
    public void dropdownTest() {
        HomePage homePage = new HomePage();
        DropdownPage dropdownPage = homePage.ClickOnDropDownLink();
        dropdownPage.selectByIndex(1);
        dropdownPage.selectByVisibleText("Option 2");
        dropdownPage.selectByValue("1");
        dropdownPage.selectFirstSelectedOption();
    }

}
