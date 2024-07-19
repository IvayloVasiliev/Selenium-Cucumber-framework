package pages.stryp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import pages.BasePage;

import java.time.Duration;

import static browserConfig.Driver.driver;
import static browserConfig.Driver.wait;

public class ChatBotPage extends BasePage {


    @FindBy(xpath = "//div[@aria-label=\"Write a message\"]")
    public WebElement textbox;

    @FindBy(xpath = "//button[@aria-label=\"send message\"]")
    public WebElement sendButton;


    public void veryfyChatBotAnswer(String chatAnswer) {
        String stringForWait = chatAnswer.substring(chatAnswer.length() - 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + stringForWait + "')]")));
        WebElement actualChatAnswer = driver.findElement(By.xpath("(//div[starts-with(@aria-label, \"Robby says:\")]/div)[last()]"));
        Assert.assertEquals(chatAnswer, actualChatAnswer.getText());
    }

    public void provideMessage(String message) {
        highlightElement(textbox);

        textbox.sendKeys(message);
        sendButton.click();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background: lightGreen; border: 3px solid red;');", element);
        jse.executeScript("arguments[0].value = '';", element);
    }

}
