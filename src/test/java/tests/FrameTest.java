package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());
        FrameHelper frameHelper = new FrameHelper(getDriver());

        By framesMenuElement = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(framesMenuElement);

        By frameElement = By.xpath("//span[text()='Frames']");
        elementHelper.clickJSLocator(frameElement);

        frameHelper.switchToIFrame("frame1");

        By textElement = By.id("sampleHeading");
        elementHelper.printLocatorText(textElement);

        frameHelper.switchToParentFrame();

        frameHelper.switchToIFrame("frame2");

        By text2Element = By.id("sampleHeading");
        elementHelper.printLocatorText(text2Element);
    }
}
