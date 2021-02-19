package Tests;

import Pages.CheckBoxPage;
import Pages.HomePage;
import base.FrameworkInitialize;
import org.testng.annotations.Test;

public class CheckBoxAndRadioButtons extends FrameworkInitialize {

    @Test
    public void CheckBoxesTest() {
        HomePage homePage = new HomePage();
        CheckBoxPage checkBoxPage = homePage.ClickOnCheckBoxLink();
        checkBoxPage.selectCheckBox();
    }
}
