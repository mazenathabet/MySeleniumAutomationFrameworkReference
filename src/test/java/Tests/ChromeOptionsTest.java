package Tests;

import base.DriverContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class ChromeOptionsTest {
    @Test
    public void goToUrl() {
        ChromeOptions option = new ChromeOptions();
        // Accept the SSl Certificates
        //option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        // Accept the insecure Certificates
        option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // Start our driver in incognito browser
        // " https://peter.sh/experiments/chromium-command-line-switches/ " for more arguments references
        option.addArguments("--incognito");
        //Specifies if the browser should start in fullscreen mode, like if the user had pressed F11 right after startup.
        //option.addArguments("--start-fullscreen");
        WebDriverManager.chromedriver().setup();
        // Our Driver will now use the Chrome Options we have selected
        DriverContext.Driver = new ChromeDriver(option);
        DriverContext.Driver.get("https://cookbook.seleniumacademy.com/Alerts.html");
    }


}

