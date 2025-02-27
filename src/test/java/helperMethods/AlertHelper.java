package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlert();
        Alert alertOk = driver.switchTo().alert();
        System.out.println(alertOk.getText());
        alertOk.accept();
    }

    public void cancelAlert() {
        waitForAlert();
        Alert alertOkCancel = driver.switchTo().alert();
        System.out.println(alertOkCancel.getText());
        alertOkCancel.dismiss();
    }

    public void fillTextAlert(String text) {
        waitForAlert();
        Alert alertText = driver.switchTo().alert(); // focus pe alertă
        System.out.println(alertText.getText()); // iei textul din alertă
        alertText.sendKeys(text); // inserezi valoarea în alertă
        alertText.accept(); // confirmi alerta
    }
}
