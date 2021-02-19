package base;

import Config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import utilities.Helper;

public class FrameworkInitialize {
    /*
    Setup Method to choose whichever browser the driver will run on
    according the " BrowserType " String on the Config.Settings class
     */
    @BeforeClass
    public static void setUp() {
        if (Settings.BrowserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            DriverContext.Driver = new ChromeDriver();
            System.out.println("Driver is Starting ..");
            DriverContext.Driver.manage().window().maximize();
        } else if (Settings.BrowserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            DriverContext.Driver = new FirefoxDriver();
            System.out.println("Driver is Starting ..");
            DriverContext.Driver.manage().window().maximize();
        } else if (Settings.BrowserType.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            DriverContext.Driver = new InternetExplorerDriver();
            System.out.println("Driver is Starting ..");
            DriverContext.Driver.manage().window().maximize();
        } else if (Settings.BrowserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            DriverContext.Driver = new EdgeDriver();
            System.out.println("Driver is Starting ..");
            DriverContext.Driver.manage().window().maximize();
        }
        DriverContext.Driver.get(Settings.url);
    }
    /*
    tearDown method closes the driver after the run of each class
     */
    @AfterClass
    public void tearDown() {
        DriverContext.Driver.quit();
        System.out.println("Driver is closing .. ");
    }
    /*
    Take ScreenShot only when test case fail and save it in the screenshot folder
     */
    @AfterMethod(enabled = false)
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Taking Screenshot ....");
            Helper.captureScreenShotAtFailure(DriverContext.Driver, result.getName());
        }
    }
}
