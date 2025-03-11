package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTableLocators {

    public static final By initialTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
    public static final By addElement = By.id("addNewRecordButton");
    public static final By firstNameElement = By.id("firstName");
    public static final By lastNameElement = By.id("lastName");
    public static final By userEmailElement = By.id("userEmail");
    public static final By ageElement = By.id("age");
    public static final By salaryElement = By.id("salary");
    public static final By departmentElement = By.id("department");
    public static final By submitElement = By.id("submit");
    public static final By addTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
    public static final By editElement = By.id("edit-record-4");
    public static final By editSalaryElement = By.id("salary");
    public static final By editDepartmentElement = By.id("department");
    public static final By editAgeElement = By.id("age");
    public static final By editSubmitElement = By.id("submit");
    public static final By editTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
    public static final By deleteElement = By.id("delete-record-4");
    public static final By deleteTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
}
