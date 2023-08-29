package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ReportIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "summary")
    private WebElement summaryField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(css = "input[value='Submit Issue']")
    private WebElement submitButton;

    @FindBy(css = "tr:nth-child(1) > td.column-id > a")
    private WebElement newIssueId;

    @FindBy(linkText = "View Issues")
    private WebElement viewIssuesLink;

    @FindBy(xpath = "//table[@id='buglist']/tbody/tr[1]")
    private WebElement lastIssueRow;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;

    @FindBy(css = "input[value='Delete Issues']")
    private WebElement deleteIssuesButton;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

    public ReportIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void createNewIssue(String summary, String description) {
        summaryField.sendKeys(summary);
        descriptionField.sendKeys(description);
        submitButton.click();
    }

    public String getCreatedIssueId() {
        return newIssueId.getText();
    }

    public void deleteLastIssue() {
        deleteButton.click();
        deleteIssuesButton.click();
    }
}
