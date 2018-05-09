package flow;

import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pages.StudentsPage;

import static org.testng.Assert.*;

public class StudentsFlow {
    private static StudentsPage page = PageFactory.initElements(
            Browser.getDriver(), StudentsPage.class
    );

    public static void checkWileyPlusLink() {
        assertTrue(page.getWileyPlusLink().isDisplayed());
        assertEquals(page.getWileyPlusLink().getAttribute("href"), "http://wileyplus.wiley.com/");
    }
}
