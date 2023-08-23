package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class ReportIssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void addAndDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToReportIssuesPage();
        Thread.sleep(2000);

        mantisSite.getReportIssuesPage().createNewIssue("Summary Lesson 6 23-08-2023", "Description 23-08-2023");
        Thread.sleep(2000);

        mantisSite.getReportIssuesPage().getCreatedIssueId();
        Thread.sleep(2000);

        mantisSite.getViewIssuesPage().deleteIssue();
        Thread.sleep(2000);

        mantisSite.getSureToDeletePage().getDeletedIssueSummary();
        Thread.sleep(2000);

        String title = mantisSite.getMainPage().getTitleRecentlyModifiedDisplayed();
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(title).doesNotContain("Summary Lesson 6 23-08-2023");
    }
}