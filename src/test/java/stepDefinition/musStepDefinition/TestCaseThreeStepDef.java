package stepDefinition.musStepDefinition;

import io.cucumber.java.en.And;
import pages.mus.CareersPage;
import pages.mus.HomePage;

public class TestCaseThreeStepDef {
    private HomePage homePage  = new HomePage();
    private CareersPage careersPage  = new CareersPage();

    @And("I verify {string} section is shown")
    public void iVerifySectionIsShown(String sectionName) {
        careersPage.isSectionShown(sectionName);
    }

    @And("I verify Apply button is present and click on it")
    public void iVerifyApplyButtonIsPresentAndClickOnIt() {
        careersPage.verifyApplyButtonAndClickOnIt();
    }

    @And("I upload CV file")
    public void iUploadCVFile() {
        careersPage.fileUpload();
    }

    @And("I check consent checkbox")
    public void iCheckConsentCheckbox() {
        careersPage.checkCheckbox();
    }
}
