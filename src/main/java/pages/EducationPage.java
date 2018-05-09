package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EducationPage extends GenericPage {
    private static final String LOCATOR_FOR_SIDE_PANEL_ITEMS = "//div[@class='side-panel']/ul/li/a[text()='%s']";

    public WebElement getSidePanelItem(String item) {
        String locator = String.format(LOCATOR_FOR_SIDE_PANEL_ITEMS, item);
        return Browser.getDriver().findElement(By.xpath(locator));
    }
}
