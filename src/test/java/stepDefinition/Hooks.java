package stepDefinition;

import browserConfig.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private final static String chromeBrowser = "Chrome";
    private final static String firefoxBrowser = "Firefox";

    @Before
    public void setupDriver(){
        Driver.setupDriver(chromeBrowser);
    }


    @After
    public void quitDriver(){
        Driver.quitDriver();
    }




   // @Before
   // public static void setUp() {
//
   //     HelperClass.setUpDriver();
   // }
//
   // @After
   // public static void tearDown(Scenario scenario) {
//
   //     //validate if scenario has failed
   //     if(scenario.isFailed()) {
   //         final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
   //         scenario.attach(screenshot, "image/png", scenario.getName());
   //     }
//
   //     HelperClass.tearDown();
   // }
}
