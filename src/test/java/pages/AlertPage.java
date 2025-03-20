package pages;

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
    }

    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.alertTimerElement);
        alertHelper.acceptAlert();
    }

    public void  interactWithCancelAlert() {
        elementHelper.clickJSLocator(AlertLocators.alertOkCancelElement);
        alertHelper.cancelAlert();
    }

    public void interactWithValueAlert(AlertModel testData) {
        elementHelper.clickJSLocator(AlertLocators.alertTextElement);
        alertHelper.fillTextAlert(testData.getPromptData());
    }
}
