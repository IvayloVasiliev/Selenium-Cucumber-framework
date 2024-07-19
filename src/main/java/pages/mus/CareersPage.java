package pages.mus;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static browserConfig.Driver.driver;

public class CareersPage extends BasePage {

    List<String> positionsInSofia = new ArrayList<>();
    List<String> linksSofia = new ArrayList<>();
    List<String> positionsInSkopje = new ArrayList<>();
    List<String> linksSkopje = new ArrayList<>();

    @FindBy(xpath = "//label[text()= 'Email']/..//preceding-sibling::span/span")
    public WebElement errorMessage;

    @FindBy(css = "//input[@id='adConsentChx']")
    public WebElement checkbox;


    public void errorMessageIsVisible(String message) {
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(message, actualErrorMessage);
    }

    public void clickOnElement(String element) {
       // companyPage.manageCookies();
        WebElement pageElement = driver.findElement(By.xpath("//*[contains(text(),'" + element + "')]"));
        pageElement.click();
    }


    public void selectFromDropdown(String value, String dropdownName) {
        Select dropdown = new Select(driver.findElement(By.xpath("//span[contains(text(),'" + dropdownName + "')]/..//select")));
        dropdown.selectByVisibleText(value);
    }

    public void isSectionShown(String sectionName) {
        WebElement section = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]/..//parent::div"));
        Assert.assertTrue(section.isDisplayed());
    }

    public void verifyApplyButtonAndClickOnIt() {
       WebElement button = driver.findElement(By.cssSelector("input.btn-apply"));
        Assert.assertTrue(button.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void fileUpload() {
        String filePath = "C:\\Users\\ivail\\IdeaProjects\\MusTests\\src\\test\\resources\\uploadFiles\\TestCV.docx";
        driver.findElement(By.id("cf-4")).sendKeys(filePath);
    }

    public void checkCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("input#adConsentChx"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
    }

    public void getAllElements(String location) {
        List<WebElement> elements = driver.findElements(By.xpath("//h2")).stream()
                .filter(WebElement::isDisplayed).collect(Collectors.toList());

        if (location.equals("Sofia")) {
            for (WebElement element : elements) {
                positionsInSofia.add(element.getText());
                linksSofia.add(element.findElement(By.xpath("ancestor::a")).getAttribute("href").toString());
            }
        } else if (location.equals("Skopje")) {
            for (WebElement element : elements) {
                positionsInSkopje.add(element.getText());
                linksSkopje.add(element.findElement(By.xpath("ancestor::a")).getAttribute("href").toString());
            }
        }
    }


    public void printOnConsole() {
        System.out.println("Sofia");
        for (int i = 0; i < positionsInSofia.size(); i++) {
            System.out.println("Position: " + positionsInSofia.get(i));
            System.out.println("More info: " + linksSofia.get(i));
        }
        System.out.println("Skopje");
        for (int i = 0; i < positionsInSkopje.size(); i++) {
            System.out.println("Position: " + positionsInSkopje.get(i));
            System.out.println("More info: " + linksSkopje.get(i));
        }
    }
}