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

    @FindBy(xpath = "//button[@class = 'IconLauncher__BaseLauncher-sc-1u5v5uh-0 IconLauncher__ShapedLauncher-sc-1u5v5uh-1 dlepJf reagan--widget-loaded']")
    public WebElement chatBot;

    @FindBy(id = "welcome-message")
    public WebElement chatBot1;

    @FindBy(xpath = "//div[@class=\"links-buttons\"]")
    public WebElement linksButtons;

    @FindBy(css = ".wpcf7-form-control.has-spinner.wpcf7-submit.btn-cf-submit")
    public WebElement sendButton;

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

    public void scrollTo() {
        //WebElement element = driver.findElement(By.xpath("//div[@class=\"links-buttons\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", linksButtons);
    }

    public void clickOnButton(String buttonName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + buttonName + "')]")));
        WebElement button = driver.findElement(By.xpath("//*[contains(text(),'" + buttonName + "')]"));
        button.click();
        log.info(buttonName + " button is clicked!");
    }

    public void clickOnSendButton() {
        helper.jSEclick(sendButton);
    }

    public void writeIntoTextBox(String labelName, String text) {
        WebElement textbox = driver.findElement(By.xpath("//label[text()= '" + labelName + "']/..//preceding-sibling::span/input | //label[text()= '" + labelName + "']/..//preceding-sibling::span/textarea"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String style = textbox.getAttribute("style");
        jse.executeScript("arguments[0].setAttribute('style', 'background: lightGreen; border: 3px solid red;');", textbox);
        jse.executeScript("arguments[0].value = '';", textbox);

        textbox.sendKeys(text);
    }

    public void errorMessageIsVisible(String message) {
        WebElement actualErrorMessage = driver.findElement(By.xpath("//span[text()= '" + message + "']"));;
        Assert.assertEquals(message, actualErrorMessage.getText());
    }

    public void clickOnTab(String tabName) {
        WebElement tab = driver.findElement(By.xpath("//div[@id=\"navbar\"]//a[contains(text(),'" + tabName + "')]"));
        tab.click();
        log.info(tabName + " tab is clicked!");
    }


    public void manageCookies() {
        driver.manage().getCookies();
        wait.until(ExpectedConditions.visibilityOf(cookies));
        cookies.click();
        log.info("Cookies have been managed!");
    }

    public void openChatBotWindow() {
        driver.switchTo().frame("hubspot-conversations-iframe");
        wait.until(ExpectedConditions.visibilityOf(chatBot1));
        chatBot1.click();
        log.info("ChatBot window is open!");
    }
}
