package pages;

import Utils.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homepage {

    utils util = new utils();
    public WebDriver driver;

    public Homepage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
    }




}
