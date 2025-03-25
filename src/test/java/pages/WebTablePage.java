package pages;

import loggerUtility.LoggerUtility;
import modelObject.WebTableModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTableLocators;

import java.util.List;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void addNewEntry(WebTableModel testData) {
        int actualSize = testData.getNewTableSize()-1;
        elementHelper.validateSizeList(WebTableLocators.initialTableElementLocator, testData.getNewTableSize()-1);
        LoggerUtility.infoLog("The user validates the size of the current list: " + actualSize);
        elementHelper.clickLocator(WebTableLocators.addElement);
        LoggerUtility.infoLog("The users clicks to the add new row button");
        elementHelper.fillLocator(WebTableLocators.firstNameElement, testData.getFirstnameValue());
        LoggerUtility.infoLog("The users fills the First Name value: " + testData.getFirstnameValue());
        elementHelper.fillLocator(WebTableLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The users fills the Last Name value: " + testData.getLastNameValue());
        elementHelper.fillLocator(WebTableLocators.userEmailElement, testData.getUserEmailValue());
        LoggerUtility.infoLog("The users fills the Email value: " + testData.getUserEmailValue());
        elementHelper.fillLocator(WebTableLocators.ageElement, testData.getAgeValue());
        LoggerUtility.infoLog("The users fills the Age value: " + testData.getAgeValue());
        elementHelper.fillLocator(WebTableLocators.salaryElement, testData.getSalaryValue());
        LoggerUtility.infoLog("The users fills the Salary value: " + testData.getSalaryValue());
        elementHelper.fillLocator(WebTableLocators.departmentElement, testData.getDepartmentValue());
        LoggerUtility.infoLog("The users fills the Department value: " + testData.getDepartmentValue());
        elementHelper.clickLocator(WebTableLocators.submitElement);
        LoggerUtility.infoLog("The users clicks to the Submit button.");
        //validăm că avem 4 rânduri în tabel
        elementHelper.validateSizeList(WebTableLocators.addTableElementLocator, testData.getNewTableSize());
        LoggerUtility.infoLog("The user validates the size of the current list: " +testData.getNewTableSize());
        //validăm conținutul tabelului
        List<WebElement> addTableElementList = driver.findElements(WebTableLocators.addTableElementLocator);
        String rowText = addTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(rowText.contains(testData.getFirstnameValue()));
        LoggerUtility.infoLog("The user validates the presence of First Name in table:" + testData.getFirstnameValue());
        Assert.assertTrue(rowText.contains(testData.getLastNameValue()));
        LoggerUtility.infoLog("The user validates the presence of Last Name in table:" + testData.getLastNameValue());
        Assert.assertTrue(rowText.contains(testData.getUserEmailValue()));
        LoggerUtility.infoLog("The user validates the presence of Email in table." + testData.getUserEmailValue());
        Assert.assertTrue(rowText.contains(testData.getDepartmentValue()));
        LoggerUtility.infoLog("The user validates the presence of Department in table." + testData.getDepartmentValue());
        Assert.assertTrue(rowText.contains(testData.getSalaryValue()));
        LoggerUtility.infoLog("The user validates the presence of Salary in table." + testData.getSalaryValue());
        Assert.assertTrue(rowText.contains(testData.getAgeValue()));
        LoggerUtility.infoLog("The user validates the presence of Age in table." + testData.getAgeValue());
    }


    public void editNewEntry(WebTableModel testData) {
        elementHelper.clickJSLocator(WebTableLocators.editElement);
        LoggerUtility.infoLog("The user clicks to the Edit button.");
        elementHelper.clearAndFillLocator(WebTableLocators.editSalaryElement,testData.getEditSalaryValue());
        LoggerUtility.infoLog("The users edits the Salary value with: " + testData.getEditSalaryValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editDepartmentElement,testData.getEditDepartmentValue());
        LoggerUtility.infoLog("The users edits the Department value with: " + testData.getEditDepartmentValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editAgeElement,testData.getEditAgeValue());
        LoggerUtility.infoLog("The users edits the Age value with: " + testData.getEditAgeValue());
        elementHelper.clickLocator(WebTableLocators.editSubmitElement);
        LoggerUtility.infoLog("The users clicks to the Submit button.");
        //validăm valorile modificate
        elementHelper.validateSizeList(WebTableLocators.editTableElementLocator, testData.getNewTableSize());
        LoggerUtility.infoLog("The user validates the size of the current list: " +testData.getNewTableSize());
        //validăm conținutul tabelului
        List<WebElement> editTableElementList = driver.findElements(WebTableLocators.editTableElementLocator);
        String editRowText = editTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(editRowText.contains(testData.getEditDepartmentValue()));
        Assert.assertTrue(editRowText.contains(testData.getEditSalaryValue()));
        Assert.assertTrue(editRowText.contains(testData.getEditAgeValue()));
    }

    public void deleteNewEntry(WebTableModel testData) {
        elementHelper.clickJSLocator(WebTableLocators.deleteElement);
        LoggerUtility.infoLog("The user clicks to the Delete button.");
        elementHelper.validateSizeList(WebTableLocators.deleteTableElementLocator, testData.getActualTableSize());
        LoggerUtility.infoLog("The user validates the size of the current list: " +testData.getActualTableSize());
    }
}
