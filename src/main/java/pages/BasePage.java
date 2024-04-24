package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static browserConfig.Driver.driver;

public abstract class  BasePage {
    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public boolean validateElement(By by){
        return !findElements(by).isEmpty();
    }
}
