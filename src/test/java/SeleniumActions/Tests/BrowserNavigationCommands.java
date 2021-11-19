package SeleniumActions.Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.testng.annotations.Test;


public class BrowserNavigationCommands extends FrameworkInitialize {
    /*
    Browser Navigation such as:
    - Back button
    - Forward button
    - Refresh button (f5)
    - Navigate to url
    - Set the size of the screen ( maximize , minimize , set a size to specific dimension )
    - Set the size of the screen to full screen
     */
    @Test
    public void BrowserNavigationCommand() {
        DriverContext.Driver.navigate().to("https://the-internet.herokuapp.com/login");
        DriverContext.Driver.navigate().back();
        DriverContext.Driver.navigate().refresh();
        DriverContext.Driver.navigate().forward();
        DriverContext.Driver.manage().window().fullscreen();
        DriverContext.Driver.manage().window().maximize();
    }
}
