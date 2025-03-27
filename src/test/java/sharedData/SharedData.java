package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;
    private String testName;

    @BeforeMethod (alwaysRun = true)
    public void prepareEnvironment() {
        //găsim numele clasei
        testName = this.getClass().getSimpleName();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        //deschidem un browser
        driver = new EdgeDriver(options);

        //Accesăm o pagină web
        driver.get("https://demoqa.com/");

        //Facem browserul în mod maximizare
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.startTest(testName);
    }

    @AfterMethod (alwaysRun = true)
    public void clearEnvironment() {
        driver.quit();
        LoggerUtility.finishTest(testName);
    }


    public WebDriver getDriver() {
        return driver;
    }
}

