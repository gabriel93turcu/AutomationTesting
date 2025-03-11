package pages;

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

    public void addNewEntry(String firstnameValue, String lastNameValue,
                            String userEmailValue, String ageValue, String salaryValue,
                            String departmentValue, int tableSize) {
        elementHelper.validateSizeList(WebTableLocators.initialTableElementLocator, tableSize-1);
        elementHelper.clickLocator(WebTableLocators.addElement);
        elementHelper.fillLocator(WebTableLocators.firstNameElement, firstnameValue);
        elementHelper.fillLocator(WebTableLocators.lastNameElement, lastNameValue);
        elementHelper.fillLocator(WebTableLocators.userEmailElement, userEmailValue);
        elementHelper.fillLocator(WebTableLocators.ageElement, ageValue);
        elementHelper.fillLocator(WebTableLocators.salaryElement, salaryValue);
        elementHelper.fillLocator(WebTableLocators.departmentElement, departmentValue);
        elementHelper.clickLocator(WebTableLocators.submitElement);
        //validăm că avem 4 rânduri în tabel
        elementHelper.validateSizeList(WebTableLocators.addTableElementLocator, tableSize);
        //validăm conținutul tabelului
        List<WebElement> addTableElementList = driver.findElements(WebTableLocators.addTableElementLocator);
        String rowText = addTableElementList.get(tableSize-1).getText();
        Assert.assertTrue(rowText.contains(firstnameValue));
        Assert.assertTrue(rowText.contains(lastNameValue));
        Assert.assertTrue(rowText.contains(userEmailValue));
        Assert.assertTrue(rowText.contains(departmentValue));
        Assert.assertTrue(rowText.contains(salaryValue));
        Assert.assertTrue(rowText.contains(ageValue));
    }

    public void editNewEntry(String editSalaryValue, String editDepartmentValue, String editAgeValue, int tableSize) {
        elementHelper.clickJSLocator(WebTableLocators.editElement);
        elementHelper.clearAndFillLocator(WebTableLocators.editSalaryElement,editSalaryValue);
        elementHelper.clearAndFillLocator(WebTableLocators.editDepartmentElement,editDepartmentValue);
        elementHelper.clearAndFillLocator(WebTableLocators.editAgeElement,editAgeValue);
        elementHelper.clickLocator(WebTableLocators.editSubmitElement);
        //validăm valorile modificate
        elementHelper.validateSizeList(WebTableLocators.editTableElementLocator, tableSize);
        //validăm conținutul tabelului
        List<WebElement> editTableElementList = driver.findElements(WebTableLocators.editTableElementLocator);
        String editRowText = editTableElementList.get(tableSize-1).getText();
        Assert.assertTrue(editRowText.contains(editDepartmentValue));
        Assert.assertTrue(editRowText.contains(editSalaryValue));
        Assert.assertTrue(editRowText.contains(editAgeValue));
    }

    public void deleteNewEntry(int tableSize) {
        elementHelper.clickJSLocator(WebTableLocators.deleteElement);
        elementHelper.validateSizeList(WebTableLocators.deleteTableElementLocator, tableSize);
    }
}
