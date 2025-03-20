package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;
    private String testName;

    @BeforeMethod
    public void prepareEnvironment() {
        //găsim numele clasei
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTest(testName);

        //deschidem un browser
        driver = new EdgeDriver();

        //Accesăm o pagină web
        driver.get("https://demoqa.com/");

        //Facem browserul în mod maximizare
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void clearEnvironment() {
        driver.quit();
        LoggerUtility.finishTest(testName);
    }


    public WebDriver getDriver() {
        return driver;
    }
}

