package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CareersPage;

public class TestCaseFourStepDef {

    private CareersPage careersPage  = new CareersPage();

    @And("I get all position in {string} available on the page")
    public void iGetAllPositionInAvailableOnThePage(String location) {
        careersPage.getAllElements(location);
    }

    @Then("I print positions on console")
    public void iPrintPositionsOnConsole() {
        careersPage.printOnConsole();
    }
}
