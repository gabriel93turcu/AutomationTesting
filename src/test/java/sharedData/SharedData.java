package sharedData;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment() {
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
    }

    public WebDriver getDriver() {
        return driver;
    }
}

