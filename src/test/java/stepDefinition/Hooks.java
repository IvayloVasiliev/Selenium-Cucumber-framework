package stepDefinition;

import browserConfig.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static browserConfig.Driver.driver;

public class Hooks {
    private static Logger log = LogManager.getLogger(Hooks.class);

    private final static String chromeBrowser = "Chrome";
    private final static String firefoxBrowser = "Firefox";

    @Before
    public void setupDriver(){
        Driver.setupDriver(chromeBrowser);
        log.info("Chrome browser instantiated!!!");
    }

    @Before("@ExampleTaggedScenario")
    public void beforeCallingTaggedScenario() {
        log.info("*********** About to start the tagged scenario 'ExampleTaggedScenario'.");
    }

    @After
    public static void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.info("Scenario: " + scenario.getName() + " has failed and screenshots are taken!");
        }
        log.info("Driver is quiting...");
        driver.quit();
    }
}
