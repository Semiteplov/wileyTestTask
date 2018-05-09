package flow;

import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pages.GenericPage;

import static org.testng.Assert.*;

public class GenericFlow {
    private static GenericPage page = PageFactory.initElements(
            Browser.getDriver(), GenericPage.class
    );

    public static void clickOnLogo() {
        GenericPage.clickAndPrintMessage(page.getLogo(), "Logo");
    }

    public static void checkHeader(String header) {
        assertTrue(page.getHeader(header).isDisplayed());
    }
}
