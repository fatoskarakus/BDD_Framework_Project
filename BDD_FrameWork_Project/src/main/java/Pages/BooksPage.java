package Pages;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends BaseClass {

    CommonActions cmn = new CommonActions();

    public BooksPage() {
        PageFactory.initElements(driver, this);
    }

    //Object Repository
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div/div/div[2]/div[1]/div/div/div[6]//ul//li[@id='item-0']")
    WebElement strLgnBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='app']/div/div/div[2]/div[1]/div/div/div[6]//ul//li[@id='item-2']")
    WebElement bookStrBtn;

    @FindBy(how = How.XPATH, using = "//form[@id='userForm']//input")
    WebElement sUserNameElement;

    @FindBy(how = How.XPATH, using = "(//form[@id='userForm'])//input[@id='password']")
    WebElement sPasswordElement;

    @FindBy(how = How.XPATH, using = "(//form[@id='userForm'])//button[@id='login']")
    WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//label[@id='userName-value']")
    WebElement userValueTxt;

    @FindBy(how = How.XPATH, using = "//input[@id='searchBox']")
    WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//*[@id='see-book-Git Pocket Guide']/a")
    WebElement bookElmnt;

    @FindBy(how = How.XPATH, using = "//div[@class='text-right fullButton']//*[@id=\"addNewRecordButton\"]")
    WebElement annNewRcrdBtn;


    //*[@id="userForm"]//div/h2
    @FindBy(how = How.XPATH, using = "//*[@id=\"userForm\"]//div/h2")
    WebElement wlcomeTxt;



    public void clickTheBookStoreLgnBtn() {
        cmn.scrollDown();
        cmn.click(driver, strLgnBtn);
    }

    public void sendUserName() {
        cmn.sendText(sUserNameElement, prop.getProperty("UserName"));
    }

    public void sendPassword() {
        cmn.sendText(sPasswordElement, prop.getProperty("Password"));
    }

    public void giveUserNameAndPass() {
        cmn.sendText(sUserNameElement, prop.getProperty("UserName"));
        cmn.sendText(sPasswordElement, prop.getProperty("Password"));
        cmn.click(driver, loginButton);
    }

    public void goToStorePage(){
        cmn.scrollDown();
        cmn.click(driver,bookStrBtn);
    }
    public void clickTheLoginPage() {
        cmn.click(driver, strLgnBtn);
    }

    public String VerifyTheLogin() {
        String value = userValueTxt.getText();
        System.out.println("Doğrulama Sağlanmıştır."+value);
        return value;
    }

    public void searchThePrdct(String book){
        cmn.sendText(searchBox,book);
    }

    public void clickTheBookLink(){
        cmn.click(driver,bookElmnt);
    }

    public void addTheYourCollection(){
        cmn.scrollDown();
        cmn.click(driver,annNewRcrdBtn);
    }

    public boolean seeTheAlert() throws InterruptedException {
        Thread.sleep(1000);
        boolean result=cmn.Alert(driver); //true
        System.out.println("Alert sonucu:"+result);
        return result;
    }

    public String seeTheWelcmeToLogin(){
       String result= wlcomeTxt.getText();
       return result;
    }

    public void close_Driver(){
        closeDriver();
    }




}
