package Utils;

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

}
