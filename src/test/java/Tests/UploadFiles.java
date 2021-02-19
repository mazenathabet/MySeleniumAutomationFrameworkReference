package Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadFiles extends FrameworkInitialize {

    public static String imageName = "avatar.jpg";
    public static String UploadPath = System.getProperty("user.dir") + "\\Uploads\\" + imageName;

    @BeforeMethod
    public void goToUploadPage() {
        DriverContext.Driver.get("https://the-internet.herokuapp.com/upload");
    }

    /*
    Uploading file/photos or images when file type is file
     */
    @Test
    public void uploadFile() {
        //Uploading using uploadControl when the element is type = file it accepts sendKeys
        By chooseFileButton = By.xpath("//input[@id='file-upload' and @name='file']");
        By uploadButton = By.xpath("//input[@id='file-submit' or @value='Upload']");

        DriverContext.Driver.findElement(chooseFileButton).sendKeys(UploadPath);
        DriverContext.Driver.findElement(uploadButton).click();
    }
}
