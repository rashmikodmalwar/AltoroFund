// import java.io.ObjectInputFilter.Status;
// import java.net.MalformedURLException;
// import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;

import static org.testng.Assert.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import AltoroFund_TestNG.DP;
import AltoroFund_TestNG.Pages.ContactUs;
import AltoroFund_TestNG.Pages.LoginPage;
import AltoroFund_TestNG.Pages.TransferFundPage;
import AltoroFund_TestNG.Pages.ViewAccoutnSummery;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_01 {
    
   static WebDriver driver;

    @BeforeSuite
    public static WebDriver createDriver() {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
     
     
    @Test(dataProvider = "logindata", dataProviderClass = DP.class,description = "verify flow from - Sign In -Sign Off")
    public void TestCase01(String username,String password) throws InterruptedException {
        Boolean status;
        LoginPage loginpage = new LoginPage(driver);
        loginpage.navigateToPage();
        status = loginpage.PerformLogin(username,password,"Welcome to Altoro Mutual Online.");
        assertTrue(status,"Invalid username and password");
        ViewAccoutnSummery view_account = new ViewAccoutnSummery(driver);
        view_account.clickOnViewAccountSummery();
        view_account.viewAccountDetails("800001 Checking");
        status = view_account.verifyAvailableBalance();
        assertTrue(status,"Failed to get avaialable balance");
        TransferFundPage fundPage = new TransferFundPage(driver);
        fundPage.ClickOnTransferFunds();
        fundPage.transferFundDetail("800000 Corporate", "800001 Checking",9876);
        status =fundPage.validateTransactionDetailMessage(9876);
        assertTrue(status,"Failed to validate transaction detail");
        fundPage.clickOnViewRecentTransaction();
        status=fundPage.validateDepositTransactionDetail();
        assertTrue(status,"Failed to validate transaction detail for deposit");
        status=fundPage.validateWithdrawlTransactionDetail();
        assertTrue(status,"Failed to validate transaction detail for withdrawl");
        ContactUs contact = new ContactUs(driver);
        contact.clickOnContactUs();
        contact.clickOnlineForm();
        contact.fillUpOnlineFormDetail("admin_user", "admin@gmail.com", "fund transfer issue", "not able to transfer");
        contact.clickOnSignOff();
        contact.VerifySignOff();
    }

    @AfterSuite
    public static void QuitDriver(){
        System.out.println("quit()");
        driver.quit();
    }
  
}