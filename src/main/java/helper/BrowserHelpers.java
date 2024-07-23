package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;

import static browserConfig.Driver.driver;

public class BrowserHelpers {
    private String filePath = "src\\test\\resources\\uploadFiles\\";

    public void highlightElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background: lightGreen; border: 3px solid red;');", element);
        jse.executeScript("arguments[0].value = '';", element);
    }

    public void jSEclick(WebElement button) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: lightGreen; border: 3px solid red;');", button);
        jsExecutor.executeScript("arguments[0].value = '';", button);
        jsExecutor.executeScript("arguments[0].click();", button);
    }

    public void switchTab() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String getPathToDocument(String fileName) {
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        String pathToDocument = absolutePath.concat("\\" + fileName);
        return pathToDocument;
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
