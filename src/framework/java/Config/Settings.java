package Config;

public class Settings {
    /*
    Set of public static variables to use over the code to apply the Data Driven Testing
     */

    public static String url = "https://the-internet.herokuapp.com/";
    public static String nopCommerceUrl = "https://demo.nopcommerce.com/";
    public static String BrowserType = "chrome";
    public static String ExcelFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\MyAutomationFrameworkTestData.xlsx";
    public static String ScreenShotsPath = System.getProperty("user.dir") + "\\src\\ScreenShots";
}
