package pages.mus;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CompanyPage extends BasePage {

    private HomePage homePage  = new HomePage();

    @FindBy(xpath = "//h2[contains(text(),'Leadership')]")
    public WebElement leadershipSection;

    @FindBy(xpath = "//span[@class='musala musala-icon-facebook']")
    public WebElement linkIcon;

    @FindBy(xpath = "(//i[@class=\"x1b0d499 x1d69dk1\"])[5]")
    public WebElement closeIcon;

    @FindBy(xpath = "//a[@href=\"https://www.facebook.com/photo/?fbid=769589221239603&set=a.769589147906277&__tn__=%3C\"]")
    public WebElement profilePic;

    public void leadershipSectionIsShown() {
        Assert.assertTrue(leadershipSection.isDisplayed());
    }

    public void clickLinkIcon() {
        homePage.scrollTo();
        linkIcon.click();
    }

    public void verifyPictureAppears() {
        homePage.manageCookies();
        closeIcon.click();
        String label = profilePic.getAttribute("aria-label");
        Assert.assertEquals("Musala Soft", label);
    }
}