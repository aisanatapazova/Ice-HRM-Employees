package pagesObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;
import utils.Driver;
import utils.ScreenshotMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class pageClass {
    public pageClass() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "username")
    public WebElement Login;
    @FindBy(id = "password")
    public WebElement PassLogin;
    @FindBy(xpath = "//button[@onclick='submitLogin();return false;']")
    public WebElement loginBtn;
    @FindBy(xpath = "//span[.='Employees']")
    public WebElement EmployeeBtn;
    @FindBy(xpath = "//a[@data-turbolinks='true']//following-sibling::i[@class='fa fa-users']       ")
    public WebElement getEmployeeBtn;
    @FindBy(xpath = "//button[@onclick='modJs.renderForm();return false;']")
    public WebElement addEmp;
    @FindBy(xpath = "//input[@id='employee_id']")
    public WebElement EmpNumber;
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement FirstName;
    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement LastName;
    @FindBy(xpath = "//select[@id='nationality']")
    public WebElement Nationality;
    @FindBy(xpath = "//input[@id='birthday']")
    public WebElement BirthDate;
    @FindBy(xpath = "//select[@id='gender']")
    public WebElement GenderSelect;
    @FindBy(xpath = "//select[@id='marital_status']")
    public WebElement familyStatus;
    @FindBy(xpath = "//select[@id='employment_status']")
    public WebElement EmployeeStatus;
    @FindBy(xpath = "//select[@id='job_title']")
    public WebElement JobTilte;
    @FindBy(xpath = "//select[@id='country']")
    public WebElement CountryOfOrigin;
    @FindBy(xpath = "//input[@id='joined_date']")
    public WebElement joinedDate;
    @FindBy(xpath = "//select[@id='department']")
    public WebElement department;
    @FindBy(xpath = "//select[@id='indirect_supervisors']")
    public WebElement IndirectSupervisor;
    @FindBy(xpath = "//div[@class=\"controls col-sm-9\"]//button[1]")
    public WebElement saveButton;
    @FindBy(xpath = "//button[@onclick='modJs.closeCreateUser();']")
    public WebElement noButton;
    @FindBy(xpath = "//button[@onclick='modJs.showFilters();return false;']")
    public WebElement filterBtn;
    @FindBy(xpath = "//span[.='All Job Titles']")
    public WebElement clickFilterButton;
    @FindBy(xpath = "//input[@aria-owns='select2-results-64']")
    public WebElement writeDep;
    @FindBy(xpath = "//button[@class='filterBtn btn btn-primary pull-right']")
    public WebElement lastFilterBTN;
    @FindBy(xpath = "//ul[@id='select2-results-16']//li")
    public List<WebElement> listOFTitles;
    @FindBy(xpath = "//button[.='Job Title = Software Engineer ']")
    public WebElement softWareTitle;
    @FindBy(xpath = "//table[@class='table table-striped dataTable']//tr")
    public List<WebElement> listOfEmployees;
    @FindBy(xpath = "//th[.='First Name']")
    public WebElement FirstNameHeader;


   public void setJobTilte(WebElement element, String title) {
        for (WebElement titles : listOFTitles) {
            if (titles.getText().trim().equals(title)) {
                titles.click();
                break;
            }}}
    public void Login(String userName, String password) {
        this.Login.sendKeys(userName);
        this.PassLogin.sendKeys(password);
        loginBtn.click();
    }
    public static List<String> existingNameCheck() {
        List<String> names1 = new ArrayList<>();
        names1.add("David");
        names1.add("Robert");
        names1.add("Maria");
        names1.add("Jenifer");
        names1.add("James");
       return names1;

        }
    public void ascendingOrder(ITestResult result) throws IOException {
        pageClass page = new pageClass();
        page.FirstNameHeader.click();
        if (result.getStatus()==ITestResult.SUCCESS);
        ScreenshotMethod.takeScreenShot();
        String expectedName = "David";
       // String actualName =
        //softAssert.assertTrue();
    }
}
