package pages;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;
import pageLocators.TabWindowLocators;

public class TabWindowPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private TabHelper tabHelper;

    public TabWindowPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        tabHelper = new TabHelper(driver);
    }

    public void interactWithTab() {
        elementHelper.clickLocator(TabWindowLocators.newTabElement);
        System.out.println("Url-ul curent este: " + driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrntTab();
        tabHelper.switchToSpecificTab(0);
    }

    public void interactWithWindow() {
        elementHelper.clickLocator(TabWindowLocators.newWindowElement);
        System.out.println("Url-ul curent este: " + driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrntTab();
        tabHelper.switchToSpecificTab(0);
    }

}
