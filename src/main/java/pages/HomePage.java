package pages;

import helper.BrowserHelpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static browserConfig.Driver.driver;

public class HomePage extends BasePage {

    private static final String homePage = "http://www.musala.com/";
    BrowserHelpers helper = new BrowserHelpers();

    @FindBy(xpath = "//span[contains(text(),'Contact us')]")
    public WebElement contactUsButton;

    @FindBy(xpath = "//label[text()= 'Email']/..//preceding-sibling::span/span")
    public WebElement errorMessage;

    @FindBy(css = ".wpcf7-form-control.has-spinner.wpcf7-submit.btn-cf-submit")
    public WebElement sendButton;

    @FindBy(xpath = "//*[@id='wt-cli-accept-all-btn'] | (//span[contains(text(),'Allow all cookies')])[2]")
    public WebElement cookies;

    public void openPage(String page) {
        if (page.equals("home")) {
            driver.get(homePage);
            manageCookies();
        } else {
            driver.get(page);
        }
    }

    public void scrollTo() {
        WebElement element = driver.findElement(By.xpath("//div[@class=\"links-buttons\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickOnButton(String buttonName) {
        WebElement button = driver.findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]"));
        button.click();
    }

    public void clickOnSendButton() {
        //sendButton.click();
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
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
    }

    public void assertThatPageIsOpenAndURLIsShown(String pageName) {
        String actualUrlAsString = driver.getCurrentUrl();

        String urlAdress = switch (pageName) {
            case "Company" -> "https://www.musala.com/company/";
            case "Facebook" -> "https://www.facebook.com/MusalaSoft?fref=ts";
            case "Careers" -> "https://www.musala.com/careers/";
            case "Join us" -> "https://www.musala.com/careers/join-us/";
            default -> "There is no such URL defined!";
        };
        Assert.assertEquals(urlAdress, actualUrlAsString);

    }

    public void manageCookies() {
        driver.manage().getCookies();
        cookies.click();
    }

}