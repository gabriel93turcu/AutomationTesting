package pages;

import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;
import pageLocators.PracticeFormLocators;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
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

    public void clickOnFormsMenu() {
        elementHelper.clickJSLocator(IndexLocators.formsMenuElement);
    }

    public void clickOnFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormsElement);
    }

    public void clickOnElementsMenu() {
        elementHelper.clickJSLocator(IndexLocators.elementsMenuElement);
    }

    public void clickOnWebTableSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.webTablesElement);
    }


}
