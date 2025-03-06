package pages;

import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void clickOnAlertWindowMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertsMenuElement);
    }

    public void clickOnAlertSubMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertsElement);
    }

    public void clickOnFrameSubMenu() {
        elementHelper.clickJSLocator(IndexLocators.frameElement);
    }

    public void clickOnWindowSubMenu() {
        elementHelper.clickLocator(IndexLocators.browserWindowElement);
    }
}
