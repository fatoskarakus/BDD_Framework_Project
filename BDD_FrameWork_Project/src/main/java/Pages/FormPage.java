package Pages;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import ExcelLibraries.ExcelLibraries;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FormPage extends BaseClass {

    CommonActions cmn = new CommonActions();
    ExcelLibraries excl;
    String data;

    public FormPage() {
        PageFactory.initElements(driver, this);
    }

    //Objects Repositories
    @FindBy(how = How.XPATH, using = "//div[@class='element-list collapse show']")
    WebElement prctiseFrm;

    @FindBy(how = How.XPATH, using = "//input[@id='firstName']")
    WebElement frmFrstName;

    @FindBy(how = How.XPATH, using = "//input[@id='lastName']")
    WebElement frmLstName;

    @FindBy(how = How.XPATH, using = "//div[@class='col-md-9 col-sm-12']//div[2]//input")
    WebElement slcGndr;

    @FindBy(how = How.XPATH, using = "//input[@id='userEmail']")
    WebElement frmUsrEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='userNumber']")
    WebElement frmMobile;

    @FindBy(how = How.XPATH, using = "//input[@id='dateOfBirthInput']")
    WebElement frmDetaPckr;

    @FindBy(how = How.XPATH, using = "//div[@class='react-datepicker__month-container']//div/div")
    WebElement frmDetaPckrDeta;

    @FindBy(how = How.XPATH, using = "//div[@class='react-datepicker']//button[1]")
    WebElement frmDetaPreBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]")
    WebElement frmDetaDay;

    @FindBy(how = How.XPATH, using = "//*[@id=\"hobbies-checkbox-1\"]")
    WebElement chkTheHobies;

    @FindBy(how = How.XPATH, using = "//form[@id='userForm']/div[8]/div[2]/div/input")
    WebElement clkDowmBtn;

    @FindBy(how = How.XPATH, using = "//textarea[@id='currentAddress']")
    WebElement frmCrntAdrss;

    ////*[@id="submit"]
    @FindBy(how = How.XPATH, using = "//*[@id='submit']")
    WebElement frmSbmBtn;

    @FindBy(how = How.XPATH, using = "//div[@id='example-modal-sizes-title-lg']")
    WebElement frmTitleTxt;

    public void clickThePrctiseForm() {
        cmn.scrollDown();
        cmn.click(driver, prctiseFrm);
    }

    public void sendTheEmpFrstName() throws IOException {
        excl = new ExcelLibraries();
        data = excl.getCellData("Registration", "FirstName", 2);
        cmn.sendText(frmFrstName, data);
    }

    public void sendTheEmpLstName() {
        excl = new ExcelLibraries();
        data = excl.getCellData("Registration", "LastName", 2);
        cmn.sendText(frmLstName, data);
    }

    public void sendTheEmail() {
        excl = new ExcelLibraries();
        data = excl.getCellData("Registration", "Email", 2);
        cmn.sendText(frmUsrEmail, data);
    }

    public void selectGender() {
        cmn.click(driver, slcGndr);
    }

    public void sendTheMobileLine() {
        excl = new ExcelLibraries();
        data = excl.getCellData("Registration", "Mobile", 2);
        cmn.sendText(frmMobile, data);
    }

    public void choseTheBirtDay() {
        cmn.click(driver, frmDetaPckr);
        String deta = frmDetaPckrDeta.getText(); //January 2023
        String mount = deta.split(" ")[0].trim(); //January
        String year = deta.split(" ")[1].trim(); //2023
        while (!(mount.equals("June") && year.equals("2022"))) {
            frmDetaPreBtn.click();
            deta = frmDetaPckrDeta.getText();
            mount = deta.split(" ")[0].trim();
            year = deta.split(" ")[1].trim();
        }
        frmDetaDay.click();
    }

    public void scltHobies() {
        cmn.scrollDown();
        cmn.click(driver, chkTheHobies);
    }

    public void clcTheDownDocmt() throws IOException {
        clkDowmBtn.sendKeys(prop.getProperty("filepath"));
    }

    public void sendCrntAdress() {
        cmn.scrollDown();
        cmn.sendText(frmCrntAdrss, prop.getProperty("Address"));
    }

    public void sbtBtn(){
        cmn.click(driver,frmSbmBtn);
    }

    public String verfyTheRecord(){
        String title=frmTitleTxt.getText();
        return title;
    }



}