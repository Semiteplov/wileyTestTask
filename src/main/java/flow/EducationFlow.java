package flow;

import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pages.EducationPage;

import static org.testng.Assert.*;

public class EducationFlow extends GenericFlow {
    private static EducationPage page = PageFactory.initElements(
            Browser.getDriver(), EducationPage.class
    );

    public static void checkSidePanelItems() {
        assertTrue(page.getSidePanelItem("Information & Library Science").isDisplayed());
        assertTrue(page.getSidePanelItem("Education & Public Policy").isDisplayed());
        assertTrue(page.getSidePanelItem("K-12 General").isDisplayed());
        assertTrue(page.getSidePanelItem("Higher Education General").isDisplayed());
        assertTrue(page.getSidePanelItem("Vocational Technology").isDisplayed());
        assertTrue(page.getSidePanelItem("Conflict Resolution & Mediation (School settings)").isDisplayed());
        assertTrue(page.getSidePanelItem("Curriculum Tools- General").isDisplayed());
        assertTrue(page.getSidePanelItem("Special Educational Needs").isDisplayed());
        assertTrue(page.getSidePanelItem("Theory of Education").isDisplayed());
        assertTrue(page.getSidePanelItem("Education Special Topics").isDisplayed());
        assertTrue(page.getSidePanelItem("Educational Research & Statistics").isDisplayed());
        assertTrue(page.getSidePanelItem("Literacy & Reading").isDisplayed());
        assertTrue(page.getSidePanelItem("Classroom Management").isDisplayed());
    }
}
