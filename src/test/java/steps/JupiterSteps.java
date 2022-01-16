package steps;

import Utils.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import pages.ContactPage;
import pages.Homepage;
import io.cucumber.java.en.Given;
import pages.Shoppage;

import java.io.File;
import java.io.IOException;

public class JupiterSteps {

    public WebDriver driver;
    public Homepage homepage;
    public ContactPage contactpage;
    public Shoppage shoppage;

    utils util = new utils();

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        homepage= new Homepage(driver);
        contactpage= new ContactPage(driver);
        shoppage= new Shoppage(driver);
        driver.manage().window().maximize();
    }


    @After
    public void closeBrowser(Scenario scenario) throws Exception{
        if(scenario.isFailed()) {
            System.out.println(scenario.getName() + " is failed");
            scenario.log("step failed");
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "failed step");
            utils.getScreenShot(driver);
            }else{
            scenario.log("Scenario is passed");
        }
        driver.quit();
    }

    @Given("^User is on home page$")
    public void verifyUserIsOnHomePage() throws Exception{
        driver.get(util.getproperty("url"));
        System.out.println("Launching Jupiter home page");
    }

    @And("User is on Contact Page")
    public void verifyUserIsOnContactPage() throws Exception{
        contactpage.userIsOnContactPage();
    }

    @And("^User is on Shop Page$")
    public void verifyUserIsOnShopPage() throws Exception{
        shoppage.userIsOnShopPage();
    }

    @When("^User clicks submit button on Contact Page$")
    public void userClicksOnSubmitButton() throws Exception {
        contactpage.userClicksOnSubmit();
    }

    @Then("^Validate Errors are displayed on Contact Page$")
    public void validateErrorsAreDisplayed() throws Exception {
        contactpage.errorSubmittingEmptyForm();
    }

    @Then("^Validate errors are not displayed on Contact Page$")
    public void validateErrorsAreNotDisplayedOnContactPage() throws Exception {
        contactpage.errorsNotDisplayedOnContactPage();
    }

    @Then("^Validate Errors are displayed for invalid data on Contact Page$")
    public void validateErrorsForInvaliddata() throws Exception{
        contactpage.errorEnteringInvalidData();
    }

    @And("^User enters all mandatory fields on Contact Page$")
    public void enterAllMandatoryFieldsOnContactPage() throws Exception{
        contactpage.enterAllMandatoryFieldsOnContactPage();
    }

    @And("^User enters all mandatory fields with invalid data on Contact Page$")
    public void enterAllMandatoryFieldsWithInvaliddata() throws Exception{
        contactpage.enterInvalidDataOnContactPage();
    }

    @When("^User enters forename on Contact Page$")
    public void userEntersForenameOnContactPage() throws IOException {
        String foreName= util.getproperty("forename");
        contactpage.enterForeNameOnContactPage(foreName);
    }

    @And("^User enters email on Contact Page$")
    public void userEntersEmailOnContactPage() throws Exception{
        String email= util.getproperty("email");
        contactpage.enterEmailOnContactPage(email);
    }

    @And("^User enters message on Contact Page$")
    public void userEntersMessageOnContactPage() throws Exception{
        String message= util.getproperty("message");
        contactpage.enterMessageOnContactPage(message);
    }

    @Then("^Validate successful submission message displayed$")
    public void verifySuccessfulfeedbackSubmission() throws Exception{
        contactpage.verifyfeebackSuccessMsg();
    }


    @And("^User adds \"([^\"]*)\" item with \"([^\"]*)\" quantities$")
    public void userAddsItemWithQuantities(String item, String quantities) throws Exception{
        Thread.sleep(2000);
        shoppage.addItemWithQuantities(item,quantities);
    }

    @When("^User clicks on cart menu$")
    public void userClickCartMenu() throws Exception{
        shoppage.clickOnCartMenu();
    }

    @Then("Verify the items are added to cart successfully")
    public void verifyTheItemsAreAddedToCartSuccessfully() throws Exception {
        shoppage.verifyItemsAddedToCart();
    }

    @And("User closes the application")
    public void closeTheApplication(){
        driver.quit();
    }
}
