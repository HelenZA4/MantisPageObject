package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "span.user-info")
    private WebElement userName;

    @FindBy(css = "a[href='/mantisbt/view_all_bug_page.php']")
    private WebElement viewIssuesPageButton;

    @FindBy(css = "a[href='/mantisbt/bug_report_page.php']")
    private WebElement reportIssuesPageButton;

    @FindBy(xpath = "//*[@id='assigned']")
    private WebElement assignedToMeBlock;

    @FindBy(xpath = "//*[@id='unassigned']")
    private WebElement unassignedBlock;

    @FindBy(xpath = "//*[@id='reported']")
    private WebElement reportedByMe;

   @FindBy(xpath = "//*[@id='resolved']")
    private WebElement resolved;

    @FindBy(xpath = "//*[@id='recent_mod']")
    private WebElement recentlyModified;

    @FindBy(css = "tr:nth-child(1) > td.column-id > a")
    private WebElement newIssueId;

    @FindBy(xpath = "//*[@type='submit' and @value='Delete']")
    private WebElement deleteButton;

    @FindBy(css = "input[value='Delete Issues']")
    private WebElement deleteIssuesButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userName.getText();
    }

    public boolean isAssignedToMeBlockDisplayed(){
        return assignedToMeBlock.isDisplayed();
    }

    public boolean isUnassignedBlockDisplayed(){
        return unassignedBlock.isDisplayed();
    }

    public String isReportedByMeDisplayed() {
        return reportedByMe.getText();
    }

    public String getTitleAssignedToMeBlock(){
        return assignedToMeBlock.findElement(By.xpath("//h4//a")).getText();
   }

    public void goToViewIssuesPage() {
        viewIssuesPageButton.click();
    }

    public void goToReportIssuesPage() {
        reportIssuesPageButton.click();
    }

    public String getCreatedIssueId() {
        return newIssueId.getText();
    }
}
