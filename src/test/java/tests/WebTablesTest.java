package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());

        By elementsMenuElement = By.xpath("//h5[text()='Elements']");
        elementHelper.clickJSLocator(elementsMenuElement);

        By webTablesElement = By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJSLocator(webTablesElement);

        //identificăm o listă de elemente
        By initialTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        int expectedTableSize = 3;
        elementHelper.validateSizeList(initialTableElementLocator, expectedTableSize);

        //identificăm un element
        By addElement = By.id("addNewRecordButton");
        elementHelper.clickLocator(addElement);

        By firstNameElement = By.id("firstName");
        String firstnameValue = "Gabriel";
        elementHelper.fillLocator(firstNameElement, firstnameValue);

        By lastNameElement = By.id("lastName");
        String lastNameValue = "Turcu";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By userEmailElement = By.id("userEmail");
        String userEmailValue = "g.t@test123.com";
        elementHelper.fillLocator(userEmailElement, userEmailValue);

        By ageElement = By.id("age");
        String ageValue = "20";
        elementHelper.fillLocator(ageElement, ageValue);

        By salaryElement = By.id("salary");
        String salaryValue = "20000";
        elementHelper.fillLocator(salaryElement, salaryValue);

        By departmentElement = By.id("department");
        String departmentValue = "QA";
        elementHelper.fillLocator(departmentElement,departmentValue);

        By submitElement = By.id("submit");
        elementHelper.clickLocator(submitElement);

        //validăm că avem 4 rânduri în tabel
        By addTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        elementHelper.validateSizeList(addTableElementLocator, 4);

        //validăm conținutul tabelului
        List<WebElement> addTableElementList = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        String rowText = addTableElementList.get(3).getText();
        Assert.assertTrue(rowText.contains(firstnameValue));
        Assert.assertTrue(rowText.contains(lastNameValue));
        Assert.assertTrue(rowText.contains(userEmailValue));
        Assert.assertTrue(rowText.contains(departmentValue));
        Assert.assertTrue(rowText.contains(salaryValue));
        Assert.assertTrue(rowText.contains(ageValue));


        //Edit Functionality
        By editElement = By.id("edit-record-4");
        elementHelper.clickJSLocator(editElement);

        By editSalaryElement = By.id("salary");
        String editSalaryValue = "30000";
        elementHelper.clearAndFillLocator(editSalaryElement,editSalaryValue);

        By editDepartmentElement = By.id("department");
        String editDepartmentValue = "Team lead QA";
        elementHelper.clearAndFillLocator(editDepartmentElement,editDepartmentValue);

        By editAgeElement = By.id("age");
        String editAgeValue = "23";
        elementHelper.clearAndFillLocator(editAgeElement,editAgeValue);

        By editSubmitElement = By.id("submit");
        elementHelper.clickLocator(editSubmitElement);

        //validăm valorile modificate
        By editTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        elementHelper.validateSizeList(editTableElementLocator, 4);

        //validăm conținutul tabelului
        List<WebElement> editTableElementList = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        String editRowText = editTableElementList.get(3).getText();
        Assert.assertTrue(editRowText.contains(editDepartmentValue));
        Assert.assertTrue(editRowText.contains(editSalaryValue));
        Assert.assertTrue(editRowText.contains(editAgeValue));

        //delete
        By deleteElement = By.id("delete-record-4");
        elementHelper.clickJSLocator(deleteElement);

        By deleteTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        elementHelper.validateSizeList(deleteTableElementLocator, 3);


        //await Selenium - așteaptă până la 10s, dar dacă nu sunt necesare 10s, testul trece mai departe
    }
}
