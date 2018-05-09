package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentsPage extends GenericPage {
    @FindBy(xpath = "//a[text()='WileyPLUS']")
    private WebElement wileyPlusLink;

    public WebElement getWileyPlusLink() {
        return wileyPlusLink;
    }
}
