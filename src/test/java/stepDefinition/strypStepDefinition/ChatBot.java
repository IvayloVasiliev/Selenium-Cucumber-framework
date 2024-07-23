package stepDefinition.strypStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.stryp.ChatBotPage;
import pages.stryp.HomePage;

import static browserConfig.Driver.driver;


public class ChatBot {

    private HomePage homePage = new HomePage();
    private ChatBotPage chatBotPage = new ChatBotPage();

    @And("I open the ChatBot dialog window")
    public void iOpenTheChatBotDialogWindow() {
        homePage.openChatBotWindow();
    }

    @Then("I verify the ChatBot answer equals {string}")
    public void iVerifyTheChatBotAnswerEquals(String chatAnswer) {
        chatBotPage.veryfyChatBotAnswer(chatAnswer);
    }

    @And("I provide {string} message in Chat field")
    public void iProvideMessageInChatField(String message) {
        chatBotPage.provideMessage(message);
    }

    @And("I check if message field is disabled for writing text")
    public void iCheckIfMessageFieldIsDisabledForWritingText() {
        chatBotPage.isMessageFieldDisabled();
    }

    @And("I consent ChatBot cookies")
    public void iConsentChatBotCookies() {
        chatBotPage.consentCookies();
    }
}
