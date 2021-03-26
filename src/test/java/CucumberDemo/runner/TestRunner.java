package CucumberDemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/**
 * features parameter is the feature package path starts from our src folder
 * glue parameter is where we set the steps package name its CucumberDemo not steps in our Project
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/CucumberDemo/features",
        glue = "CucumberDemo",
        tags = "",
        plugin =  {"pretty" , "html:target/Reports/report.html", "json:target/Reports/report.json"},
        dryRun = false)
public class TestRunner {
}
