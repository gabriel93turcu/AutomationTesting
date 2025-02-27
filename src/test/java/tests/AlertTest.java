package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {

        AlertHelper alertHelper = new AlertHelper(getDriver());
        ElementHelper elementHelper = new ElementHelper(getDriver());

        By alertsMenuElement = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertsMenuElement);

        By alertsElement = By.xpath("//span[text()='Alerts']");
        elementHelper.clickJSLocator(alertsElement);

        By alertOkElement = By.id("alertButton");
        elementHelper.clickLocator(alertOkElement);

        alertHelper.acceptAlert();

        By alertTimerElement = By.id("timerAlertButton");
        elementHelper.clickLocator(alertTimerElement);

        alertHelper.acceptAlert();

        By alertOkCancelElement = By.id("confirmButton");
        elementHelper.clickLocator(alertOkCancelElement);

        alertHelper.cancelAlert();

        By alertTextElement = By.id("promtButton");
        elementHelper.clickLocator(alertTextElement);

        alertHelper.fillTextAlert("Gabriel");
    }
}
