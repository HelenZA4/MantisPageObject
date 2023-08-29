package mantis.pages;

import mantis.utils.UtilsTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

    @FindBy(id = "summary")
    private WebElement summaryField;

    @FindBy(xpath = "//div[@class='footer-content']")
    private WebElement tableFooter;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@value='Delete Issues']")
    private WebElement deleteIssuesButton;

    @FindBy(xpath = "//tr[1]//td[@class='column-id']/a[1]")
    private WebElement issueId;

    @FindBy(xpath = "//*[@id='bug_action']")
    private WebElement viewingIssues;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void scrollToTableFooter() throws InterruptedException {
        UtilsTests.scrollToElement(driver, tableFooter);
    }

    public int countIssues() {
        return issues.size();
    }
    public void selectNewIssueId() {
        issueId.click();
    }
    public void deleteLastIssue() {
        deleteButton.click();
        deleteIssuesButton.click();
    }

    public boolean isIssuePresent(String issueId) { return true;}

    public String getTitleViewingIssues(){
        return viewingIssues.findElement(By.xpath("//*[@id='bug_action']")).getText();
    }
}
