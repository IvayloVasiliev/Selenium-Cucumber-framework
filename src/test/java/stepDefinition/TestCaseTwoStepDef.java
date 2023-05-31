package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CompanyPage;

public class TestCaseTwoStepDef {

    private CompanyPage companyPage  = new CompanyPage();

    @And("I verify that there is Leadership section")
    public void iVerifyThatThereIsLeadershipSection() {
        companyPage.leadershipSectionIsShown();
    }

    @When("I click on Facebook icon")
    public void iClickOnFacebookIcon() {
        companyPage.clickLinkIcon();

    }

    @Then("I verify that Musala Soft profile picture appears")
    public void iVerifyThatMusalaSoftProfilePictureAppears() {
        companyPage.verifyPictureAppears();
    }
}
