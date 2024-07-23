package pages.stryp;

import helper.BrowserHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static browserConfig.Driver.wait;

public class ChatBotPage extends BasePage {
    private static Logger log = LogManager.getLogger(ChatBotPage.class);
    BrowserHelpers helper = new BrowserHelpers();


    @FindBy(xpath = "//div[@aria-label=\"Write a message\"]")
    public WebElement textbox;

    @FindBy(xpath = "//div[@aria-label=\"Choose an option\"]")
    public WebElement disabledTextbox;

    @FindBy(xpath = "//button[@aria-label=\"send message\"]")
    public WebElement sendButton;

    @FindBy(xpath = "//button[@data-test-id=\"gdpr-consent-agree-button\"]")
    public WebElement chatBotCookieButton;

    @FindBy(xpath = "//button[@aria-label=\"send message\"]")
    public WebElement sendMessageButton;
    @FindBy(xpath = "//input[@data-test-id=\"AttachmentPickerButton-input\"]")
    public WebElement attachFile;

    @FindBy(xpath = "//button[@aria-label=\"attach a file\"]")
    public WebElement attachFileButton;

    @FindBy(xpath = "(//div[starts-with(@aria-label, \"Robby says:\")]/div)[last()]")
    public WebElement actualChatAnswer;


    public void veryfyChatBotAnswer(String chatAnswer) {
        String stringForWait = chatAnswer.substring(chatAnswer.length() - 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + stringForWait + "')]")));
        helper.highlightElement(actualChatAnswer);
        Assert.assertEquals(chatAnswer, actualChatAnswer.getText());
    }

    public void provideMessage(String message) {
        helper.highlightElement(textbox);
        textbox.sendKeys(message);
        sendButton.click();
    }

    public void isMessageFieldDisabled() {
        try{
            disabledTextbox.isDisplayed();
            helper.highlightElement(disabledTextbox);
            log.info("ChatBot Write a message field is disabled!");
        } catch (NoSuchElementException e){
            log.error("ChatBot Write a message field is enabled, but should not be!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void consentCookies() {
        wait.until(ExpectedConditions.visibilityOf(chatBotCookieButton));
        helper.highlightElement(chatBotCookieButton);
        helper.jSEclick(chatBotCookieButton);
        log.info("ChatBot cookies have been accepted");
    }

    public void fileUpload(String fileName) {
        wait.until(ExpectedConditions.visibilityOf(attachFileButton));
        String pathToDocument = helper.getPathToDocument(fileName);
        attachFile.sendKeys(pathToDocument);
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
        helper.highlightElement(sendMessageButton);
        sendMessageButton.click();
        log.info("File " + fileName + " have been uploaded!");
    }
}
