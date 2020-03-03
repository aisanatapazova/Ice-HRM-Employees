package pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.Driver;

public class SalaryPage {
    public SalaryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();
        @FindBy(xpath = "//span[.='Switch']")
        public WebElement switchBtn;
        @FindBy(id = "switch_emp")
    public WebElement switchInto;
@FindBy(xpath = "//button[.='Switch']")
    public WebElement lastSwitchButton;
@FindBy(xpath = "//a[.='Lala Lamees']")
    public WebElement sarahName;
@FindBy(xpath = "//span[.='Finance']")
    public WebElement financeBtn;
@FindBy(xpath = "//a[@data-turbolinks='true']//following-sibling::i[@class='fa fa-calculator']")
    public WebElement salaryBtn;
@FindBy(xpath = "//h1")
    public WebElement salaryHeader;
@FindBy(xpath = "//button[@class='btn btn-small btn-primary']")
    public WebElement addSalaryBtn;
    @FindBy(xpath = "//button[@class='btn btn-small btn-primary']")
    public WebElement addBtn;
    @FindBy(id = "component")
    public WebElement componentField;
    @FindBy(id = "amount")
    public WebElement amountField;
    @FindBy (id = "details")
    public WebElement detailField;
    @FindBy(xpath = "//div[@class='controls col-sm-9']/button[@class='saveBtn btn btn-primary pull-right']")
    public WebElement saveBtn;
}

