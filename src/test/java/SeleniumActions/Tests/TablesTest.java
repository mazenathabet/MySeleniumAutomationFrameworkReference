package SeleniumActions.Tests;

import SeleniumActions.Pages.HomePage;
import SeleniumActions.Pages.TablesPage;
import base.FrameworkInitialize;
import org.testng.annotations.Test;

public class TablesTest extends FrameworkInitialize {

    @Test
    public void TableTest() {
        HomePage homePage = new HomePage();
        TablesPage tablesPage = homePage.ClickOnTableLink();
        tablesPage.webTableTest();
    }
}
