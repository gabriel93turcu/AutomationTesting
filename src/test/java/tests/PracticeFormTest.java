package tests;

import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        PracticeFormModel testData = new PracticeFormModel("src/test/resources/testData/PracticeFormData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();


        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(testData);

        practiceFormPage.validateEntireContent(testData);


        //Temă: automatizare 2-3 scenarii de aici: https://practice.automationtesting.in/test-cases/


        //Temă: Proiect nou -> de completat formularul de aici: https://www.automationtesting.co.uk/contactForm.html
        //Temă: În același proiect -> 3 - 4 operații cu calculatorul de aici: https://www.automationtesting.co.uk/calculator.html
    }
}
