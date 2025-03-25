package pages;

import loggerUtility.LoggerUtility;
import modelObject.AlertModel;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void interaptWithAcceptAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user clicks the OK button.");
    }

    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.alertTimerElement);
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user clicks the OK button after the timer has finished.");

    }

    public void  interactWithCancelAlert() {
        elementHelper.clickJSLocator(AlertLocators.alertOkCancelElement);
        alertHelper.cancelAlert();
        LoggerUtility.infoLog("The user clicks the Cancel button.");
    }

    public void interactWithValueAlert(AlertModel testData) {
        elementHelper.clickJSLocator(AlertLocators.alertTextElement);
        alertHelper.fillTextAlert(testData.getPromptData());
        LoggerUtility.infoLog("The user fills and sends the prompt message: "+ testData.getPromptData());
    }
}
