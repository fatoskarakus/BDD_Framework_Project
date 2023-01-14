package StepDefinitions;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static BaseClass.BaseClass.launchApp;
import static BaseClass.BaseClass.prop;


public class MyStepdefs {
    IndexPage indexpage;
    ElmntPage elementpage;
    FormPage formPage;
    BooksPage booksPage;

    ProfilePage profilePage;

    @Given("Open the Homepage")
    public void open_the_homepage() throws IOException {
        launchApp();
    }

    @Then("Choose The Card Type")
    public void choose_the_card_type() {
        indexpage = new IndexPage();
        indexpage.clickTheElmntCrd();
    }

    @When("Choose The Element Type")
    public void choose_the_element_type() {
        elementpage = new ElmntPage();
        elementpage.clickTheWebTables();
    }

    @Then("See The Record Table")
    public void see_the_record_table() {
        String text = indexpage.getTittle();
        Assert.assertEquals("Web Tables", text);
    }

    @Then("Click the Add Button")
    public void click_the_add_button() {
        elementpage.clickTheAddBtn();
    }

    @Then("Give the Firstname {string}")
    public void give_the_firstname(String first_name) {
        elementpage.sendTxtAdd(first_name);
    }

    @Then("Give the LastName {string}")
    public void give_the_last_name(String soy_isim) {
        elementpage.sendTxtSoyAdd(soy_isim);
    }

    @Then("Give the Email {string}")
    public void give_the_email(String email) {
        elementpage.sendTxtEmail(email);
    }

    @Then("Give the Age {string}")
    public void give_the_age(String age) {
        elementpage.sendTxtAge(age);
    }

    @Then("Give the Salary {string}")
    public void give_the_salary(String salary) {
        elementpage.sendTxtSlry(salary);
    }

    @Then("Give the Department {string}")
    public void giveTheDepartment(String department) {
        elementpage.sendTxtDepartmnt(department);
    }

    @When("Click the Submit Button")
    public void click_the_submit_button() {
        elementpage.clickSbmtBtn();
    }

    @Then("Delete The New Register")
    public void delete_the_new_register() throws InterruptedException {
        Thread.sleep(500);
        elementpage.deleteTheNewRcrd();
    }

    @And("Choose The Form Type")
    public void choose_the_form_type() {
        indexpage = new IndexPage();
        indexpage.clickTheformCrd();
    }

    @And("Open The Form Page")
    public void open_the_form_page() {
        formPage = new FormPage();
        formPage.clickThePrctiseForm();
    }

    @And("Give the Firstname")
    public void give_the_firstname() throws IOException {
        formPage.sendTheEmpFrstName();
    }

    @And("Give the LastName")
    public void give_the_last_name() {
        formPage.sendTheEmpLstName();
    }

    @And("Give the email")
    public void give_the_email() {
        formPage.sendTheEmail();
    }

    @And("Choose the Gender")
    public void choose_the_gender() {
        formPage.selectGender();
    }

    @And("Give the Mobile Phone")
    public void give_the_mobile_phone() {
        formPage.sendTheMobileLine();
    }

    @And("Choose the BirthDay")
    public void choose_the_birth_day() {
        formPage.choseTheBirtDay();
    }

    @And("Select the Hobbies")
    public void select_the_hobbies() {
        formPage.scltHobies();
    }

    @And("Download the Document")
    public void download_the_document() throws IOException {
        formPage.clcTheDownDocmt();
    }

    @And("Give Current Address")
    public void give_current_address() {
        formPage.sendCrntAdress();
    }

    @When("Click the Submit Btn")
    public void click_the_submit_btn() {
        formPage.sbtBtn();
    }

    @Then("See the New Registration")
    public void see_the_new_registration() {
        String frmName = formPage.verfyTheRecord();
        Assert.assertEquals(frmName, prop.getProperty("recordTittle"));
    }

    @And("I navigate to the Book Store Card")
    public void i_navigate_to_the_book_store_card() {
        indexpage = new IndexPage();
        indexpage.clickTheBookStrApp();
    }

    @And("I navigate to the Login Page")
    public void i_navigate_to_the_login_page() {
        booksPage = new BooksPage();
        booksPage.clickTheBookStoreLgnBtn();
    }

    @When("I submit username and password")
    public void i_submit_username_and_password() {
        booksPage.giveUserNameAndPass();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        String value = booksPage.VerifyTheLogin();
        Assert.assertEquals(value, prop.getProperty("UserName"));
    }

    @And("I navigate to the Book Store")
    public void i_navigate_to_the_book_store() {
        booksPage.goToStorePage();
    }

    @Given("User search for {string}")
    public void user_search_for(String Book) {
        booksPage.searchThePrdct(Book);
        booksPage.clickTheBookLink();
    }

    @When("Add the first book that appears in the search result to the basket")
    public void add_the_first_book_that_appears_in_the_search_result_to_the_basket() {
        booksPage.addTheYourCollection();
    }

    @Then("User basket should display with added item")
    public void user_basket_should_display_with_added_item() throws InterruptedException {
        boolean result = booksPage.seeTheAlert();
        Assert.assertEquals(true, result);
    }

    @Then("Close the App")
    public void close_the_app() {
        booksPage.closeDriver();
    }

    @Given("User navigate for Profile Page")
    public void user_navigate_for_profile_page() {
        profilePage = new ProfilePage();
        profilePage.clickTheProfile();
    }

    @When("See and delete the Book that you added to the basket")
    public void see_and_delete_the_book_that_you_added_to_the_basket() throws InterruptedException {
        boolean result = profilePage.validateTheBook();
        Assert.assertEquals(true, result);
        profilePage.deleteTheBookBasket();
        profilePage.clickThePopUp();
    }

    @Then("User basket should display empty")
    public void user_basket_should_display_empty() {
        boolean alert_result = profilePage.seeTheEmptyUserBasket();
        Assert.assertEquals(false, alert_result);
    }

    @And("I log out from the App")
    public void i_log_out_from_the_app() {
        profilePage=new ProfilePage();
        profilePage.clickTheLogOutBtn();
    }

    @Then("See be log out of the app succesfull")
    public void see_be_log_out_of_the_app_succesfull() {
        String result=booksPage.seeTheWelcmeToLogin();
        Assert.assertEquals(result,prop.getProperty("loginPageTxt"));
    }
}
