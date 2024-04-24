package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = { "src\\test\\resources\\features" },
        glue = {"stepDefinition"},
        plugin = {"pretty",
        "json:target/cucumber.json",
        "html:target/cucumber-report.html",
        "junit:target/cucumber-report.xml"
}

)
public class TestRunner {
}
