package base;

import Config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Helper;

import java.time.Duration;

public class FrameworkInitialize {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(FrameworkInitialize.class.getName());
    /*
    Setup Method to choose whichever browser the driver will run on
    according the " BrowserType " String on the Config.Settings class
     */
    @BeforeMethod
    public static void setUp() {
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
        if (Settings.BrowserType.equalsIgnoreCase("chrome")) {
            logger.trace("Chrome driver is opening");
            WebDriverManager.chromedriver().setup();
            DriverContext.Driver = new ChromeDriver(option);
            DriverContext.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            DriverContext.Driver.manage().window().maximize();
        } else if (Settings.BrowserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            DriverContext.Driver = new FirefoxDriver(option);
            logger.trace("Firefox driver is opening");
            DriverContext.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            DriverContext.Driver.manage().window().maximize();
        } else if (Settings.BrowserType.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            DriverContext.Driver = new InternetExplorerDriver(option);
            logger.trace("IE driver is opening");
            DriverContext.Driver.manage().window().maximize();
            DriverContext.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        } else if (Settings.BrowserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            DriverContext.Driver = new EdgeDriver(option);
            logger.trace("Edge driver is opening");
            DriverContext.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            DriverContext.Driver.manage().window().maximize();
        }
//        DriverContext.Driver.get(Settings.url);

        DriverContext.Driver.get(Settings.nopCommerceUrl);
    }
    /*
    tearDown method closes the driver after the run of each method
     */
    @AfterMethod
    public void tearDown() {
        DriverContext.Driver.manage().deleteAllCookies();
        DriverContext.Driver.close();
        DriverContext.Driver.quit();
        logger.trace("driver is closing");
    }
    /*
    Take ScreenShot only when test case fail and save it in the screenshot folder
     */
    @AfterMethod()
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.trace("take a screenshot of the failure");
            Helper.captureScreenShotAtFailure(DriverContext.Driver, result.getName());
        }
    }
}
