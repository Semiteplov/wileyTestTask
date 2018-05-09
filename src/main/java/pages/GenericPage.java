package pages;

import common.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage {
    private final static String LOCATOR_FOR_HEADER = "//article[contains(@class,'section-description')]//*[text()='%s']";

    @FindBy(xpath = "//div[@class='yCmsContentSlot logo']")
    private WebElement logo;

    public static void clearAndFill(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public boolean isElementPresent(WebElement element){
        return element.isDisplayed();
    }

    public static void clickAndPrintMessage(WebElement element, String message) {
        System.out.println(String.format("Press on '%s'", message));
        element.click();
    }

    public static void waitWhileElemIsVisible(WebElement element){
        WebDriver driver = Browser.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        WebDriver driver = Browser.getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean pageIsLoaded() {
        WebDriver driver = Browser.getDriver();
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    public static void waitSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moveToElement(WebElement element) {
        Actions action = new Actions(Browser.getDriver());
        action.moveToElement(element).build().perform();
    }

    public WebElement getHeader(String header) {
        String locator = String.format(LOCATOR_FOR_HEADER, header);
        return Browser.getDriver().findElement(By.xpath(locator));
    }

    public WebElement getLogo() {
        return logo;
    }
}
