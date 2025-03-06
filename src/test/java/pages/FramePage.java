package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;
import pageLocators.IndexLocators;

public class FramePage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private FrameHelper frameHelper;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        frameHelper = new FrameHelper(driver);
    }

    public void interactWithFirstIFrame() {
        frameHelper.switchToIFrame("frame1");
        elementHelper.printLocatorText(FrameLocators.textElement);
        frameHelper.switchToParentFrame();
    }

    public void interactWithSecondIFrame() {
        frameHelper.switchToIFrame("frame2");
        elementHelper.printLocatorText(FrameLocators.text2Element);
    }

}
