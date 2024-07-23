package pages.stryp;

import helper.BrowserHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static browserConfig.Driver.driver;
import static browserConfig.Driver.wait;

public class HomePage extends BasePage {
    private static Logger log = LogManager.getLogger(pages.mus.HomePage.class);

    private static final String homePage = "https://strypes.eu/";
    BrowserHelpers helper = new BrowserHelpers();

    @FindBy(id = "welcome-message")
    public WebElement chatBot;

    @FindBy(xpath = "//button[contains(text(),'Accept All')]")
    public WebElement cookies;

    public void openPage(String page) {
        if (page.equals("home")) {
            driver.get(homePage);
            manageCookies();
        } else {
            driver.get(page);
        }
        log.info(page + " page is open");
    }


    public void clickOnButton(String buttonName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + buttonName + "')]")));
        WebElement button = driver.findElement(By.xpath("//*[contains(text(),'" + buttonName + "')]"));
        helper.highlightElement(button);
        button.click();
        log.info(buttonName + " button is clicked!");
    }

    public void manageCookies() {
        driver.manage().getCookies();
        wait.until(ExpectedConditions.visibilityOf(cookies));
        helper.highlightElement(cookies);
        cookies.click();
        log.info("Cookies have been managed!");
    }

    public void openChatBotWindow() {
        driver.switchTo().frame("hubspot-conversations-iframe");
        wait.until(ExpectedConditions.visibilityOf(chatBot));
        helper.highlightElement(chatBot);
        chatBot.click();
        log.info("ChatBot window is open!");
    }
}
