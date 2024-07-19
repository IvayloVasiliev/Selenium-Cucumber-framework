package stepDefinition.strypStepDefinition;

import helper.BrowserHelpers;
import io.cucumber.java.en.And;
import pages.stryp.CareersPage;
import pages.stryp.ChatBotPage;
import pages.stryp.HomePage;

public class Common {

    private HomePage homePage = new HomePage();
    private CareersPage careersPage = new CareersPage();
    private ChatBotPage chatBotPage = new ChatBotPage();
    private BrowserHelpers helper = new BrowserHelpers();

    @And("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        homePage.openPage(page);
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        homePage.clickOnButton(button);
    }

    @And("I get redirected to {string} page")
    public void iGetRedirectedToPage(String page) {
        careersPage.assertThatPageIsOpen(page);
    }

    @And("I switch to the next tab")
    public void iSwitchToTheNextTab() {
        helper.switchTab();
    }

}
