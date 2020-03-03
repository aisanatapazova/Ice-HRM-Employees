package Tests.com.Apprun;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesObjects.SalaryPage;
import pagesObjects.pageClass;
import pagesObjects.payRoll_page;
import pagesObjects.salary_Search_Page;
import utils.ConfiReaderFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SalaryRunner extends TestBase{
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
    @Test(priority = 1)
    public void switchMethod() throws InterruptedException {
        extentTest=extentReports.createTest("This is for switching the user");
        SalaryPage page = new SalaryPage();
        page.switchBtn.click();
        Select select = new Select(page.switchInto);
        Thread.sleep(3000);
        select.selectByVisibleText("Lala Lamees");
        page.lastSwitchButton.click();
        String expected = "Lala Lamees";
        String actual = page.sarahName.getText();
        extentTest.log(Status.INFO, "The user is switched");
        Assert.assertEquals(expected,actual);
        extentTest.log(Status.INFO, "User is validated");

    }
    @Test(priority = 2)
    public void addSalary() throws InterruptedException {
        extentTest=extentReports.createTest("This is for adding salary");
        SalaryPage page = new SalaryPage();
        Thread.sleep(4000);
        page.financeBtn.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,700)");

        page.salaryBtn.click();
        String expectedHeader="Salary Finance";
        String actualHeader =page.salaryHeader.getText().trim();
        Assert.assertEquals(actualHeader,expectedHeader);
        extentTest.log(Status.INFO, "The header is validated");
        page.addSalaryBtn.click();
        Map<String, String> salaryList=new HashMap<>();
        salaryList.put("Fixed Allowance", "200000");
        salaryList.put("Car Allowance","1000000");
        salaryList.put("Telephone Allowance","100");
        salaryList.put("Regular Hourly Pay","70");
        salaryList.put("Overtime Hourly Pay","80");
        Set<Map.Entry<String, String>> salarySet=salaryList.entrySet();
        int i=1;
        String test="Test";
        for (Map.Entry<String, String > map:salarySet){
            Select select=new Select(page.componentField);
            select.selectByVisibleText(map.getKey());
            page.amountField.sendKeys(map.getValue());
            page.detailField.sendKeys(test+i);
            i++;
            page.saveBtn.click();
            Thread.sleep(2000);
            page.addBtn.click();
        }
        extentTest.log(Status.INFO, "The salary info is added");
    }
    @Test(priority = 3)
    public void firstTimeSearch(){
        extentTest=extentReports.createTest("This is for searching by salary component");
        salary_Search_Page page = new salary_Search_Page();
        page.financeBtn.click();
        page.salaryBtn.click();
        page.searchField.sendKeys("Car Allowance");
        String expectedAmount = "1000000";
        String expectedTest2 = "Test2";
        String actualAmount = page.amountDisplayed.getText().substring(0,7);
        String actualTest2 = page.test2Displayed.getText().trim();
        System.out.println(actualAmount+" ----> "+actualTest2);
        softAssert.assertEquals(actualAmount,expectedAmount);
        softAssert.assertEquals(actualTest2,expectedTest2);
        softAssert.assertAll();
        extentTest.log(Status.INFO, "The search is validated");

    }
    @Test(priority = 4)
    public void secondTimeSearch() throws InterruptedException {
        extentTest=extentReports.createTest("This is for searching by salary amount");
        salary_Search_Page page = new salary_Search_Page();
        page.financeBtn.click();
        page.salaryBtn.click();
        page.searchField.sendKeys("70");
        String expectedValue = "Regular Hourly Pay";
        String expectedTestNum = "Test3";
        String actualValue = page.RegHourPay.getText();
        String actualTestNum = page.test4Displayed.getText();
        softAssert.assertEquals(expectedValue,actualValue);
        softAssert.assertEquals(expectedTestNum,actualTestNum);
        softAssert.assertAll();
        extentTest.log(Status.INFO, "The search by salary amount is validated");
        System.out.println(actualValue+" ---------> "+actualTestNum);
    }
    @Test(priority = 5)
    public void thirdSearch(){
        extentTest=extentReports.createTest("This is for searching by details");
salary_Search_Page page =new salary_Search_Page();
        page.financeBtn.click();
        page.salaryBtn.click();
        page.searchField.sendKeys("Test5");
        String expectedResult = "Fixed Allowance";
        String expectedAmount = "200000.00";
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        String actualResult = page.overTimeHours.getText();
        String actualAmount = page.correctAmount.getText();
        softAssert.assertEquals(expectedResult,actualResult);
        softAssert.assertEquals(expectedAmount,actualAmount);
        System.out.println(actualResult+"----> "+actualAmount);
        softAssert.assertAll();
        extentTest.log(Status.INFO, "The search by details is validated");
    }
    @Test(priority = 6)
    public void payRoll() throws InterruptedException {
        extentTest=extentReports.createTest("This is for payroll functionality");
        payRoll_page page =new payRoll_page();
        page.payRollBtn.click();
        page.salaryUnderPayRoll.click();
        page.empSalComponents.click();
        page.filterBtn.click();
        Select select = new Select(page.selectName);
        Thread.sleep(3000);
        select.selectByVisibleText("Lala Lamees");
        page.lastFilter.click();

    }


    }


