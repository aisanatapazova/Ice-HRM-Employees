package pagesObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.Driver;
public class salary_Search_Page {
    public salary_Search_Page(){
        PageFactory.initElements(Driver.getDriver(),this );
    }
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//span[.='Finance']")
    public WebElement financeBtn;
    @FindBy(xpath = "//a[@data-turbolinks='true']//following-sibling::i[@class='fa fa-calculator']")
    public WebElement salaryBtn;
    @FindBy(xpath = "//label//input[@class='form-control']")
    public WebElement searchField;
    @FindBy(xpath = "//td[.='1000000.00']")
    public WebElement amountDisplayed;
    @FindBy(xpath = "//td[.='Test2']")
    public WebElement test2Displayed;
    @FindBy(xpath = "//td[.='Regular Hourly Pay']")
    public WebElement RegHourPay;
    @FindBy(xpath = "//td[.='Test3']")
    public WebElement test4Displayed;
    @FindBy(xpath = "//td[.='Fixed Allowance']")
    public WebElement overTimeHours;
    @FindBy(xpath = "//td[.='200000.00']")
    public WebElement correctAmount;




}
