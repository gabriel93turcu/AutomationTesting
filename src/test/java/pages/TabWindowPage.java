package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.TabWindowLocators;

public class TabWindowPage extends BasePage {

    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithTab() {
        elementHelper.clickLocator(TabWindowLocators.newTabElement);
        System.out.println("Url-ul curent este: " + driver.getCurrentUrl());
        LoggerUtility.infoLog("The user prints the current url.");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user goes to the second tab.");
        tabHelper.closeCurrntTab();
        LoggerUtility.infoLog("The user closes the current tab.");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user goes to the previous tab.");
    }

    public void interactWithWindow() {
        elementHelper.clickLocator(TabWindowLocators.newWindowElement);
        System.out.println("Url-ul curent este: " + driver.getCurrentUrl());
        LoggerUtility.infoLog("The user prints the current url.");
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user goes to the second window.");
        tabHelper.closeCurrntTab();
        LoggerUtility.infoLog("The user closes the current window.");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user goes to the previous window.");
    }

}
