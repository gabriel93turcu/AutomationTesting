package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnElementsMenu();
        indexPage.clickOnWebTableSubMenu();

        // add
        String firstnameValue = "Gabriel";
        String lastNameValue = "Turcu";
        String userEmailValue = "g.t@test123.com";
        String ageValue = "20";
        String salaryValue = "20000";
        String departmentValue = "QA";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addNewEntry(firstnameValue, lastNameValue,userEmailValue,ageValue,salaryValue,departmentValue,4);


        //edit
        String editSalaryValue = "30000";
        String editDepartmentValue = "Team lead QA";
        String editAgeValue = "23";
        webTablePage.editNewEntry(editSalaryValue,editDepartmentValue,editAgeValue,4);

        //delete
        webTablePage.deleteNewEntry(3);
    }
}
