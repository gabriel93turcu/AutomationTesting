package pages;

import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
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
