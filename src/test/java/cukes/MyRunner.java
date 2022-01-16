package cukes;

import Utils.ReportingUtils;
import Utils.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

@CucumberOptions(
        features ={"src/test/resources/jupiter.features/ContactPage.feature"}
        ,glue={"steps"}
        ,plugin = {"pretty",
            "html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json",
            "json:target/cucumber.json",
            "html:target/cucumber-reports/cucumber-pretty"
        }

)

public class MyRunner extends AbstractTestNGCucumberTests {

    public WebDriver driver;
    utils util = new utils();

    @Before
    public void initialSetup() throws IOException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(util.getproperty("url"));
    }

    @AfterSuite
    public void report(){
        ReportingUtils.generateReport();
        }


}
