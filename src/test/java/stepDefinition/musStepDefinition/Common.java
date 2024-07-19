package stepDefinition.musStepDefinition;

import helper.BrowserHelpers;
import io.cucumber.java.en.And;
import pages.mus.CareersPage;
import pages.mus.HomePage;

public class Common {

    private HomePage homePage  = new HomePage();
    private CareersPage careersPage  = new CareersPage();
    private BrowserHelpers helper = new BrowserHelpers();


    @And("I am redirected to {string} page")
    public void iAmRedirectedToPage(String pageName) {
        homePage.assertThatPageIsOpenAndURLIsShown(pageName);
    }

    @And("I select {string} from {string} dropdown")
    public void iSelectFromDropdown(String value, String dropdownName) {
       careersPage.selectFromDropdown(value, dropdownName);
    }

    @And("I click on {string} element")
    public void iClickOnElement(String element) {
        careersPage.clickOnElement(element);
    }

    @And("I switch tab")
    public void iSwitchTab() {
        helper.switchTab();
    }
}
