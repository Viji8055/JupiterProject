package pages;

import Utils.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactPage {

    utils util = new utils();
    public WebDriver driver;

    public ContactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@id='nav-contact']/a")
    WebElement contactPageHeader;

    @FindBy(xpath = "//div[@class='alert alert-info ng-scope']//strong")
    WebElement welcomeinfo;

    @FindBy(xpath = "//a[@class='btn-contact btn btn-primary']")
    WebElement submitBtnOnContactPage;

    @FindBy(xpath = "//div[@class='alert alert-error ng-scope']")
    WebElement errorHeaderMsg;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    WebElement feedbackSuccessMsg;

    @FindBy(xpath = "//h1[text()=\"Sending Feedback\"]")
    WebElement feedbackPopUp;

    @FindBy(id="forename")
    WebElement foreNameField;

    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="telephone")
    WebElement telephoneField;

    @FindBy(id="message")
    WebElement messageField;

    @FindBy(id = "forename-err")
    WebElement foreNameErrorMsg;

    @FindBy(id="email-err")
    WebElement emailErrorMsg;

    @FindBy(id="message-err")
    WebElement messageFieldError;

    @FindBy(id="telephone-err")
    WebElement telephoneFieldError;



    public void userIsOnContactPage() throws InterruptedException{
        if(contactPageHeader.isDisplayed()){
            contactPageHeader.click();
            Thread.sleep(2000);
            Assert.assertTrue(welcomeinfo.getText().contains("welcome"));
        } }


    public void userClicksOnSubmit() throws InterruptedException {
        if(submitBtnOnContactPage.isDisplayed()){
            submitBtnOnContactPage.click();
        }
    }

    public void errorSubmittingEmptyForm() throws Exception{
        try{
            if(errorHeaderMsg.isDisplayed()){
                System.out.println("Header Error message is displayed as " + errorHeaderMsg.getText());
                if(foreNameErrorMsg.isDisplayed()){
                    System.out.println(foreNameErrorMsg.getText());
                    Assert.assertTrue(foreNameErrorMsg.getText().contains(util.getproperty("forenameErrorMessage")));}
                if(emailErrorMsg.isDisplayed()){
                    System.out.println(emailErrorMsg.getText());
                    Assert.assertTrue(emailErrorMsg.getText().contains(util.getproperty("emailErrorMessage")));}
                if(messageFieldError.isDisplayed()){
                    System.out.println(messageFieldError.getText());
                    Assert.assertTrue(messageFieldError.getText().contains(util.getproperty("messageFieldErrorMsg")));}
                Assert.assertTrue(errorHeaderMsg.getText().contains("unless you complete the form correctly"));
            }
        }
        catch(Exception ex){
            System.out.println("Error Message is not displayed on submitting empty form");
        }
    }

    public void errorsNotDisplayedOnContactPage() throws Exception{
       // waitUntilFeedbackPopUpClosed();
        //Thread.sleep(5000);
        if(feedbackSuccessMsg.isDisplayed())
            Assert.assertTrue(feedbackSuccessMsg.isDisplayed());
    }

    public void errorEnteringInvalidData() throws Exception{
        try{
            if(errorHeaderMsg.isDisplayed()){
                System.out.println("Header Error message is displayed as " + errorHeaderMsg.getText());
                if(emailErrorMsg.isDisplayed()){
                    System.out.println(emailErrorMsg.getText());
                    Assert.assertTrue(emailErrorMsg.getText().contains(util.getproperty("invalidEmailErrorMsg")));}
                if(telephoneFieldError.isDisplayed()){
                    System.out.println(telephoneFieldError.getText());
                    Assert.assertTrue(telephoneFieldError.getText().contains(util.getproperty("invalidPhoneErrorMsg")));}
                Assert.assertTrue(errorHeaderMsg.getText().contains("unless you complete the form correctly"));
            }
        }
        catch(Exception ex){
            System.out.println("Error Message is not displayed on entering invalid data");
        }
    }

    public void verifyfeebackSuccessMsg() throws Exception{
        waitUntilFeedbackPopUpClosed();
        Thread.sleep(5000);
        waitUntilFeedbackPopUpClosed();
        if(feedbackSuccessMsg.isDisplayed())
            Assert.assertTrue(feedbackSuccessMsg.getText().contains("appreciate your feedback"),"Feedback submitted successfully");
    }

    public void waitUntilFeedbackPopUpClosed() throws Exception{
        try{
            if(feedbackPopUp.isDisplayed())
                Thread.sleep(10000);
            else
                System.out.println("feedback pop is closed");
        }
        catch(Exception ex){
            System.out.println("feedback pop is closed");
        }

    }

    public void enterAllMandatoryFieldsOnContactPage() throws Exception{
        try{
            if(foreNameField.isDisplayed()){
                foreNameField.sendKeys(util.getproperty("forename"));
                emailField.sendKeys(util.getproperty("email"));
                messageField.sendKeys(util.getproperty("message"));
                System.out.println("All mandatory fields are entered successfully");
            }
        }
        catch(Exception ex){
            System.out.println("All mandatory fields are not entered successfully");
        }
    }

    public void enterInvalidDataOnContactPage() throws Exception{
        try{
            if(foreNameField.isDisplayed()){
                foreNameField.sendKeys(util.getproperty("invalidforename"));
                emailField.sendKeys(util.getproperty("invalidemail"));
                telephoneField.sendKeys(util.getproperty("invalidPhone"));
            }
        }
        catch(Exception ex){
            System.out.println("All mandatory fields are not entered successfully");
        }
    }

    public void enterForeNameOnContactPage(String foreName){
        try{
            if(foreNameField.isDisplayed()){
                foreNameField.sendKeys(foreName);
                System.out.println("foreName is entered on Contact Page");
            }
        }
        catch(Exception ex){
            System.out.println("foreName is not entered successfully");
        }
    }

    public void enterEmailOnContactPage(String Email){
        try{
            if(emailField.isDisplayed()){
                emailField.sendKeys(Email);
                System.out.println("email is entered on Contact Page");
            }
        }
        catch(Exception ex){
            System.out.println("Email is not entered on Contact Page");
        }
    }

    public void enterMessageOnContactPage(String message){
        try{
            if(messageField.isDisplayed()){
                messageField.sendKeys(message);
                System.out.println("message is entered on Contact Page");
            }

        }
        catch(Exception ex){
            System.out.println("message is not entered on Contact Page");
        }

    }



}
