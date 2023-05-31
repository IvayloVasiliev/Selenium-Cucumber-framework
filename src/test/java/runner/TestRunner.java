package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = { "src\\test\\resources\\features" },
        glue = {"stepDefinition"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
