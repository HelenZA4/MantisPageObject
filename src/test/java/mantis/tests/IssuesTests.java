package mantis.tests;

import mantis.pages.MantisSite;
import mantis.utils.UtilsTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IssuesTests extends BaseTest{
    private MantisSite mantisSite;

    @Test
    public void checkIssuesNumber () throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin","admin20");

        mantisSite.getMainPage().goToViewIssuesPage();

        Thread.sleep(3000);
        mantisSite.getViewIssuesPage().scrollToTableFooter();
        int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();

        Assertions.assertEquals(50, actualIssuesNumber);
    }

    @Test
    public void scrollTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToViewIssuesPage();
        Thread.sleep(2000);

        WebElement selectAll = driver.findElement(By.cssSelector("#bug_arr_all"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectAll);
        Thread.sleep(2000);

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@type='submit' and @value='OK']")).isDisplayed());
        Thread.sleep(1000);
    }
}