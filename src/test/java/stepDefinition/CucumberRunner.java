package stepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",  // path to your feature file
        glue = "stepDefinition",                                   // package containing step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // optional report
        monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    }