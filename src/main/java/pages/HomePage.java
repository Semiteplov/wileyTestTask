package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends GenericPage {
    private static final String LOCATOR_FOR_HEADER_ITEMS = "//ul[@class='navigation-menu-items']/li/a[text()='%s']";
    private static final String LOCATOR_FOR_SUB_HEADER_ITEMS = "//a[text()='%s']/../div[contains(@id,'navigationNode')]//a";
    private static final String LOCATOR_FOR_SUBJECTS_SUB_LIST = "//div[contains(@id,'navigationNode')]//li/a[text()='Education']";

    @FindBy(id = "command")
    private WebElement undetectedCountryForm;
    @FindBy(id = "js-site-search-input")
    private WebElement searchInput;
    @FindBy(xpath = "//button[text()='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//button[text()='YES']")
    private WebElement confirmButton;
    @FindBy(xpath = "//button[text()='NO']")
    private WebElement cancelButton;
    @FindBy(xpath = "//ul[@class='navigation-menu-items']")
    private WebElement navigationMenuItems;
    @FindBy(xpath = "//title[contains(text(),'Homepage')]/../../body")
    private WebElement homepageLogo;
    @FindBy(xpath = "//div[@class='search-related-content']")
    private WebElement relatedContent;
    @FindBy(xpath = "//div[contains(@class,'wiley-rich-content-page')]")
    private WebElement homepageContent;
    @FindBy(xpath = "//div[@class='related-content-products']/section/div/h3/a[contains(text(),'Math')]")
    private List<WebElement> products;
    @FindBy(xpath = "//div[@class='search-list']/div/a")
    private List<WebElement> productsTitles;
    @FindBy(xpath = "//div[@class='products-list']/section")
    private List<WebElement> foundProducts;

    public List<WebElement> getFoundProducts() {
        return foundProducts;
    }

    public List<WebElement> getProductsTitles() {
        return productsTitles;
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getHomepageContent() {
        return homepageContent;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getHomepageLogo() {
        return homepageLogo;
    }

    public WebElement getUndetectedCountryForm() {
        return undetectedCountryForm;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getNavigationMenuItems() {
        return navigationMenuItems;
    }

    public WebElement getSpecificSubHeaderItem(String menuItem, String subItem) {
        String locator = String.format(LOCATOR_FOR_SUB_HEADER_ITEMS.concat("[text()='%s']"), menuItem, subItem);
        return Browser.getDriver().findElement(By.xpath(locator));
    }

    public WebElement getMenuItem(String item) {
        String locator = String.format(LOCATOR_FOR_HEADER_ITEMS, item);
        return Browser.getDriver().findElement(By.xpath(locator));
    }

    public WebElement getSubjectsItem(String item) {
        String locator = String.format(LOCATOR_FOR_SUBJECTS_SUB_LIST, item);
        return Browser.getDriver().findElement(By.xpath(locator));
    }

    public List<WebElement> getSubHeaderItems(String name) {
        String locator = String.format(LOCATOR_FOR_SUB_HEADER_ITEMS, name);
        return Browser.getDriver().findElements(By.xpath(locator));
    }
}
