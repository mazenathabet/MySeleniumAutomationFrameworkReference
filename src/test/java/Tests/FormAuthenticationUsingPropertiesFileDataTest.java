package Tests;

import Pages.AuthenticationPage;
import Pages.HomePage;
import base.FrameworkInitialize;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FormAuthenticationUsingPropertiesFileDataTest extends FrameworkInitialize {
    /*
     *the following method reads the data from properties file with a given key and returns the value of that key
     */
    public String readFromPropertiesFile(String key) {
        Properties props = new Properties();
        try {
            File file = new File("src/test/java/data/AuthenticationData.properties");
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(props.getProperty("AuthUsername"));
        System.out.println(props.getProperty("AuthPassword"));
        return props.getProperty(key);
    }
    @Test(priority = 1)
    public void Login() {
        /*
        Page Navigation - Clicking on AuthenticationLink will return us the Login Page
        instead of
        HomePage homePageObject = new HomePage();
        homePageObject.AuthenticationLink();
        AuthenticationPage authenticationPageObject = new AuthenticationPage();
        authenticationPageObject.Login(username,passwordTxt);
         */
        String username = readFromPropertiesFile("AuthUsername");
        String password = readFromPropertiesFile("AuthPassword");
        HomePage homePageObject = new HomePage();
        AuthenticationPage authenticationPageObject = homePageObject.AuthenticationLink();
        authenticationPageObject.Login(username, password);

    }
}
