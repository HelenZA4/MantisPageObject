package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Test;

public class SureToDeleteTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void clickToDeleteIssueButton() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToReportIssuesPage();
        Thread.sleep(2000);

        mantisSite.getSureToDeletePage().getDeletedIssueSummary();
        Thread.sleep(2000);

    }
}
