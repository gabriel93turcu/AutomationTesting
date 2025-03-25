package tests;

import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;
import suites.TestCaseSuite;
import suites.TestSuite;

public class AlertTest extends SharedData {

    @Test (groups = {TestSuite.REGRESSION_SUITE, TestSuite.ALERT_FRAME_SUITE,
            TestCaseSuite.TICKET_123,TestCaseSuite.TC_457, TestCaseSuite.TC_459})
    public void metodaTest() {

        AlertModel testData = new AlertModel("src/test/resources/testData/AlertData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnAlertSubMenu();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interaptWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithValueAlert(testData);
    }
}
