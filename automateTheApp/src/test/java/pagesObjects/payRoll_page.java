package pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.Driver;

public class payRoll_page {
    public payRoll_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath ="//span[.='Payroll']")
    public WebElement payRollBtn;
    @FindBy(xpath = "//a[@href='http://icehrm-open.gamonoid.com/?g=admin&n=salary&m=admin_Payroll']//i")
    public WebElement salaryUnderPayRoll;
    @FindBy(xpath = "//a[.='Employee Salary Components']")
    public WebElement empSalComponents;
    @FindBy(xpath = "//button[.='Filter ']")
    public WebElement filterBtn;
    @FindBy(xpath = "//select[@id='employee']")
    public WebElement selectName;
    @FindBy(xpath = "//button[.=' Filter']")
    public WebElement lastFilter;





}
