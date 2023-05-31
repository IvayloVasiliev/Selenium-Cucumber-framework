package browserConfig;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class Driver {
    public static WebDriver driver;

    private final static String CHROME_DRIVER_PATH = "src\\main\\resources\\chromedriver.exe";
    private final static String FIREFOX_DRIVER_PATH = "src\\main\\resources\\geckodriver.exe";
    private static ThreadLocal<WebDriver> ThreadLocal = new ThreadLocal<>();

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
                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new ChromeDriver(options);
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("There is no such browser!");
        }
    }

    public static WebDriver getDriver() {
        return ThreadLocal.get();
    }

    public static void quitDriver() {
        //  Optional.ofNullable(getDriver()).ifPresent(WebDriver -> {
        // WebDriver.quit();
        driver.quit();
        //   });
    }


    // public Login(WebDriver driver) {
    //     System.setProperties();
    //     this.driver = driver;
    //     // This initElements method will create all WebElements
    //     PageFactory.initElements(driver, this);
    // }


    // Instantiate a ChromeDriver class.
    //WebDriver driver = new ChromeDriver();

    // Maximize the browser
    //    driver.manage().window().maximize();
}
