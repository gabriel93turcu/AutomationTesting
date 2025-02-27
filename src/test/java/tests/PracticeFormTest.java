package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());

        By formsMenuElement = By.xpath("//h5[text()='Forms']");
        elementHelper.clickJSLocator(formsMenuElement);

        By practiceFormsElement = By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJSLocator(practiceFormsElement);

        By firstNameElement = By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = "Gabriel";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue = "Turcu";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By emailElement = By.xpath("//input[@placeholder='name@example.com']");
        String emailValue = "t.g@test.ro";
        elementHelper.fillLocator(emailElement, emailValue);

        String genderValue = "Male";
        By genderLocator = By.xpath("//label[contains(@for,'gender-radio')]");
        List<WebElement> genderElement = elementHelper.getListElements(genderLocator);
        switch (genderValue) {
            case "Male":
                elementHelper.clickJSLocator(genderElement.get(0));
                break;
            case "Female":
                elementHelper.clickJSLocator(genderElement.get(1));
                break;
            case "Other":
                elementHelper.clickJSLocator(genderElement.get(3));
                break;
            default:
                System.out.println("Nu există alte valori");
                break;
        }

        By mobileElement = By.xpath("//input[@placeholder='Mobile Number']");
        String mobileValue = "0740123456";
        elementHelper.fillLocator(mobileElement,mobileValue);

        By subjectElement = By.id("subjectsInput");
        List<String> subjectValues = Arrays.asList("Arts", "Accounting", "Maths");
        for (String subject : subjectValues) {
          elementHelper.fillPressLocator(subjectElement,subject,Keys.ENTER);
        }

        By hobbiesLocator = By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']");
        List<WebElement> hobbiesElement = elementHelper.getListElements(hobbiesLocator);
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading");
        for (WebElement hobby : hobbiesElement) {
            if (hobbiesValues.contains(hobby.getText())) {
                elementHelper.clickJSLocator(hobby);
            }
        }

        By pictureElement = By.cssSelector("input[type='file']");
        String pictureValue = "src/test/resources/Screenshot.png";
        File file = new File(pictureValue);
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        By addressElement = By.cssSelector("#currentAddress");
        String addressValue = "Avram Iancu";
        elementHelper.fillLocator(addressElement,addressValue);

        By stateElement = By.xpath("//div[text()='Select State']");
        elementHelper.clickJSLocator(stateElement);

        By stateInputElement = By.cssSelector("#react-select-3-input");
        String stateValue = "NCR";
        elementHelper.fillPressLocator(stateInputElement,stateValue,Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJSLocator(cityElement);

        By cityInputElement = By.cssSelector("#react-select-4-input");
        String cityValue = "Noida";
        elementHelper.fillPressLocator(cityInputElement,cityValue,Keys.ENTER);

        By submitElement = By.cssSelector("#submit");
        elementHelper.clickJSLocator(submitElement);

        By thankYouElement = By.cssSelector("#example-modal-sizes-title-lg");
        String expectedMessage = "Thanks for submitting the form";
        elementHelper.validateElementText(thankYouElement,expectedMessage);

        By tableContentListLocator = By.cssSelector(".table.table-dark>tbody>tr");
        List<WebElement> tableContentList = elementHelper.getListElements(tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0),firstNameValue + ' ' + lastNameValue);

        elementHelper.validateElementContainsText(tableContentList.get(1),"Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1),emailValue);

        elementHelper.validateElementContainsText(tableContentList.get(2),"Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2),genderValue);

        elementHelper.validateElementContainsText(tableContentList.get(3),"Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3),mobileValue);

        elementHelper.validateElementContainsText(tableContentList.get(5),"Subjects");
        String subjectValue = String.join(", ", subjectValues);
        elementHelper.validateElementContainsText(tableContentList.get(5),subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6),"Hobbies");
        String hobbyValue = String.join(", ", hobbiesValues);
        elementHelper.validateElementContainsText(tableContentList.get(6),hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7),"Picture");
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7),fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8),"Address");
        elementHelper.validateElementContainsText(tableContentList.get(8),addressValue);

        elementHelper.validateElementContainsText(tableContentList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9),stateValue + ' ' + cityValue);


        //Temă: automatizare 2-3 scenarii de aici: https://practice.automationtesting.in/test-cases/


        //Temă: Proiect nou -> de completat formularul de aici: https://www.automationtesting.co.uk/contactForm.html
        //Temă: În același proiect -> 3 - 4 operații cu calculatorul de aici: https://www.automationtesting.co.uk/calculator.html
    }
}
