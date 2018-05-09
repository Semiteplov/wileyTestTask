package flow;

import common.Application;
import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.GenericPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class HomeFlow {
    private static HomePage page = PageFactory.initElements(
            Browser.getDriver(), HomePage.class
    );

    public static void openHomePage() {
        Browser.getDriver().navigate().to(Application.getProperty("app.url"));
        cancelUndetectedCountryForm();
    }

    public static void cancelUndetectedCountryForm() {
        try {
            Browser.setSmallTimeout();
            GenericPage.clickAndPrintMessage(page.getCancelButton(), "Confirm country change");
            Browser.setDefaultTimeout();
        } catch (NoSuchElementException e) {
            System.out.println("Undetected country form is not present");
        }
    }

    public static void fillSearchInputField(String text) {
        GenericPage.clearAndFill(page.getSearchInput(), text);
    }

    public static void clickSearchButton() {
        GenericPage.clickAndPrintMessage(page.getSearchButton(), "Search");
    }

    public static void openSubHeaderList(String subHeaderName) {
        // Sorry, didn't find a better way
        GenericPage.waitSeconds(1);
        GenericPage.moveToElement(page.getMenuItem(subHeaderName));
    }

    public static void openSpecificPageFromMainMenu(String menuItem, String dropdownItem) {
        if (menuItem.equalsIgnoreCase("Subjects")) {
            String firstItem = dropdownItem.substring(0, dropdownItem.indexOf(" -> "));
            String secondItem = dropdownItem.substring(dropdownItem.indexOf("> ") + 2);

            GenericPage.clickAndPrintMessage(page.getSpecificSubHeaderItem(menuItem, firstItem ), firstItem );
            GenericPage.clickAndPrintMessage(page.getSubjectsItem(secondItem), secondItem);
        } else {
            GenericPage.clickAndPrintMessage(page.getSpecificSubHeaderItem(menuItem, dropdownItem), dropdownItem);
        }
    }

    public static List<String> saveListOfProducts() {
        List<String> listOfProducts = new ArrayList<>();

        for (WebElement element : page.getFoundProducts()) {
            listOfProducts.add(element.findElement(By.xpath("./div/h3/a")).getText());
        }

        return listOfProducts;
    }

    public static void checkMenuItems() {
        assert page.isElementPresent(page.getMenuItem("Resources"));
        assert page.isElementPresent(page.getMenuItem("Subjects"));
        assert page.isElementPresent(page.getMenuItem("About"));
    }

    public static void checkURLOfCurrentPage(String url) {
        assertEquals(Browser.getDriver().getCurrentUrl(), url);
    }

    public static void assertHomePageIsPresent() {
        assertTrue(page.getHomepageLogo().isDisplayed());
    }

    public static void assertHomePageContentIsPresent() {
        assertTrue(page.getHomepageContent().isDisplayed());
    }

    public static void assertInfoOfFoundProducts() {
        assertEquals(page.getFoundProducts().size(), 10);

        for (WebElement element : page.getFoundProducts()) {
            assertTrue(element.findElement(By.xpath("./div/h3/a")).getText().toLowerCase().contains("math"));
            assertTrue(element.findElement(By.xpath(".//button[contains(@class,'add-to-cart-button')]")).isDisplayed());
        }
    }

    public static void assertSearchResultsAreEqual(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            assertTrue(page.getFoundProducts().get(i).findElement(By.xpath("./div/h3/a")).getText().equalsIgnoreCase(list.get(i)));
        }
    }

    public static void assertProductsIsCorrect() {
        assertEquals(page.getProducts().size(), 4);
    }

    public static void assertProductTitlesIsCorrect() {
        for (WebElement element : page.getProductsTitles()) {
            assertTrue(element.getAttribute("title").startsWith("math"));
        }
    }

    public static void checkResourcesItems() {
        assertEquals(page.getSubHeaderItems("Resources").size(), 10);

        assertTrue(page.getSubHeaderItems("Resources").get(0).getText().equalsIgnoreCase("Authors"));
        assertTrue(page.getSubHeaderItems("Resources").get(1).getText().equalsIgnoreCase("Corporations"));
        assertTrue(page.getSubHeaderItems("Resources").get(2).getText().equalsIgnoreCase("Institutions"));
        assertTrue(page.getSubHeaderItems("Resources").get(3).getText().equalsIgnoreCase("Instructors"));
        assertTrue(page.getSubHeaderItems("Resources").get(4).getText().equalsIgnoreCase("Librarians"));
        assertTrue(page.getSubHeaderItems("Resources").get(5).getText().equalsIgnoreCase("Professionals"));
        assertTrue(page.getSubHeaderItems("Resources").get(6).getText().equalsIgnoreCase("Researchers"));
        assertTrue(page.getSubHeaderItems("Resources").get(7).getText().equalsIgnoreCase("Resellers"));
        assertTrue(page.getSubHeaderItems("Resources").get(8).getText().equalsIgnoreCase("Societies"));
        assertTrue(page.getSubHeaderItems("Resources").get(9).getText().equalsIgnoreCase("Students"));
    }
}
