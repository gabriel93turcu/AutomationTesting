package pages;

import modelObject.PracticeFormModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.PracticeFormLocators;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void populateEntireForm(PracticeFormModel testData) {
        elementHelper.fillLocator(PracticeFormLocators.firstNameElement, testData.getFirstNameValue());

        elementHelper.fillLocator(PracticeFormLocators.lastNameElement, testData.getLastNameValue());

        elementHelper.fillLocator(PracticeFormLocators.emailElement, testData.getEmailValue());

        List<WebElement> genderElement = elementHelper.getListElements(PracticeFormLocators.genderLocator);
        switch (testData.getGenderValue()) {
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

        elementHelper.fillLocator(PracticeFormLocators.mobileElement, testData.getMobileValue());

        for (String subject : testData.getSubjectValues()) {
            elementHelper.fillPressLocator(PracticeFormLocators.subjectElement, subject, Keys.ENTER);
        }

        List<WebElement> hobbiesElement = elementHelper.getListElements(PracticeFormLocators.hobbiesLocator);
        for (WebElement hobby : hobbiesElement) {
            if (testData.getHobbiesValues().contains(hobby.getText())) {
                elementHelper.clickJSLocator(hobby);
            }
        }

        File file = new File(testData.getPictureValue());
        elementHelper.fillLocator(PracticeFormLocators.pictureElement, file.getAbsolutePath());

        elementHelper.fillLocator(PracticeFormLocators.addressElement, testData.getAddressValue());

        elementHelper.clickJSLocator(PracticeFormLocators.stateElement);

        elementHelper.fillPressLocator(PracticeFormLocators.stateInputElement, testData.getStateValue(), Keys.ENTER);

        elementHelper.clickJSLocator(PracticeFormLocators.cityElement);

        elementHelper.fillPressLocator(PracticeFormLocators.cityInputElement, testData.getCityValue(), Keys.ENTER);

        elementHelper.clickJSLocator(PracticeFormLocators.submitElement);
    }

    public void validateEntireContent(PracticeFormModel testData) {
        elementHelper.validateElementText(PracticeFormLocators.thankYouElement, testData.getExpectedMessage());

        List<WebElement> tableContentList = elementHelper.getListElements(PracticeFormLocators.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), testData.getFirstNameValue() + ' ' + testData.getLastNameValue());

        elementHelper.validateElementContainsText(tableContentList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), testData.getEmailValue());

        elementHelper.validateElementContainsText(tableContentList.get(2), "Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), testData.getGenderValue());

        elementHelper.validateElementContainsText(tableContentList.get(3), "Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), testData.getMobileValue());

        elementHelper.validateElementContainsText(tableContentList.get(5), "Subjects");
        String subjectValue = String.join(", ", testData.getSubjectValues());
        elementHelper.validateElementContainsText(tableContentList.get(5), subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6), "Hobbies");
        String hobbyValue = String.join(", ", testData.getHobbiesValues());
        elementHelper.validateElementContainsText(tableContentList.get(6), hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7), "Picture");
        File file = new File(testData.getPictureValue());
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        elementHelper.validateElementContainsText(tableContentList.get(8), testData.getAddressValue());

        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), testData.getStateValue() + ' ' + testData.getCityValue());
    }
}
