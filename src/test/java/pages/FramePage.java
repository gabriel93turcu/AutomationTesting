package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void interactWithFirstIFrame() {
        frameHelper.switchToIFrame("frame1");
        LoggerUtility.infoLog("The user goes to the new frame.");
        elementHelper.printLocatorText(FrameLocators.textElement);
        LoggerUtility.infoLog("The user takes the text displayed on the new frame.");
        frameHelper.switchToParentFrame();
        LoggerUtility.infoLog("The user goes to the parent frame.");
    }

    public void interactWithSecondIFrame() {
        frameHelper.switchToIFrame("frame2");
        LoggerUtility.infoLog("The user goes to the new frame.");
        elementHelper.printLocatorText(FrameLocators.text2Element);
        LoggerUtility.infoLog("The user takes the text from the second frame.");
    }

}
