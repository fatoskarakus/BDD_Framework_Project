package Pages;

import BaseClass.BaseClass;
import CommonLibraries.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass{
    CommonActions cmn=new CommonActions();
         public IndexPage() {
            PageFactory.initElements(driver, this);
        }

    @FindBy(how = How.XPATH, using = "(//div[@class='card mt-4 top-card'])[1]")
    WebElement elmntCrd;

    @FindBy(how = How.XPATH, using = "(//div[@class='card mt-4 top-card'])[2]")
    WebElement formCrd;

    @FindBy(how = How.XPATH, using = "(//div[@class='card mt-4 top-card'])[3]")
    WebElement alrtCrd;

    @FindBy(how = How.XPATH, using = "(//div[@class='card mt-4 top-card'])[4]")
    WebElement wdgtsCrd;

    @FindBy(how = How.XPATH, using = "(//div[@class='card mt-4 top-card'])[5]")
    WebElement intrctnCrd;

    @FindBy(how = How.XPATH, using = "(//div[@class='card mt-4 top-card'])[6]")
    WebElement bookStrApp;

    @FindBy(how = How.CSS, using = "#app > div > div > div > div[class='main-header']")
    WebElement getTitleTxt;

    //Methods
    public void clickTheElmntCrd(){
        elmntCrd.click();
    }
    public void clickTheformCrd(){
        cmn.click(driver,formCrd);
    }
    public void clickTheAlrtCrd(){
        cmn.click(driver,alrtCrd);
    }
    public void clickTheWdgtsCrd(){
        cmn.click(driver,wdgtsCrd);
    }
    public void clickTheIntrctnCrd(){
        cmn.click(driver,intrctnCrd);
    }
    public void clickTheBookStrApp(){
        cmn.scrollDown();
        cmn.click(driver,bookStrApp);
    }
    public String getTittle(){
        String webText=getTitleTxt.getText();
        return webText;
    }
}
