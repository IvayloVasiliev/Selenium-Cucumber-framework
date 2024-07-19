package stepDefinition.strypStepDefinition;

import io.cucumber.java.en.Then;
import pages.stryp.CareersPage;

public class Asserts {

    private CareersPage careersPage = new CareersPage();

    @Then("I verify position description contains {string}")
    public void iVerifyPositionDescriptionContains(String requirment) {
        careersPage.assertRequirmentExistInPage(requirment);
    }

    @Then("I verify position {string} is ready to submit application")
    public void iVerifyPositionIsReadyToSubmitApplication(String position) {
        careersPage.assertPositionIsAplicable(position);
    }
}
