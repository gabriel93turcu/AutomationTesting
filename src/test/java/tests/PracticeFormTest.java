package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();

        String firstNameValue = "Gabriel";
        String lastNameValue = "Turcu";
        String emailValue = "t.g@test.ro";
        String genderValue = "Male";
        String mobileValue = "0740123456";
        List<String> subjectValues = Arrays.asList("Arts", "Accounting", "Maths");
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading");
        String pictureValue = "src/test/resources/Screenshot.png";
        String addressValue = "Avram Iancu";
        String stateValue = "NCR";
        String cityValue = "Noida";
        String expectedMessage = "Thanks for submitting the form";


        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(firstNameValue,lastNameValue,emailValue,
                genderValue,mobileValue,subjectValues,hobbiesValues,
                pictureValue,addressValue,stateValue,cityValue);

        practiceFormPage.validateEntireContent(expectedMessage,firstNameValue,lastNameValue,
        emailValue,genderValue,mobileValue,subjectValues,hobbiesValues,pictureValue,
                addressValue,stateValue,cityValue);


        //Temă: automatizare 2-3 scenarii de aici: https://practice.automationtesting.in/test-cases/


        //Temă: Proiect nou -> de completat formularul de aici: https://www.automationtesting.co.uk/contactForm.html
        //Temă: În același proiect -> 3 - 4 operații cu calculatorul de aici: https://www.automationtesting.co.uk/calculator.html
    }
}
