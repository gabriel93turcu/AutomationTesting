package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabHelper {

    private WebDriver driver;

    public TabHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        System.out.println("Url-ul curent este: " + driver.getCurrentUrl());
    }

    public void closeCurrntTab() {
        driver.close();
    }
}
