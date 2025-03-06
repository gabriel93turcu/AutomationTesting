package tests;

import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnAlertSubMenu();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interaptWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithValueAlert("Gabriel");
    }
}
