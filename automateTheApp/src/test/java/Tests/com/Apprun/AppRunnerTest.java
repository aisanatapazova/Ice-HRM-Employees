package Tests.com.Apprun;

import org.openqa.selenium.support.ui.Select;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pagesObjects.SalaryPage;
import pagesObjects.pageClass;
import utils.ConfiReaderFile;
import utils.Driver;
import utils.ScreenshotMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class AppRunnerTest extends TestBase {

    public static String createEmployeeId(String str, int numbers) {
        StringBuilder sb = new StringBuilder();
        Random randomNumbers = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(str.charAt(randomNumbers.nextInt(str.length())));
        }
        return sb.toString();
    }

    @DataProvider(name = "EmployeeData")
    public Object[][] getEmpData() {
        return new Object[][]{
                {createEmployeeId("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 8), "David", "Lee", "Albanian", "01/04/1992", "Male", "Married", "Full Time Internship", "Software Engineer", "Albania", "2020", "Development Team", "any"},
                {createEmployeeId("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 8), "Robert", "Smith", "American", "03/08/1999", "Male", "Single", "Full Time Permanent", "Software Engineer", "United States", "2020", "Development Team", "any"},
                {createEmployeeId("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 8), "Maria", "Garcia", "Canadian", "05/10/2000", "Female", "Divorced", "Full Time Internship", "Software Engineer", "Canada", "2018", "Development Team", "any"},
                {createEmployeeId("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 8), "Jenifer", "Zack", "Cuban", "08/11/2001", "Female", "Married", "Full Time Permanent", "Software Engineer", "Cuba", "2017", "Development Team", "any"},
                {createEmployeeId("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 8), "James", "Anderson", "Gambian", "04/03/2004", "Male", "Single", "Full Time Permanent", "Software Engineer", "Gambia", "2016", "Development Team", "any"}};
    }

    Select select;

    @BeforeTest
    public void login() {

        TestBase.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TestBase.driver.navigate().to("http://icehrm-open.gamonoid.com/login.php");
        softAssert = new SoftAssert();
        pageClass page = new pageClass();
        String userName = ConfiReaderFile.getProperty("username");
        String password = ConfiReaderFile.getProperty("password");
        page.Login(userName, password);

    }

    @Test(dataProvider = "EmployeeData")

    public static void addingInfo(String EmpIds, String FirstName, String lastName, String nationality, String DOB, String gender, String marriageStatus, String empStatus, String JobTitle,
                                  String country, String JobDate, String department, String IndirectSup) {
        TestBase.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageClass page = new pageClass();
        page.EmployeeBtn.click();
        page.getEmployeeBtn.click();
        page.addEmp.click();
        TestBase.driver.navigate().refresh();
        page.addEmp.click();
        page.EmpNumber.sendKeys(EmpIds);
        page.FirstName.sendKeys(FirstName);
        page.LastName.sendKeys(lastName);
        Select select = new Select(page.Nationality);
        select.selectByVisibleText(nationality);
        page.BirthDate.sendKeys(DOB);
        select = new Select(page.GenderSelect);
        select.selectByVisibleText(gender);
        select = new Select(page.familyStatus);
        select.selectByVisibleText(marriageStatus);
        select = new Select(page.EmployeeStatus);
        select.selectByVisibleText(empStatus);
        select = new Select(page.JobTilte);
        select.selectByVisibleText(JobTitle);
        select = new Select(page.CountryOfOrigin);
        select.selectByVisibleText(country);
        page.joinedDate.sendKeys(JobDate);
        select = new Select(page.department);
        select.selectByVisibleText(department);
        TestBase.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        select = new Select(page.IndirectSupervisor);
        select.selectByValue("4");
        page.saveButton.click();
        page.noButton.click();
    }

    @Test(dependsOnMethods = "addingInfo", description = "need to filter by job title")
    public void filter() throws InterruptedException {
        Thread.sleep(3);
        pageClass page = new pageClass();
        page.filterBtn.click();
        page.clickFilterButton.click();
        page.setJobTilte(page.writeDep, "Software Engineer");
        page.lastFilterBTN.click();
    }

    @Test(dependsOnMethods = "filter")
    public void FilterAssertion() throws InterruptedException {
        pageClass page = new pageClass();
        String expTitleResult = "Job Title = Software Engineer";
        Thread.sleep(4);
        String actualRestult = page.softWareTitle.getText().trim();
        softAssert.assertEquals(expTitleResult, actualRestult);
        System.out.println(actualRestult + " title was correct! ");
    }

    @Test(dependsOnMethods = "FilterAssertion")
    public void verifyEmployees() {
        pageClass page = new pageClass();
        List<String> expectedNames = pageClass.existingNameCheck();
        for (int i = 0; i < expectedNames.size(); i++) {
            softAssert.assertTrue(page.listOfEmployees.get(i).getText().contains(expectedNames.get(i)));
        }
        softAssert.assertAll();

    }

    }



    //    @Test(dependsOnMethods = "verifyEmployees")


//    @AfterMethod
//    public static void takeScreenShot(ITestResult result) throws IOException {
//       if (result.getStatus()==ITestResult.FAILURE);
//        ScreenshotMethod.takeScreenShot();
//
//
//    }





