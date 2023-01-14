package Pages;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ElmntPage extends BaseClass {
    CommonActions cmn = new CommonActions();
    public ElmntPage() {
        PageFactory.initElements(driver, this);
    }

    //Object Repository
    @FindBy(how = How.XPATH, using = "(//ul[@class='menu-list'])//li)[1]")
    WebElement txtBox;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[2]")
    WebElement chcBox;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[3]")
    WebElement rdioBtn;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[4]")
    WebElement webTbl;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[5]")
    WebElement btns;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[6]")
    WebElement lnks;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[7]")
    WebElement brknLnks;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[8]")
    WebElement uplDwnld;

    @FindBy(how = How.XPATH, using = "((//ul[@class='menu-list'])//li)[9]")
    WebElement dynmcProp;

    @FindBy(how = How.XPATH, using = "//div[@class='col-md-7']//button")
    WebElement addBtn;

    //modal-content
    @FindBy(how = How.XPATH, using = "//div[@class='modal-content']")
    WebElement frmModal;

    @FindBy(how = How.XPATH, using = "//div[@class='modal-content']//div[2]//form//div//input")
    WebElement frstNameTxt;

    @FindBy(how = How.XPATH, using = "(//div[@class='modal-content']//div[2]//form)/div[2]//div[2]/input")
    WebElement lastNameTxt;

    @FindBy(how = How.XPATH, using = "(//div[@class='modal-content']//div[2]//form)/div[3]//div[2]/input")
    WebElement userEmailTxt;

    @FindBy(how = How.XPATH, using = "(//div[@class='modal-content']//div[2]//form)/div[4]//div[2]/input")
    WebElement ageTxt;

    @FindBy(how = How.XPATH, using = "(//div[@class='modal-content']//div[2]//form)/div[5]//div[2]/input")
    WebElement slryTxt;

    @FindBy(how = How.XPATH, using = "(//div[@class='modal-content']//div[2]//form)/div[6]//div[2]/input")
    WebElement dprtmntTxt;

    @FindBy(how = How.XPATH, using = "(//div[@class='modal-content']//div[2]//form)/div[7]//button")
    WebElement sbmtBtn;


    //div[@role='rowgroup'][4]//div//div//div//span[2]

    @FindBy(how = How.XPATH, using = "//div[@role='rowgroup'][4]//div//div//div//span[2]")
    WebElement newRcrd;

    //Methods
    public void clickTheWebTables() {webTbl.click();}
    public void clickTheAddBtn() {addBtn.click();}
    public void sendTxtAdd(String isim) {cmn.sendText(frstNameTxt,isim);}
    public void sendTxtSoyAdd(String soyisim) {cmn.sendText(lastNameTxt,soyisim);}
    public void sendTxtEmail(String email) {cmn.sendText(userEmailTxt,email);
    }
    public void sendTxtAge(String age) {
        cmn.sendText(ageTxt,age);
    }
    public void sendTxtSlry(String salary) {cmn.sendText(slryTxt,salary);}
    public void sendTxtDepartmnt(String departman) {cmn.sendText(dprtmntTxt,departman);}
    public void clickSbmtBtn() {
        cmn.click(driver,sbmtBtn);
    }

    public void deleteTheNewRcrd(){cmn.click(driver,newRcrd);
    closeDriver();}



    public void RegisterTheNewMember(String isim,String soyisim,String email,String age,String salary,String departman){
        cmn.click(driver, addBtn);
        cmn.sendText(frstNameTxt,isim);
        cmn.sendText(lastNameTxt,soyisim);
        cmn.sendText(userEmailTxt,email);
        cmn.sendText(ageTxt,age);
        cmn.sendText(slryTxt,salary);
        cmn.sendText(dprtmntTxt,departman);
        cmn.click(driver,sbmtBtn);
    }



}
