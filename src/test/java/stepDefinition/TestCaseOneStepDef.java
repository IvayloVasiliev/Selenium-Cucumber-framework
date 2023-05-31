package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class TestCaseOneStepDef {

    private HomePage homePage  = new HomePage();

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        homePage.openPage(page);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        homePage.clickOnButton(buttonName);
    }

    @And("I fill {string} field with {string}")
    public void iFillFieldsWith(String labelName, String text) {
            homePage.writeIntoTextBox(labelName, text);
    }

    @Then("I verify that error message {string} appears")
    public void iVerifyThatErrorMessageAppears(String errorMessage) {
            homePage.errorMessageIsVisible(errorMessage);
    }

    @And("I scroll to the needed part of the page")
    public void iScrollToTheNeededPartOfThePage() {
        homePage.scrollTo();
    }

    @And("I click on Send button")
    public void iClickOnSendButton() {
        homePage.clickOnSendButton();
    }

    @And("I click on {string} tab")
    public void iClickOnTab(String tabName) {
        homePage.clickOnTab(tabName);
    }
}
