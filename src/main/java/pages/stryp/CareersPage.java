package pages.stryp;

import helper.BrowserHelpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static browserConfig.Driver.driver;
import static browserConfig.Driver.wait;

public class CareersPage extends BasePage {


    public void assertThatPageIsOpen(String pageName) {
        String urlAsString = driver.getCurrentUrl();
        Assert.assertTrue(urlAsString.contains(pageName));
    }


    public void assertRequirmentExistInPage(String requirment) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'" + requirment + "')]")));
        WebElement actualErrorMessage = driver.findElement(By.xpath("//*[contains(text(),'" + requirment + "')]"));
        Assert.assertEquals(requirment, actualErrorMessage.getText());
    }

    public void assertPositionIsAplicable(String position) {
        WebElement actualErrorMessage = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(position, actualErrorMessage.getText());
    }
}
