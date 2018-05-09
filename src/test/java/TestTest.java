import common.Browser;
import flow.EducationFlow;
import flow.GenericFlow;
import flow.HomeFlow;
import flow.StudentsFlow;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestTest {
    private static List<String> foundProducts;

    @Test(groups = "openSite",
            description = "Open main page and check menu items")
    public void openSite() {
        HomeFlow.openHomePage();
        HomeFlow.checkMenuItems();
    }

    @Test(groups = "checkResources",
            dependsOnGroups = "openSite",
            description = "Check items of Resources")
    public void checkResources() {
        HomeFlow.openSubHeaderList("Resources");
        HomeFlow.checkResourcesItems();
    }

    @Test(groups = "checkStudentsPage",
            dependsOnGroups = "openSite",
            description = "Check Students page")
    public void checkStudentsPage() {
        HomeFlow.openSpecificPageFromMainMenu("Resources", "Students");
        HomeFlow.checkURLOfCurrentPage("https://www.wiley.com/en-ru/students");
        GenericFlow.checkHeader("Students");
        StudentsFlow.checkWileyPlusLink();
    }

    @Test(groups = "checkEducationPage",
            dependsOnGroups = "checkStudentsPage",
            description = "Check Education page")
    public void checkSubjectsPage() {
        HomeFlow.openSubHeaderList("Subjects");
        HomeFlow.openSpecificPageFromMainMenu("Subjects", "E-L -> Education");
        GenericFlow.checkHeader("Education");
        EducationFlow.checkSidePanelItems();
    }

    @Test(groups = "goToHomePage",
            dependsOnGroups = "checkEducationPage",
            description = "Go to home page by pressing on logo")
    public void pressOnLogo() {
        GenericFlow.clickOnLogo();
        HomeFlow.assertHomePageIsPresent();
    }

    @Test(groups = "searchNothing",
            dependsOnGroups = "goToHomePage",
            description = "Search nothing by search input field")
    public void searchNothing() {
        HomeFlow.fillSearchInputField("");
        HomeFlow.clickSearchButton();
        HomeFlow.assertHomePageContentIsPresent();
    }

    @Test(groups = "fillSearchField",
            dependsOnGroups = "searchNothing",
            description = "Fill search input field with Math value")
    public void fillSearchInputField() {
        HomeFlow.fillSearchInputField("Math");
        HomeFlow.assertProductsIsCorrect();
        HomeFlow.assertProductTitlesIsCorrect();
    }

    @Test(groups = "searchProducts",
            dependsOnGroups = "fillSearchField",
            description = "Search products")
    public void searchProducts() {
        HomeFlow.clickSearchButton();
        HomeFlow.assertInfoOfFoundProducts();
    }

    @Test(groups = "checkResultsAreEqual",
            dependsOnGroups = "searchProducts",
            description = "Check that search results are equal")
    public void checkListOfProducts() {
        foundProducts = HomeFlow.saveListOfProducts();
        HomeFlow.fillSearchInputField("Math");
        HomeFlow.clickSearchButton();
        HomeFlow.assertSearchResultsAreEqual(foundProducts);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Browser.getDriver().quit();
    }
}
