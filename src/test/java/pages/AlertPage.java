package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
    }

    public void interaptWithAcceptAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
    }

    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.alertTimerElement);
        alertHelper.acceptAlert();
    }

    public void  interactWithCancelAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkCancelElement);
        alertHelper.cancelAlert();
    }

    public void interactWithValueAlert(String value) {
        elementHelper.clickLocator(AlertLocators.alertTextElement);
        alertHelper.fillTextAlert(value);
    }
}
