package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisSite {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;
    private ReportIssuesPage reportIssuesPage;
    private ViewIssuesPage viewIssuesPage;

    public MantisSite(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
        reportIssuesPage = new ReportIssuesPage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);
    }

    public void login(String login, String password) {
        loginPage.login(login);
        passwordPage.login(password);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public PasswordPage getPasswordPage() {
        return passwordPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ReportIssuesPage getReportIssuesPage() {
        return reportIssuesPage;
    }

    public ViewIssuesPage getViewIssuesPage() {
        return viewIssuesPage;
    }
}
