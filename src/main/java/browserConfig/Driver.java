package browserConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class Driver {
    private static Logger log = LogManager.getLogger(Driver.class);
    public static WebDriver driver;

    private final static String CHROME_DRIVER_PATH = "src\\main\\resources\\chromedriver.exe";
    private final static String FIREFOX_DRIVER_PATH = "src\\main\\resources\\geckodriver.exe";

    public Driver() {

    }


    public static void setupDriver(String browser) {
        switch (browser) {
            case "Chrome":
                System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("start-maximized");
                options.setAcceptInsecureCerts(true);
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                driver = new ChromeDriver(options);
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                log.warn("There is no such browser!");
        }
    }
}
