package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utils {


        public String getproperty(String Key) throws IOException {
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("C:/Users/vijkiran/IdeaProjects/PlanitTesting/src/test/resources/Planit.properties");
            prop.load(input);
            return prop.getProperty(Key);
        }

        public static void getScreenShot(WebDriver driver) throws IOException {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = ".//target/image.png";
            File destination = new File(path);
            FileUtils.copyFile(file, destination);
        }
}
