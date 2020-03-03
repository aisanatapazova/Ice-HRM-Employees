package Tests.com.Apprun;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.asserts.SoftAssert;
import utils.Driver;

import java.util.concurrent.TimeUnit;
public class TestBase {
    public static SoftAssert softAssert;
   public static WebDriver driver;
   public static ExtentHtmlReporter htmlReporter;
   public static ExtentReports extentReports;
   public static ExtentTest extentTest;


   @BeforeTest
    public void setupDriver(){
        driver= Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output//MouseAction/myReport.html");
        htmlReporter.config().setDocumentTitle("Ice HRM Report");
        htmlReporter.config().setReportName("Validating Employees");
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("OS", "MAC OS");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("Domain", "com.Apprun");

   }

   @AfterTest
    public void tearDown(){
       if (driver!=null){
           extentReports.flush();
       }
   }

}
