package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;
import pageLocators.PracticeFormLocators;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAlertWindowMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertsMenuElement);
        LoggerUtility.infoLog("The user clicks on Alert Window Menu");
    }

    public void clickOnAlertSubMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertsElement);
        LoggerUtility.infoLog("The user clicks on Alert Sub Menu");
    }

    public void clickOnFrameSubMenu() {
        elementHelper.clickJSLocator(IndexLocators.frameElement);
        LoggerUtility.infoLog("The user clicks on Frame Sub Menu");
    }

    public void clickOnWindowSubMenu() {
        elementHelper.clickLocator(IndexLocators.browserWindowElement);
        LoggerUtility.infoLog("The user clicks on Window Sub Menu");
    }

    public void clickOnFormsMenu() {
        elementHelper.clickJSLocator(IndexLocators.formsMenuElement);
        LoggerUtility.infoLog("The user clicks on Forms Menu");
    }

    public void clickOnFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormsElement);
        LoggerUtility.infoLog("The user clicks on Form Sub Menu");
    }

    public void clickOnElementsMenu() {
        elementHelper.clickJSLocator(IndexLocators.elementsMenuElement);
        LoggerUtility.infoLog("The user clicks on Elements Menu");
    }

    public void clickOnWebTableSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.webTablesElement);
        LoggerUtility.infoLog("The user clicks on Table Sub Menu");
    }
}
