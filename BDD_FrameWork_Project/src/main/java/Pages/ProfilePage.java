package Pages;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseClass {

    CommonActions cmn = new CommonActions();

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='app']/div/div/div[2]/div[1]/div/div/div[6]//ul//li[@id='item-2']")
    WebElement prfBtn;

    @FindBy(how = How.XPATH, using = "//span[@id='delete-record-undefined']")
    WebElement dltTheBookBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"see-book-Git Pocket Guide\"]")
    WebElement bsktBookNameTxt;

    //modal-content
    @FindBy(how = How.XPATH, using = "//div[@class='modal-content']")
    WebElement popUpMdl;
    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[@class='modal-content']//div[3]//button[1]")
    WebElement popUpMdlOkBtn;

    ///html/body/iframe[2]
    @FindBy(how = How.XPATH, using = "//html/body/iframe[2]")
    WebElement iframeAlrt;

    @FindBy(how = How.XPATH, using = "//*[@id=\"books-wrapper\"]/div[3]//button")
    WebElement logOutBtn;

    public void clickTheProfile() {
        cmn.click(driver, prfBtn);
    }

    public boolean validateTheBook() {
        boolean result = bsktBookNameTxt.isDisplayed();
        return result;
    }

    public void deleteTheBookBasket() {
        cmn.click(driver, dltTheBookBtn);
    }

    public void clickThePopUp() throws InterruptedException {
        Thread.sleep(200);
        popUpMdlOkBtn.click();
    }

    public boolean seeTheEmptyUserBasket() {
        boolean result = cmn.Alert(driver);
        return result;
    }

    public void clickTheLogOutBtn(){
        cmn.click(driver,logOutBtn);
    }
}
